package com.gandalf.DAO;

import com.gandalf.DTO.AddressDTO;
import com.gandalf.models.Address;
import java.util.List;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class AddressDAO extends DAO {

    public void add(Address address) {
        try {
            Transaction transaction = session.beginTransaction();
            session.save(address);
            transaction.commit();
        } catch (Exception exception) {
            exception.printStackTrace();
            throw exception;
        }
    }

    public List<Address> getForClient(int id) {
        return session.createCriteria(Address.class).add(Restrictions.eq("client.idClient", id)).list();
    }

    public Address get(int id) {
        return (Address) session.get(Address.class, id);
    }

    public void put(Address address, AddressDTO addressDTO) {
        try {
            Transaction transaction = session.beginTransaction();

            address.setNameAddress(addressDTO.name);
            address.setNumberAddress(addressDTO.number);
            address.setCEPAddress(addressDTO.CEP);
            address.setCityAddress(addressDTO.city);
            address.setCountryAddress(addressDTO.country);

            session.save(address);
            transaction.commit();
        } catch (Exception exception) {
            exception.printStackTrace();
            throw exception;
        }
    }

    public AddressDTO getAddressDTO(Address address) {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.idClient = address.getClient().getIdClient();
        addressDTO.name = address.getNameAddress();
        addressDTO.number = address.getNumberAddress();
        addressDTO.CEP = address.getCEPAddress();
        addressDTO.city = address.getCityAddress();
        addressDTO.country = address.getCountryAddress();
            return addressDTO;
    }

    public Address getAddress(AddressDTO addressDTO) {
        Address address = new Address();
        address.setClient(new ClientDAO().get(addressDTO.idClient));
        address.setNameAddress(addressDTO.name);
        address.setNumberAddress(addressDTO.number);
        address.setCEPAddress(addressDTO.CEP);
        address.setCityAddress(addressDTO.city);
        address.setCountryAddress(addressDTO.country);
        return address;
    }

}
