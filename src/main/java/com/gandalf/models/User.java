package com.gandalf.models;

import java.util.HashSet;
import java.util.Set;

public class User implements java.io.Serializable {

    private int idUser;
    private String emailUser;
    private String passwordUser;
    private String nameUser;
    private Set products = new HashSet(0);

    public User() {
    }

    public User(int idUsuario, String loginUsuario) {
        this.idUser = idUsuario;
        this.emailUser = loginUsuario;
    }

    public User(int idUsuario, String loginUsuario, String senhaUsuario, String nomeUsuario, Character tipoPerfil, Boolean usuarioAtivo, Set produtos) {
        this.idUser = idUsuario;
        this.emailUser = loginUsuario;
        this.passwordUser = senhaUsuario;
        this.nameUser = nomeUsuario;
        this.products = produtos;
    }

    public int getIdUser() {
        return this.idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getEmailUser() {
        return this.emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getPasswordUser() {
        return this.passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    public String getNameUser() {
        return this.nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public Set getProducts() {
        return this.products;
    }

    public void setProducts(Set products) {
        this.products = products;
    }

}
