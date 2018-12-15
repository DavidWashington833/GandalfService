package com.gandalf.models;

import java.util.HashSet;
import java.util.Set;

public class Category implements java.io.Serializable {

    private int idCategory;
    private String nameCategory;
    private String descriptionCategory;
    private Set products = new HashSet(0);

    public Category() {
    }

    public Category(int idCategoria, String nomeCategoria) {
        this.idCategory = idCategoria;
        this.nameCategory = nomeCategoria;
    }

    public Category(int idCategoria, String nomeCategoria, String descCategoria, Set produtos) {
        this.idCategory = idCategoria;
        this.nameCategory = nomeCategoria;
        this.descriptionCategory = descCategoria;
        this.products = produtos;
    }

    public int getIdCategory() {
        return this.idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getNameCategory() {
        return this.nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public String getDescriptionCategory() {
        return this.descriptionCategory;
    }

    public void setDescriptionCategory(String descriptionCategory) {
        this.descriptionCategory = descriptionCategory;
    }

    public Set getProducts() {
        return this.products;
    }

    public void setProducts(Set products) {
        this.products = products;
    }

}
