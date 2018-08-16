/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gandalf.DTO;

import java.io.Serializable;

/**
 *
 * @author Silva
 */
public class CheckoutDTO implements Serializable {
    public PedidoDTO pedidoDTO;
    public ItemPedidoDTO[] itemPedidosDTO;

    public CheckoutDTO() {
    }

    public CheckoutDTO(PedidoDTO pedidoDTO) {
        this.pedidoDTO = pedidoDTO;
    }

    public PedidoDTO getPedidoDTO() {
        return pedidoDTO;
    }

    public void setPedidoDTO(PedidoDTO pedidoDTO) {
        this.pedidoDTO = pedidoDTO;
    }

    public ItemPedidoDTO[] getItemPedidosDTO() {
        return itemPedidosDTO;
    }

    public void setItemPedidosDTO(ItemPedidoDTO[] itemPedidosDTO) {
        this.itemPedidosDTO = itemPedidosDTO;
    }
}
