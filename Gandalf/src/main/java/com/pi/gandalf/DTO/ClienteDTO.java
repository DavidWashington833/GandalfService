/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.gandalf.DTO;

import com.pi.gandalf.models.Cliente;
import java.util.Date;

/**
 *
 * @author Silva
 */
public class ClienteDTO {
     public String nomeCompletoCliente;
     public String emailCliente;
     public String senhaCliente;
     public String cpfcliente;
     public String celularCliente;
     public String telComercialCliente;
     public String telResidencialCliente;
     public Date dtNascCliente;
     public Boolean recebeNewsLetter;
	
    public ClienteDTO() {}
   
    public ClienteDTO(Cliente cliente) {
        this.nomeCompletoCliente = cliente.getNomeCompletoCliente();
        this.emailCliente = cliente.getEmailCliente();
        this.senhaCliente = cliente.getSenhaCliente();
        this.cpfcliente = cliente.getCpfcliente();
        this.celularCliente = cliente.getCelularCliente();
        this.telComercialCliente = cliente.getTelComercialCliente();
        this.telResidencialCliente = cliente.getTelResidencialCliente();
        this.dtNascCliente = cliente.getDtNascCliente();
        this.recebeNewsLetter = cliente.getRecebeNewsLetter();
    }
    
    public Cliente getCliente() {
        Cliente cliente = new Cliente();
        cliente.setNomeCompletoCliente(this.nomeCompletoCliente);
        cliente.setEmailCliente(this.emailCliente);
        cliente.setSenhaCliente(this.senhaCliente);
        cliente.setCpfcliente(this.cpfcliente);
        cliente.setCelularCliente(this.celularCliente);
        cliente.setTelComercialCliente(this.telComercialCliente);
        cliente.setTelResidencialCliente(this.telResidencialCliente);
        cliente.setDtNascCliente(this.dtNascCliente);
        cliente.setRecebeNewsLetter(this.recebeNewsLetter);
        return cliente;
    }
    
    public String getNomeCompletoCliente() {
        return nomeCompletoCliente;
    }

    public void setNomeCompletoCliente(String nomeCompletoCliente) {
        this.nomeCompletoCliente = nomeCompletoCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getSenhaCliente() {
        return senhaCliente;
    }

    public void setSenhaCliente(String senhaCliente) {
        this.senhaCliente = senhaCliente;
    }

    public String getCpfcliente() {
        return cpfcliente;
    }

    public void setCpfcliente(String cpfcliente) {
        this.cpfcliente = cpfcliente;
    }

    public String getCelularCliente() {
        return celularCliente;
    }

    public void setCelularCliente(String celularCliente) {
        this.celularCliente = celularCliente;
    }

    public String getTelComercialCliente() {
        return telComercialCliente;
    }

    public void setTelComercialCliente(String telComercialCliente) {
        this.telComercialCliente = telComercialCliente;
    }

    public String getTelResidencialCliente() {
        return telResidencialCliente;
    }

    public void setTelResidencialCliente(String telResidencialCliente) {
        this.telResidencialCliente = telResidencialCliente;
    }

    public Date getDtNascCliente() {
        return dtNascCliente;
    }

    public void setDtNascCliente(Date dtNascCliente) {
        this.dtNascCliente = dtNascCliente;
    }

    public Boolean getRecebeNewsLetter() {
        return recebeNewsLetter;
    }

    public void setRecebeNewsLetter(Boolean recebeNewsLetter) {
        this.recebeNewsLetter = recebeNewsLetter;
    }

}
