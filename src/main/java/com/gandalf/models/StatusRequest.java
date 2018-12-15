package com.gandalf.models;

import java.util.HashSet;
import java.util.Set;

public class StatusRequest implements java.io.Serializable {

    private byte idStatus;
    private String descriptionStatus;
    private Set requests = new HashSet(0);

    public StatusRequest() {
    }

    public StatusRequest(byte idStatus, String descStatus) {
        this.idStatus = idStatus;
        this.descriptionStatus = descStatus;
    }

    public StatusRequest(byte idStatus, String descStatus, Set pedidos) {
        this.idStatus = idStatus;
        this.descriptionStatus = descStatus;
        this.requests = pedidos;
    }

    public byte getIdStatus() {
        return this.idStatus;
    }

    public void setIdStatus(byte idStatus) {
        this.idStatus = idStatus;
    }

    public String getDescriptionStatus() {
        return this.descriptionStatus;
    }

    public void setDescriptionStatus(String descriptionStatus) {
        this.descriptionStatus = descriptionStatus;
    }

    public Set getRequests() {
        return this.requests;
    }

    public void setRequests(Set requests) {
        this.requests = requests;
    }

}
