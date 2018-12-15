package com.gandalf.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Client implements java.io.Serializable {

    private int idClient;
    private String fullNameClient;
    private String emailClient;
    private String passwordClient;
    private String CPFClient;
    private String phoneClient;
    private Date birthDayClient;
    private Boolean newsLetterClient;
    private Set requests = new HashSet(0);
    private Set address = new HashSet(0);

    public Client() {
    }

    public Client(int idCliente, String nomeCompletoCliente, String emailCliente, String senhaCliente, String cpfcliente) {
        this.idClient = idCliente;
        this.fullNameClient = nomeCompletoCliente;
        this.emailClient = emailCliente;
        this.passwordClient = senhaCliente;
        this.CPFClient = cpfcliente;
    }

    public Client(int idCliente, String nomeCompletoCliente, String emailCliente, String senhaCliente, String cpfcliente, String celularCliente, String telComercialCliente, String telResidencialCliente, Date dtNascCliente, Boolean recebeNewsLetter, Set pedidos, Set enderecos) {
        this.idClient = idCliente;
        this.fullNameClient = nomeCompletoCliente;
        this.emailClient = emailCliente;
        this.passwordClient = senhaCliente;
        this.CPFClient = cpfcliente;
        this.phoneClient = celularCliente;
        this.birthDayClient = dtNascCliente;
        this.newsLetterClient = recebeNewsLetter;
        this.requests = pedidos;
        this.address = enderecos;
    }

    public int getIdClient() {
        return this.idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getFullNameClient() {
        return this.fullNameClient;
    }

    public void setFullNameClient(String fullNameClient) {
        this.fullNameClient = fullNameClient;
    }

    public String getEmailClient() {
        return this.emailClient;
    }

    public void setEmailClient(String emailClient) {
        this.emailClient = emailClient;
    }

    public String getPasswordClient() {
        return this.passwordClient;
    }

    public void setPasswordClient(String passwordClient) {
        this.passwordClient = passwordClient;
    }

    public String getCPFClient() {
        return this.CPFClient;
    }

    public void setCPFClient(String CPFClient) {
        this.CPFClient = CPFClient;
    }

    public String getPhoneClient() {
        return this.phoneClient;
    }

    public void setPhoneClient(String phoneClient) {
        this.phoneClient = phoneClient;
    }

    public Date getBirthDayClient() {
        return this.birthDayClient;
    }

    public void setBirthDayClient(Date birthDayClient) {
        this.birthDayClient = birthDayClient;
    }

    public Boolean getNewsLetterClient() {
        return this.newsLetterClient;
    }

    public void setNewsLetterClient(Boolean newsLetterClient) {
        this.newsLetterClient = newsLetterClient;
    }

    public Set getRequests() {
        return this.requests;
    }

    public void setRequests(Set requests) {
        this.requests = requests;
    }

    public Set getAddress() {
        return this.address;
    }

    public void setAddress(Set address) {
        this.address = address;
    }

}
