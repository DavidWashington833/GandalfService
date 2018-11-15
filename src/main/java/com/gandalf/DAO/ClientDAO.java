package com.gandalf.DAO;

import com.gandalf.DTO.ClientDTO;
import com.gandalf.models.Cliente;
import java.util.List;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class ClientDAO extends DAO {

    public void add(Cliente client) {
        try {
            Transaction transaction = session.beginTransaction();
            session.save(client);
            transaction.commit();
        } catch (Exception exception) {
            exception.printStackTrace();
            throw exception;
        }
    }

    public Cliente get(int id) {
        return (Cliente) session.get(Cliente.class, id);
    }

    public Cliente get(String email, String password) {
        Cliente client = null;

        List<Cliente> clientes = session
                .createCriteria(Cliente.class)
                .add(Restrictions.eq("emailCliente", email))
                .add(Restrictions.eq("senhaCliente", password))
                .list();

        if (clientes.size() > 0) {
            client = clientes.get(0);
        }

        return client;
    }

    public void put(Cliente client, ClientDTO clientDTO) {
        try {
            Transaction transaction = session.beginTransaction();

            client.setNomeCompletoCliente(clientDTO.fullName);
            client.setEmailCliente(clientDTO.email);
            client.setSenhaCliente(clientDTO.password);
            client.setCpfcliente(clientDTO.CPF);
            client.setCelularCliente(clientDTO.cellPhone);
            client.setTelComercialCliente(clientDTO.commercialPhone);
            client.setTelResidencialCliente(clientDTO.homePhone);

            session.save(client);
            transaction.commit();
        } catch (Exception exception) {
            exception.printStackTrace();
            throw exception;
        }
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
        Cliente client = new Cliente();
        client.setNomeCompletoCliente(clientDTO.fullName);
        client.setEmailCliente(clientDTO.email);
        client.setSenhaCliente(clientDTO.password);
        client.setCpfcliente(clientDTO.CPF);
        client.setCelularCliente(clientDTO.cellPhone);
        client.setTelComercialCliente(clientDTO.commercialPhone);
        client.setTelResidencialCliente(clientDTO.homePhone);
        client.setDtNascCliente(clientDTO.birthDay);
        client.setRecebeNewsLetter(clientDTO.acceptNewsletter);
        return client;
    }

}
