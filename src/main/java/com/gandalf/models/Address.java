package com.gandalf.models;

import java.util.HashSet;
import java.util.Set;

public class Address implements java.io.Serializable {

    private int idAddress;
    private Client client;
    private String nameAddress;
    private String numberAddress;
    private String CEPAddress;
    private String cityAddress;
    private String countryAddress;
    private String ufendereco;
    private Set request = new HashSet(0);

    public Address() {
    }

    public Address(int idEndereco, Client cliente, String nomeEndereco, String logradouroEndereco, String numeroEndereco, String cependereco, String cidadeEndereco) {
        this.idAddress = idEndereco;
        this.client = cliente;
        this.nameAddress = nomeEndereco;
        this.numberAddress = numeroEndereco;
        this.CEPAddress = cependereco;
        this.cityAddress = cidadeEndereco;
    }

    public Address(int idEndereco, Client cliente, String nomeEndereco, String logradouroEndereco, String numeroEndereco, String cependereco, String complementoEndereco, String cidadeEndereco, String paisEndereco, String ufendereco, Set pedidos) {
        this.idAddress = idEndereco;
        this.client = cliente;
        this.nameAddress = nomeEndereco;
        this.numberAddress = numeroEndereco;
        this.CEPAddress = cependereco;
        this.cityAddress = cidadeEndereco;
        this.countryAddress = paisEndereco;
        this.ufendereco = ufendereco;
        this.request = pedidos;
    }

    public int getIdAddress() {
        return this.idAddress;
    }

    public void setIdAddress(int idAddress) {
        this.idAddress = idAddress;
    }

    public Client getClient() {
        return this.client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getNameAddress() {
        return this.nameAddress;
    }

    public void setNameAddress(String nameAddress) {
        this.nameAddress = nameAddress;
    }

    public String getNumberAddress() {
        return this.numberAddress;
    }

    public void setNumberAddress(String numberAddress) {
        this.numberAddress = numberAddress;
    }

    public String getCEPAddress() {
        return this.CEPAddress;
    }

    public void setCEPAddress(String CEPAddress) {
        this.CEPAddress = CEPAddress;
    }

    public String getCityAddress() {
        return this.cityAddress;
    }

    public void setCityAddress(String cityAddress) {
        this.cityAddress = cityAddress;
    }

    public String getCountryAddress() {
        return this.countryAddress;
    }

    public void setCountryAddress(String countryAddress) {
        this.countryAddress = countryAddress;
    }

    public String getUfendereco() {
        return this.ufendereco;
    }

    public void setUfendereco(String ufendereco) {
        this.ufendereco = ufendereco;
    }

    public Set getRequest() {
        return this.request;
    }

    public void setRequest(Set request) {
        this.request = request;
    }

}
