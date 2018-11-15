/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gandalf.DTO;

import com.gandalf.DAO.RequestDAO;
import com.gandalf.DAO.ProductDAO;
import com.gandalf.models.ItemPedido;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author David Washington
 */
public class ItemPedidoDTO implements Serializable {
    public int idProduto;
    public int qtdProduto;
    public BigDecimal precoVendaItem;

    public ItemPedidoDTO(int idProduto, short qtdProduto, BigDecimal precoVendaItem) {
        this.idProduto = idProduto;
        this.qtdProduto = qtdProduto;
        this.precoVendaItem = precoVendaItem;
    }
       
    public ItemPedidoDTO() {
    }
      
    public ItemPedidoDTO(ItemPedido itemPedido) {
        this.idProduto = itemPedido.getProduto().getIdProduto();
        this.qtdProduto = itemPedido.getQtdProduto();
        this.precoVendaItem = itemPedido.getPrecoVendaItem();
    }
    
    public ItemPedido getItemPedido() {
        ItemPedido itemPedido = new ItemPedido();
        
        itemPedido.setProduto(new ProductDAO().get(idProduto));
        itemPedido.setQtdProduto((short)qtdProduto);
        itemPedido.setPrecoVendaItem(precoVendaItem);
        
        return itemPedido;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(int qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

    public BigDecimal getPrecoVendaItem() {
        return precoVendaItem;
    }

    public void setPrecoVendaItem(BigDecimal precoVendaItem) {
        this.precoVendaItem = precoVendaItem;
    }
    
    
}
