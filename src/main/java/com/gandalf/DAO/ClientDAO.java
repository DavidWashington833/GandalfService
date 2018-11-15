/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gandalf.DAO;

import com.gandalf.DTO.ClientDTO;
import com.gandalf.HibernateUtil;
import com.gandalf.models.Cliente;
import com.gandalf.models.Produto;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author david.wfsilva
 */
public class ClientDAO {
    private Session session;
    
    public ClientDAO() {
        session = new HibernateUtil().getSession();
    }
    
    public void add(Cliente cliente) {
        try {
            Transaction tx = session.beginTransaction();
            session.save(cliente);
            tx.commit();
        }   
        catch (Exception e) {
        };
    }
    
    public Cliente get(int id) {
        return (Cliente) session.get(Cliente.class, id);
    }
    
    public Cliente get(String email, String password) {
        Cliente cliente = null;
        List<Cliente> clientes = session.createCriteria(Cliente.class)
            .add(Restrictions.eq("emailCliente", email))
            .add(Restrictions.eq("senhaCliente", password)).list();
        if (clientes.size() > 0) {
            cliente = clientes.get(0);
        }
        
        return cliente;
    }

    public void put(Cliente cliente, ClientDTO clienteDTO) {
        try {
            Transaction tx = session.beginTransaction();
            
            cliente.setNomeCompletoCliente(clienteDTO.fullName);
            cliente.setEmailCliente(clienteDTO.email);
            cliente.setSenhaCliente(clienteDTO.password);
            cliente.setCpfcliente(clienteDTO.CPF);
            cliente.setCelularCliente(clienteDTO.cellPhone);
            cliente.setTelComercialCliente(clienteDTO.commercialPhone);
            cliente.setTelResidencialCliente(clienteDTO.homePhone);
            
            session.save(cliente);
            tx.commit();
        }   
        catch (Exception e) {
        };
    }
    
    public boolean hasEmail(String email) {
        List<Cliente> clients = session
            .createCriteria(Cliente.class)
            .add(Restrictions.eq("emailCliente", email))
            .list();
        
        return clients.size() > 0;
    }

    public boolean hasCPF(String CPF) {
        List<Cliente> clients = session
            .createCriteria(Cliente.class)
            .add(Restrictions.eq("cpfcliente", CPF))
            .list();
        
        return clients.size() > 0;
    }
    
    public ClientDTO getClientDTO(Cliente client) {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.fullName = client.getNomeCompletoCliente();
        clientDTO.email = client.getEmailCliente();
        clientDTO.password = client.getSenhaCliente();
        clientDTO.CPF = client.getCpfcliente();
        clientDTO.cellPhone = client.getCelularCliente();
        clientDTO.commercialPhone = client.getTelComercialCliente();
        clientDTO.homePhone = client.getTelResidencialCliente();
        clientDTO.birthDay = client.getDtNascCliente();
        clientDTO.acceptNewsletter = client.getRecebeNewsLetter();
        return clientDTO;
    }
    
    public Cliente getClient(ClientDTO clientDTO) {
        Cliente cliente = new Cliente();
        cliente.setNomeCompletoCliente(clientDTO.fullName);
        cliente.setEmailCliente(clientDTO.email);
        cliente.setSenhaCliente(clientDTO.password);
        cliente.setCpfcliente(clientDTO.CPF);
        cliente.setCelularCliente(clientDTO.cellPhone);
        cliente.setTelComercialCliente(clientDTO.commercialPhone);
        cliente.setTelResidencialCliente(clientDTO.homePhone);
        cliente.setDtNascCliente(clientDTO.birthDay);
        cliente.setRecebeNewsLetter(clientDTO.acceptNewsletter);
        return cliente;
    }
}
