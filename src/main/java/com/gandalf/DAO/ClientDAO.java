package com.gandalf.DAO;

import com.gandalf.DTO.ClientDTO;
import com.gandalf.models.Client;
import java.util.List;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class ClientDAO extends DAO {

    public void add(Client client) {
        try {
            Transaction transaction = session.beginTransaction();
            session.save(client);
            transaction.commit();
        } catch (Exception exception) {
            exception.printStackTrace();
            throw exception;
        }
    }

    public Client get(int id) {
        return (Client) session.get(Client.class, id);
    }

    public Client get(String email, String password) {
        Client client = null;

        List<Client> clients = session
                .createCriteria(Client.class)
                .add(Restrictions.eq("emailClient", email))
                .add(Restrictions.eq("passwordClient", password))
                .list();

        if (clients.size() > 0) {
            client = clients.get(0);
        }

        return client;
    }

    public void put(Client client, ClientDTO clientDTO) {
        try {
            Transaction transaction = session.beginTransaction();

            client.setFullNameClient(clientDTO.fullName);
            client.setEmailClient(clientDTO.email);
            client.setPasswordClient(clientDTO.password);
            client.setCPFClient(clientDTO.CPF);
            client.setPhoneClient(clientDTO.phone);

            session.save(client);
            transaction.commit();
        } catch (Exception exception) {
            exception.printStackTrace();
            throw exception;
        }
    }

    public boolean hasEmail(String email) {
        List<Client> clients = session
                .createCriteria(Client.class)
                .add(Restrictions.eq("emailClient", email))
                .list();

        return clients.size() > 0;
    }

    public boolean hasCPF(String CPF) {
        List<Client> clients = session
                .createCriteria(Client.class)
                .add(Restrictions.eq("CPFClient", CPF))
                .list();

        return clients.size() > 0;
    }

    public ClientDTO getClientDTO(Client client) {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.fullName = client.getFullNameClient();
        clientDTO.email = client.getEmailClient();
        clientDTO.password = client.getPasswordClient();
        clientDTO.CPF = client.getCPFClient();
        clientDTO.phone = client.getPhoneClient();
        clientDTO.birthDay = client.getBirthDayClient();
        clientDTO.newsLetter = client.getNewsLetterClient();
        return clientDTO;
    }

    public Client getClient(ClientDTO clientDTO) {
        Client client = new Client();
        client.setFullNameClient(clientDTO.fullName);
        client.setEmailClient(clientDTO.email);
        client.setPasswordClient(clientDTO.password);
        client.setCPFClient(clientDTO.CPF);
        client.setPhoneClient(clientDTO.phone);
        client.setBirthDayClient(clientDTO.birthDay);
        client.setNewsLetterClient(clientDTO.newsLetter);
        return client;
    }

}
