/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gandalf.DAO;

import com.gandalf.DTO.ClientDTO;
import com.gandalf.DTO.Endereco2DTO;
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
    
    public List<Endereco> getForCliente(int id) {
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
            
            endereco.setNomeEndereco(enderecoDTO.nomeEndereco);
            endereco.setLogradouroEndereco(enderecoDTO.logradouroEndereco);
            endereco.setNumeroEndereco(enderecoDTO.numeroEndereco);
            endereco.setCependereco(enderecoDTO.CEPEndereco);
            endereco.setComplementoEndereco(enderecoDTO.complementoEndereco);
            endereco.setCidadeEndereco(enderecoDTO.cidadeEndereco);
            endereco.setPaisEndereco(enderecoDTO.paisEndereco);
            endereco.setUfendereco(enderecoDTO.UFEndereco);
            
            session.save(endereco);
            tx.commit();
        }   
        catch (Exception e) {
        };
    }
    
    public AddressDTO getAddressDTO(Endereco address) {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.idCliente = address.getCliente().getIdCliente();
        addressDTO.nomeEndereco = address.getNomeEndereco();
        addressDTO.logradouroEndereco = address.getLogradouroEndereco();
        addressDTO.numeroEndereco = address.getNumeroEndereco();
        addressDTO.CEPEndereco = address.getCependereco();
        addressDTO.complementoEndereco = address.getComplementoEndereco();
        addressDTO.cidadeEndereco = address.getCidadeEndereco();
        addressDTO.paisEndereco = address.getPaisEndereco();
        addressDTO.UFEndereco = address.getUfendereco();
        return addressDTO;
    }
    
    public Endereco getAddressDTO(AddressDTO addressDTO) {
        Endereco address = new Endereco();
        address.setCliente(new ClientDAO().get(addressDTO.idCliente));
        address.setNomeEndereco(addressDTO.nomeEndereco);
        address.setLogradouroEndereco(addressDTO.logradouroEndereco);
        address.setNumeroEndereco(addressDTO.numeroEndereco);
        address.setCependereco(addressDTO.CEPEndereco);
        address.setComplementoEndereco(addressDTO.complementoEndereco);
        address.setCidadeEndereco(addressDTO.cidadeEndereco);
        address.setPaisEndereco(addressDTO.paisEndereco);
        address.setUfendereco(addressDTO.UFEndereco);
        return address;
    }
}
