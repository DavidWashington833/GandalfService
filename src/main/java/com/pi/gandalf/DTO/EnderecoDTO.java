/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.gandalf.DTO;

import com.pi.gandalf.DAO.ClienteDAO;
import com.pi.gandalf.models.Cliente;
import com.pi.gandalf.models.Endereco;

/**
 *
 * @author Silva
 */
public class EnderecoDTO {    
    public int idCliente;
    public String nomeEndereco;
    public String logradouroEndereco;
    public String numeroEndereco;
    public String CEPEndereco;
    public String complementoEndereco;
    public String cidadeEndereco;
    public String paisEndereco;
    public String UFEndereco;
    
    public EnderecoDTO() {}
   
    public EnderecoDTO(Endereco endereco) {
        this.idCliente = endereco.getCliente().getIdCliente();
        this.nomeEndereco = endereco.getNomeEndereco();
        this.logradouroEndereco = endereco.getLogradouroEndereco();
        this.numeroEndereco = endereco.getNumeroEndereco();
        this.CEPEndereco = endereco.getCependereco();
        this.complementoEndereco = endereco.getComplementoEndereco();
        this.cidadeEndereco = endereco.getCidadeEndereco();
        this.paisEndereco = endereco.getPaisEndereco();
        this.UFEndereco = endereco.getUfendereco();
    }
    
    public Endereco getEndereco() {
        Endereco endereco = new Endereco();
        endereco.setCliente(new ClienteDAO().get(this.idCliente));
        endereco.setNomeEndereco(this.nomeEndereco);
        endereco.setLogradouroEndereco(this.logradouroEndereco);
        endereco.setNumeroEndereco(this.numeroEndereco);
        endereco.setCependereco(this.CEPEndereco);
        endereco.setComplementoEndereco(this.complementoEndereco);
        endereco.setCidadeEndereco(this.cidadeEndereco);
        endereco.setPaisEndereco(this.paisEndereco);
        endereco.setUfendereco(this.UFEndereco);
        return endereco;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeEndereco() {
        return nomeEndereco;
    }

    public void setNomeEndereco(String nomeEndereco) {
        this.nomeEndereco = nomeEndereco;
    }

    public String getLogradouroEndereco() {
        return logradouroEndereco;
    }

    public void setLogradouroEndereco(String logradouroEndereco) {
        this.logradouroEndereco = logradouroEndereco;
    }

    public String getNumeroEndereco() {
        return numeroEndereco;
    }

    public void setNumeroEndereco(String numeroEndereco) {
        this.numeroEndereco = numeroEndereco;
    }

    public String getCEPEndereco() {
        return CEPEndereco;
    }

    public void setCEPEndereco(String CEPEndereco) {
        this.CEPEndereco = CEPEndereco;
    }

    public String getComplementoEndereco() {
        return complementoEndereco;
    }

    public void setComplementoEndereco(String complementoEndereco) {
        this.complementoEndereco = complementoEndereco;
    }

    public String getCidadeEndereco() {
        return cidadeEndereco;
    }

    public void setCidadeEndereco(String cidadeEndereco) {
        this.cidadeEndereco = cidadeEndereco;
    }

    public String getPaisEndereco() {
        return paisEndereco;
    }

    public void setPaisEndereco(String paisEndereco) {
        this.paisEndereco = paisEndereco;
    }

    public String getUFEndereco() {
        return UFEndereco;
    }

    public void setUFEndereco(String UFEndereco) {
        this.UFEndereco = UFEndereco;
    }
    
    
}
