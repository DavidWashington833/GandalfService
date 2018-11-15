package com.gandalf.DAO;

import com.gandalf.DTO.AddressDTO;
import com.gandalf.models.Endereco;
import java.util.List;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class AddressDAO extends DAO {

    public void add(Endereco address) {
        try {
            Transaction transaction = session.beginTransaction();
            session.save(address);
            transaction.commit();
        } catch (Exception exception) {
            exception.printStackTrace();
            throw exception;
        }
    }

    public List<Endereco> getForClient(int id) {
        return session.createCriteria(Endereco.class).add(Restrictions.eq("cliente.id", id)).list();
    }

    public Endereco get(int id) {
        return (Endereco) session.get(Endereco.class, id);
    }

    public void put(Endereco address, AddressDTO addressDTO) {
        try {
            Transaction transaction = session.beginTransaction();

            address.setNomeEndereco(addressDTO.name);
            address.setLogradouroEndereco(addressDTO.publicPlace);
            address.setNumeroEndereco(addressDTO.number);
            address.setCependereco(addressDTO.CEP);
            address.setComplementoEndereco(addressDTO.complement);
            address.setCidadeEndereco(addressDTO.city);
            address.setPaisEndereco(addressDTO.country);
            address.setUfendereco(addressDTO.UF);

            session.save(address);
            transaction.commit();
        } catch (Exception exception) {
            exception.printStackTrace();
            throw exception;
        }
    }

    public AddressDTO getAddressDTO(Endereco address) {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.idClient = address.getCliente().getIdCliente();
        addressDTO.name = address.getNomeEndereco();
        addressDTO.publicPlace = address.getLogradouroEndereco();
        addressDTO.number = address.getNumeroEndereco();
        addressDTO.CEP = address.getCependereco();
        addressDTO.complement = address.getComplementoEndereco();
        addressDTO.city = address.getCidadeEndereco();
        addressDTO.country = address.getPaisEndereco();
        addressDTO.UF = address.getUfendereco();
        return addressDTO;
    }

    public Endereco getAddress(AddressDTO addressDTO) {
        Endereco address = new Endereco();
        address.setCliente(new ClientDAO().get(addressDTO.idClient));
        address.setNomeEndereco(addressDTO.name);
        address.setLogradouroEndereco(addressDTO.publicPlace);
        address.setNumeroEndereco(addressDTO.number);
        address.setCependereco(addressDTO.CEP);
        address.setComplementoEndereco(addressDTO.complement);
        address.setCidadeEndereco(addressDTO.city);
        address.setPaisEndereco(addressDTO.country);
        address.setUfendereco(addressDTO.UF);
        return address;
    }

}
