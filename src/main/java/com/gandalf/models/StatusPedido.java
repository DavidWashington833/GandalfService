package com.gandalf.models;

import java.util.HashSet;
import java.util.Set;

public class StatusPedido implements java.io.Serializable {

    private byte idStatus;
    private String descStatus;
    private Set pedidos = new HashSet(0);

    public StatusPedido() {
    }

    public StatusPedido(byte idStatus, String descStatus) {
        this.idStatus = idStatus;
        this.descStatus = descStatus;
    }

    public StatusPedido(byte idStatus, String descStatus, Set pedidos) {
        this.idStatus = idStatus;
        this.descStatus = descStatus;
        this.pedidos = pedidos;
    }

    public byte getIdStatus() {
        return this.idStatus;
    }

    public void setIdStatus(byte idStatus) {
        this.idStatus = idStatus;
    }

    public String getDescStatus() {
        return this.descStatus;
    }

    public void setDescStatus(String descStatus) {
        this.descStatus = descStatus;
    }

    public Set getPedidos() {
        return this.pedidos;
    }

    public void setPedidos(Set pedidos) {
        this.pedidos = pedidos;
    }

}
