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
            
            cliente.setNomeCompletoCliente(clienteDTO.nomeCompletoCliente);
            cliente.setEmailCliente(clienteDTO.emailCliente);
            cliente.setSenhaCliente(clienteDTO.senhaCliente);
            cliente.setCpfcliente(clienteDTO.cpfcliente);
            cliente.setCelularCliente(clienteDTO.celularCliente);
            cliente.setTelComercialCliente(clienteDTO.telComercialCliente);
            cliente.setTelResidencialCliente(clienteDTO.telResidencialCliente);
            
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
        clientDTO.nomeCompletoCliente = client.getNomeCompletoCliente();
        clientDTO.emailCliente = client.getEmailCliente();
        clientDTO.senhaCliente = client.getSenhaCliente();
        clientDTO.cpfcliente = client.getCpfcliente();
        clientDTO.celularCliente = client.getCelularCliente();
        clientDTO.telComercialCliente = client.getTelComercialCliente();
        clientDTO.telResidencialCliente = client.getTelResidencialCliente();
        clientDTO.dtNascCliente = client.getDtNascCliente();
        clientDTO.recebeNewsLetter = client.getRecebeNewsLetter();
        return clientDTO;
    }
    
    public Cliente getClient(ClientDTO clientDTO) {
        Cliente cliente = new Cliente();
        cliente.setNomeCompletoCliente(clientDTO.nomeCompletoCliente);
        cliente.setEmailCliente(clientDTO.emailCliente);
        cliente.setSenhaCliente(clientDTO.senhaCliente);
        cliente.setCpfcliente(clientDTO.cpfcliente);
        cliente.setCelularCliente(clientDTO.celularCliente);
        cliente.setTelComercialCliente(clientDTO.telComercialCliente);
        cliente.setTelResidencialCliente(clientDTO.telResidencialCliente);
        cliente.setDtNascCliente(clientDTO.dtNascCliente);
        cliente.setRecebeNewsLetter(clientDTO.recebeNewsLetter);
        return cliente;
    }
}
