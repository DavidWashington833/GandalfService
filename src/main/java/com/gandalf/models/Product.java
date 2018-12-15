package com.gandalf.models;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Product implements java.io.Serializable {

    private int idProduct;
    private Category category;
    private User user;
    private String nameProduct;
    private String descriptionProduct;
    private BigDecimal priceProduct;
    private BigDecimal discountProduct;
    private int activeProduct;
    private Integer stockProduct;
    private byte[] imageProduct;
    private Set itemRequests = new HashSet(0);

    public Product() {
    }

    public Product(int idProduto, Category categoria, String nomeProduto, BigDecimal precProduto, char ativoProduto) {
        this.idProduct = idProduto;
        this.category = categoria;
        this.nameProduct = nomeProduto;
        this.priceProduct = precProduto;
        this.activeProduct = ativoProduto;
    }

    public Product(int idProduto, Category categoria, User usuario, String nomeProduto, String descProduto, BigDecimal precProduto, BigDecimal descontoPromocao, char ativoProduto, Integer qtdMinEstoque, byte[] imagem, Set itemPedidos) {
        this.idProduct = idProduto;
        this.category = categoria;
        this.user = usuario;
        this.nameProduct = nomeProduto;
        this.descriptionProduct = descProduto;
        this.priceProduct = precProduto;
        this.discountProduct = descontoPromocao;
        this.activeProduct = ativoProduto;
        this.stockProduct = qtdMinEstoque;
        this.imageProduct = imagem;
        this.itemRequests = itemPedidos;
    }

    public int getIdProduct() {
        return this.idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getNameProduct() {
        return this.nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getDescriptionProduct() {
        return this.descriptionProduct;
    }

    public void setDescriptionProduct(String descriptionProduct) {
        this.descriptionProduct = descriptionProduct;
    }

    public BigDecimal getPriceProduct() {
        return this.priceProduct;
    }

    public void setPriceProduct(BigDecimal priceProduct) {
        this.priceProduct = priceProduct;
    }

    public BigDecimal getDiscountProduct() {
        return this.discountProduct;
    }

    public void setDiscountProduct(BigDecimal discountProduct) {
        this.discountProduct = discountProduct;
    }

    public int getActiveProduct() {
        return this.activeProduct;
    }

    public void setActiveProduct(int activeProduct) {
        this.activeProduct = activeProduct;
    }

    public Integer getStockProduct() {
        return this.stockProduct;
    }

    public void setStockProduct(Integer stockProduct) {
        this.stockProduct = stockProduct;
    }

    public byte[] getImageProduct() {
        return this.imageProduct;
    }

    public void setImageProduct(byte[] imageProduct) {
        this.imageProduct = imageProduct;
    }

    public Set getItemRequests() {
        return this.itemRequests;
    }

    public void setItemRequests(Set itemRequests) {
        this.itemRequests = itemRequests;
    }

}
