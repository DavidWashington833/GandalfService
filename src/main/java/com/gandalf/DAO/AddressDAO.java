/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gandalf.DAO;

import com.gandalf.DTO.ClientDTO;
import com.gandalf.DTO.AddressDTO;
import com.gandalf.HibernateUtil;
import com.gandalf.models.Cliente;
import com.gandalf.models.Endereco;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author David Washington
 */
public class AddressDAO {
    private Session session;
    
    public AddressDAO() {
        session = new HibernateUtil().getSession();
    }
    
    public void add(Endereco endereco) {
        try {
            Transaction tx = session.beginTransaction();
            session.save(endereco);
            tx.commit();
        }   
        catch (Exception e) {
        };
    }
    
    public List<Endereco> getForClient(int id) {
        List<Endereco> endereco = new ArrayList<Endereco>();
        endereco = session.createCriteria(Endereco.class)
            .add(Restrictions.eq("cliente.id", id)).list();
        
        return endereco;
    }
    
    public Endereco get(int id) {
        return (Endereco) session.get(Endereco.class, id);
    }

    public void put(Endereco endereco, AddressDTO enderecoDTO) {
        try {
            Transaction tx = session.beginTransaction();
            
            endereco.setNomeEndereco(enderecoDTO.name);
            endereco.setLogradouroEndereco(enderecoDTO.publicPlace);
            endereco.setNumeroEndereco(enderecoDTO.number);
            endereco.setCependereco(enderecoDTO.CEP);
            endereco.setComplementoEndereco(enderecoDTO.complement);
            endereco.setCidadeEndereco(enderecoDTO.city);
            endereco.setPaisEndereco(enderecoDTO.country);
            endereco.setUfendereco(enderecoDTO.UF);
            
            session.save(endereco);
            tx.commit();
        }   
        catch (Exception e) {
        };
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
