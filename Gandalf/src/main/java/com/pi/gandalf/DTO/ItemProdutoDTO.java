/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.gandalf.DTO;

import com.pi.gandalf.models.Categoria;
import com.pi.gandalf.models.Produto;
import com.pi.gandalf.models.Usuario;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Silva
 */
public class ItemProdutoDTO {
    
    public int idProduto;
    public String nomeProduto;
    public BigDecimal precProduto;
    public BigDecimal descontoPromocao;
    public Integer qtdMinEstoque;
    public byte[] imagem;
    public String descProduto;
    public int ativoProduto;
    
    public ItemProdutoDTO() {}
   
    public ItemProdutoDTO(Produto produto) {
        this.idProduto = produto.getIdProduto();
        this.nomeProduto = produto.getNomeProduto();
        this.precProduto = produto.getPrecProduto();
        this.descontoPromocao = produto.getDescontoPromocao();
        this.qtdMinEstoque = produto.getQtdMinEstoque();
        this.imagem = produto.getImagem();
        this.descProduto = produto.getDescProduto();
        this.ativoProduto = produto.getAtivoProduto();
    }

}
