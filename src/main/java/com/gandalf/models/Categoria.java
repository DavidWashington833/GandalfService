package com.gandalf.models;

import java.util.HashSet;
import java.util.Set;

public class Categoria implements java.io.Serializable {

    private int idCategoria;
    private String nomeCategoria;
    private String descCategoria;
    private Set produtos = new HashSet(0);

    public Categoria() {
    }

    public Categoria(int idCategoria, String nomeCategoria) {
        this.idCategoria = idCategoria;
        this.nomeCategoria = nomeCategoria;
    }

    public Categoria(int idCategoria, String nomeCategoria, String descCategoria, Set produtos) {
        this.idCategoria = idCategoria;
        this.nomeCategoria = nomeCategoria;
        this.descCategoria = descCategoria;
        this.produtos = produtos;
    }

    public int getIdCategoria() {
        return this.idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNomeCategoria() {
        return this.nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public String getDescCategoria() {
        return this.descCategoria;
    }

    public void setDescCategoria(String descCategoria) {
        this.descCategoria = descCategoria;
    }

    public Set getProdutos() {
        return this.produtos;
    }

    public void setProdutos(Set produtos) {
        this.produtos = produtos;
    }

}
