package com.gandalf.models;

import java.math.BigDecimal;

public class ItemPedido implements java.io.Serializable {

    private ItemPedidoId id;
    private Pedido pedido;
    private Produto produto;
    private short qtdProduto;
    private BigDecimal precoVendaItem;

    public ItemPedido() {
    }

    public ItemPedido(ItemPedidoId id, Pedido pedido, Produto produto, short qtdProduto, BigDecimal precoVendaItem) {
        this.id = id;
        this.pedido = pedido;
        this.produto = produto;
        this.qtdProduto = qtdProduto;
        this.precoVendaItem = precoVendaItem;
    }

    public ItemPedidoId getId() {
        return this.id;
    }

    public void setId(ItemPedidoId id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return this.pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return this.produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public short getQtdProduto() {
        return this.qtdProduto;
    }

    public void setQtdProduto(short qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

    public BigDecimal getPrecoVendaItem() {
        return this.precoVendaItem;
    }

    public void setPrecoVendaItem(BigDecimal precoVendaItem) {
        this.precoVendaItem = precoVendaItem;
    }

}
