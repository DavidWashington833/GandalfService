package com.gandalf.models;

public class Estoque implements java.io.Serializable {

    private int idProduto;
    private Integer qtdProdutoDisponivel;

    public Estoque() {
    }

    public Estoque(int idProduto) {
        this.idProduto = idProduto;
    }

    public Estoque(int idProduto, Integer qtdProdutoDisponivel) {
        this.idProduto = idProduto;
        this.qtdProdutoDisponivel = qtdProdutoDisponivel;
    }

    public int getIdProduto() {
        return this.idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public Integer getQtdProdutoDisponivel() {
        return this.qtdProdutoDisponivel;
    }

    public void setQtdProdutoDisponivel(Integer qtdProdutoDisponivel) {
        this.qtdProdutoDisponivel = qtdProdutoDisponivel;
    }

}
