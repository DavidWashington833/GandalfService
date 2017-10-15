/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.gandalf.DTO;

import com.google.gson.annotations.Expose;
import com.pi.gandalf.models.Cliente;
import com.pi.gandalf.models.Produto;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Silva
 */
public class ItemProdutoListaDTO {

    public int idProduto;
    public String nomeProduto;
    public BigDecimal precProduto;
    public BigDecimal descontoPromocao;
    public Integer qtdMinEstoque;
    public byte[] imagem;

    public ItemProdutoListaDTO() {}
   
    public ItemProdutoListaDTO(Produto produto) {
        this.idProduto = produto.getIdProduto();
        this.nomeProduto = produto.getNomeProduto();
        this.precProduto = produto.getPrecProduto();
        this.descontoPromocao = produto.getDescontoPromocao();
        this.qtdMinEstoque = produto.getQtdMinEstoque();
        this.imagem = produto.getImagem();
    }

}
