package com.gandalf.models;

import java.util.HashSet;
import java.util.Set;

public class TypePayment implements java.io.Serializable {

    private int idTypePayment;
    private String descriptionTypePayment;
    private Set requests = new HashSet(0);

    public TypePayment() {
    }

    public TypePayment(byte idTipoPagto, String descTipoPagto) {
        this.idTypePayment = idTipoPagto;
        this.descriptionTypePayment = descTipoPagto;
    }

    public TypePayment(byte idTipoPagto, String descTipoPagto, Set pedidos) {
        this.idTypePayment = idTipoPagto;
        this.descriptionTypePayment = descTipoPagto;
        this.requests = pedidos;
    }

    public int getIdTypePayment() {
        return this.idTypePayment;
    }

    public void setIdTypePayment(int idTypePayment) {
        this.idTypePayment = idTypePayment;
    }

    public String getDescriptionTypePayment() {
        return this.descriptionTypePayment;
    }

    public void setDescriptionTypePayment(String descriptionTypePayment) {
        this.descriptionTypePayment = descriptionTypePayment;
    }

    public Set getRequests() {
        return this.requests;
    }

    public void setRequests(Set requests) {
        this.requests = requests;
    }

}
