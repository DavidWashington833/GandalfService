package com.gandalf.models;

import java.util.HashSet;
import java.util.Set;

public class Application implements java.io.Serializable {

    private byte idApplication;
    private String descriptionApplication;
    private char typeApplication;
    private Set requests = new HashSet(0);

    public Application() {
    }

    public Application(byte idAplicacao, String descAplicacao, char tipoAplicacao) {
        this.idApplication = idAplicacao;
        this.descriptionApplication = descAplicacao;
        this.typeApplication = tipoAplicacao;
    }

    public Application(byte idAplicacao, String descAplicacao, char tipoAplicacao, Set pedidos) {
        this.idApplication = idAplicacao;
        this.descriptionApplication = descAplicacao;
        this.typeApplication = tipoAplicacao;
        this.requests = pedidos;
    }

    public byte getIdApplication() {
        return this.idApplication;
    }

    public void setIdApplication(byte idApplication) {
        this.idApplication = idApplication;
    }

    public String getDescriptionApplication() {
        return this.descriptionApplication;
    }

    public void setDescriptionApplication(String descriptionApplication) {
        this.descriptionApplication = descriptionApplication;
    }

    public char getTypeApplication() {
        return this.typeApplication;
    }

    public void setTypeApplication(char typeApplication) {
        this.typeApplication = typeApplication;
    }

    public Set getRequests() {
        return this.requests;
    }

    public void setRequests(Set requests) {
        this.requests = requests;
    }

}
