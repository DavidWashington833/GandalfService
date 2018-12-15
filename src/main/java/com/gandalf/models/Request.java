package com.gandalf.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
public class Request implements java.io.Serializable {

    private int idRequest;
    private Application application;
    private Client client;
    private Address address;
    private StatusRequest statusRequest;
    private TypePayment typePayment;
    private Date dateRequest;
    private Set itemRequests = new HashSet(0);

    public Request() {
    }

    public Request(int idPedido, Application aplicacao, Client cliente, StatusRequest statusPedido, TypePayment tipoPagamento, Date dataPedido) {
        this.idRequest = idPedido;
        this.application = aplicacao;
        this.client = cliente;
        this.statusRequest = statusPedido;
        this.typePayment = tipoPagamento;
        this.dateRequest = dataPedido;
    }

    public Request(int idPedido, Application aplicacao, Client cliente, Address endereco, StatusRequest statusPedido, TypePayment tipoPagamento, Date dataPedido, Set itemPedidos) {
        this.idRequest = idPedido;
        this.application = aplicacao;
        this.client = cliente;
        this.address = endereco;
        this.statusRequest = statusPedido;
        this.typePayment = tipoPagamento;
        this.dateRequest = dataPedido;
        this.itemRequests = itemPedidos;
    }

    public int getIdRequest() {
        return this.idRequest;
    }

    public void setIdRequest(int idRequest) {
        this.idRequest = idRequest;
    }

    public Application getApplication() {
        return this.application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public Client getClient() {
        return this.client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public StatusRequest getStatusRequest() {
        return this.statusRequest;
    }

    public void setStatusRequest(StatusRequest statusRequest) {
        this.statusRequest = statusRequest;
    }

    public TypePayment getTypePayment() {
        return this.typePayment;
    }

    public void setTypePayment(TypePayment typePayment) {
        this.typePayment = typePayment;
    }

    public Date getDateRequest() {
        return this.dateRequest;
    }

    public void setDateRequest(Date dateRequest) {
        this.dateRequest = dateRequest;
    }

    public Set getItemRequests() {
        return this.itemRequests;
    }

    public void setItemRequests(Set itemRequests) {
        this.itemRequests = itemRequests;
    }

}
