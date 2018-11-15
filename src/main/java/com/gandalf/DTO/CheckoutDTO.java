/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gandalf.DTO;

import java.io.Serializable;

/**
 *
 * @author David Washington
 */
public class CheckoutDTO implements Serializable {
    public RequestDTO pedidoDTO;
    public ItemPedidoDTO[] itemPedidosDTO;

    public CheckoutDTO() {
    }

    public CheckoutDTO(RequestDTO pedidoDTO) {
        this.pedidoDTO = pedidoDTO;
    }

    public RequestDTO getPedidoDTO() {
        return pedidoDTO;
    }

    public void setPedidoDTO(RequestDTO pedidoDTO) {
        this.pedidoDTO = pedidoDTO;
    }

    public ItemPedidoDTO[] getItemPedidosDTO() {
        return itemPedidosDTO;
    }

    public void setItemPedidosDTO(ItemPedidoDTO[] itemPedidosDTO) {
        this.itemPedidosDTO = itemPedidosDTO;
    }
}
