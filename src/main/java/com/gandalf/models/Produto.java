package com.gandalf.models;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Produto implements java.io.Serializable {

    private int idProduto;
    private Categoria categoria;
    private Usuario usuario;
    private String nomeProduto;
    private String descProduto;
    private BigDecimal precProduto;
    private BigDecimal descontoPromocao;
    private int ativoProduto;
    private Integer qtdMinEstoque;
    private byte[] imagem;
    private Set itemPedidos = new HashSet(0);

    public Produto() {
    }

    public Produto(int idProduto, Categoria categoria, String nomeProduto, BigDecimal precProduto, char ativoProduto) {
        this.idProduto = idProduto;
        this.categoria = categoria;
        this.nomeProduto = nomeProduto;
        this.precProduto = precProduto;
        this.ativoProduto = ativoProduto;
    }

    public Produto(int idProduto, Categoria categoria, Usuario usuario, String nomeProduto, String descProduto, BigDecimal precProduto, BigDecimal descontoPromocao, char ativoProduto, Integer qtdMinEstoque, byte[] imagem, Set itemPedidos) {
        this.idProduto = idProduto;
        this.categoria = categoria;
        this.usuario = usuario;
        this.nomeProduto = nomeProduto;
        this.descProduto = descProduto;
        this.precProduto = precProduto;
        this.descontoPromocao = descontoPromocao;
        this.ativoProduto = ativoProduto;
        this.qtdMinEstoque = qtdMinEstoque;
        this.imagem = imagem;
        this.itemPedidos = itemPedidos;
    }

    public int getIdProduto() {
        return this.idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public Categoria getCategoria() {
        return this.categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNomeProduto() {
        return this.nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescProduto() {
        return this.descProduto;
    }

    public void setDescProduto(String descProduto) {
        this.descProduto = descProduto;
    }

    public BigDecimal getPrecProduto() {
        return this.precProduto;
    }

    public void setPrecProduto(BigDecimal precProduto) {
        this.precProduto = precProduto;
    }

    public BigDecimal getDescontoPromocao() {
        return this.descontoPromocao;
    }

    public void setDescontoPromocao(BigDecimal descontoPromocao) {
        this.descontoPromocao = descontoPromocao;
    }

    public int getAtivoProduto() {
        return this.ativoProduto;
    }

    public void setAtivoProduto(int ativoProduto) {
        this.ativoProduto = ativoProduto;
    }

    public Integer getQtdMinEstoque() {
        return this.qtdMinEstoque;
    }

    public void setQtdMinEstoque(Integer qtdMinEstoque) {
        this.qtdMinEstoque = qtdMinEstoque;
    }

    public byte[] getImagem() {
        return this.imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public Set getItemPedidos() {
        return this.itemPedidos;
    }

    public void setItemPedidos(Set itemPedidos) {
        this.itemPedidos = itemPedidos;
    }

}
