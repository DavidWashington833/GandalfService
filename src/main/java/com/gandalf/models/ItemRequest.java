package com.gandalf.models;

import java.math.BigDecimal;

public class ItemRequest implements java.io.Serializable {

    private ItemRequestId id;
    private Request request;
    private Product product;
    private short countItemRequest;
    private BigDecimal priceItemRequest;

    public ItemRequest() {
    }

    public ItemRequest(ItemRequestId id, Request pedido, Product produto, short qtdProduto, BigDecimal precoVendaItem) {
        this.id = id;
        this.request = pedido;
        this.product = produto;
        this.countItemRequest = qtdProduto;
        this.priceItemRequest = precoVendaItem;
    }

    public ItemRequestId getId() {
        return this.id;
    }

    public void setId(ItemRequestId id) {
        this.id = id;
    }

    public Request getRequest() {
        return this.request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public short getCountItemRequest() {
        return this.countItemRequest;
    }

    public void setCountItemRequest(short countItemRequest) {
        this.countItemRequest = countItemRequest;
    }

    public BigDecimal getPriceItemRequest() {
        return this.priceItemRequest;
    }

    public void setPriceItemRequest(BigDecimal priceItemRequest) {
        this.priceItemRequest = priceItemRequest;
    }

}
