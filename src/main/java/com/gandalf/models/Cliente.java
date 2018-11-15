package com.gandalf.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Cliente implements java.io.Serializable {

    private int idCliente;
    private String nomeCompletoCliente;
    private String emailCliente;
    private String senhaCliente;
    private String cpfcliente;
    private String celularCliente;
    private String telComercialCliente;
    private String telResidencialCliente;
    private Date dtNascCliente;
    private Boolean recebeNewsLetter;
    private Set pedidos = new HashSet(0);
    private Set enderecos = new HashSet(0);

    public Cliente() {
    }

    public Cliente(int idCliente, String nomeCompletoCliente, String emailCliente, String senhaCliente, String cpfcliente) {
        this.idCliente = idCliente;
        this.nomeCompletoCliente = nomeCompletoCliente;
        this.emailCliente = emailCliente;
        this.senhaCliente = senhaCliente;
        this.cpfcliente = cpfcliente;
    }

    public Cliente(int idCliente, String nomeCompletoCliente, String emailCliente, String senhaCliente, String cpfcliente, String celularCliente, String telComercialCliente, String telResidencialCliente, Date dtNascCliente, Boolean recebeNewsLetter, Set pedidos, Set enderecos) {
        this.idCliente = idCliente;
        this.nomeCompletoCliente = nomeCompletoCliente;
        this.emailCliente = emailCliente;
        this.senhaCliente = senhaCliente;
        this.cpfcliente = cpfcliente;
        this.celularCliente = celularCliente;
        this.telComercialCliente = telComercialCliente;
        this.telResidencialCliente = telResidencialCliente;
        this.dtNascCliente = dtNascCliente;
        this.recebeNewsLetter = recebeNewsLetter;
        this.pedidos = pedidos;
        this.enderecos = enderecos;
    }

    public int getIdCliente() {
        return this.idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeCompletoCliente() {
        return this.nomeCompletoCliente;
    }

    public void setNomeCompletoCliente(String nomeCompletoCliente) {
        this.nomeCompletoCliente = nomeCompletoCliente;
    }

    public String getEmailCliente() {
        return this.emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getSenhaCliente() {
        return this.senhaCliente;
    }

    public void setSenhaCliente(String senhaCliente) {
        this.senhaCliente = senhaCliente;
    }

    public String getCpfcliente() {
        return this.cpfcliente;
    }

    public void setCpfcliente(String cpfcliente) {
        this.cpfcliente = cpfcliente;
    }

    public String getCelularCliente() {
        return this.celularCliente;
    }

    public void setCelularCliente(String celularCliente) {
        this.celularCliente = celularCliente;
    }

    public String getTelComercialCliente() {
        return this.telComercialCliente;
    }

    public void setTelComercialCliente(String telComercialCliente) {
        this.telComercialCliente = telComercialCliente;
    }

    public String getTelResidencialCliente() {
        return this.telResidencialCliente;
    }

    public void setTelResidencialCliente(String telResidencialCliente) {
        this.telResidencialCliente = telResidencialCliente;
    }

    public Date getDtNascCliente() {
        return this.dtNascCliente;
    }

    public void setDtNascCliente(Date dtNascCliente) {
        this.dtNascCliente = dtNascCliente;
    }

    public Boolean getRecebeNewsLetter() {
        return this.recebeNewsLetter;
    }

    public void setRecebeNewsLetter(Boolean recebeNewsLetter) {
        this.recebeNewsLetter = recebeNewsLetter;
    }

    public Set getPedidos() {
        return this.pedidos;
    }

    public void setPedidos(Set pedidos) {
        this.pedidos = pedidos;
    }

    public Set getEnderecos() {
        return this.enderecos;
    }

    public void setEnderecos(Set enderecos) {
        this.enderecos = enderecos;
    }

}
