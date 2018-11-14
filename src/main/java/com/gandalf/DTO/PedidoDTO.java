/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gandalf.DTO;

import com.gandalf.DAO.ClientDAO;
import com.gandalf.DAO.AddressDAO;
import com.gandalf.DAO.TipoPagamentoDAO;
import com.gandalf.DAO.StatusPedidoDAO;
import com.gandalf.models.Aplicacao;
import com.gandalf.models.Pedido;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author David Washington
 */
public class PedidoDTO implements Serializable {
    public int idCliente;
    public int idStatus;
    public int idTipoPagto;
    public int idEndereco;

    public PedidoDTO(int idCliente, int idStatus, int idTipoPagto, int idEndereco) {
        this.idCliente = idCliente;
        this.idStatus = idStatus;
        this.idTipoPagto = idTipoPagto;
        this.idEndereco = idEndereco;
    }

    public PedidoDTO() {
    }

    public PedidoDTO(Pedido pedido) {
        this.idCliente = pedido.getCliente().getIdCliente();
        this.idStatus = pedido.getStatusPedido().getIdStatus();
        this.idTipoPagto = pedido.getTipoPagamento().getIdTipoPagto();
        this.idEndereco = pedido.getEndereco().getIdEndereco();
    }
    
    public Pedido pegaPedido() {
        Pedido pedido = new Pedido();
        Aplicacao aplicacao = new Aplicacao();
        aplicacao.setIdAplicacao((byte)2);
        
        pedido.setCliente(new ClientDAO().get(idCliente));
        pedido.setEndereco(new AddressDAO().get(idEndereco));
        pedido.setAplicacao(aplicacao);
        
        return pedido;
    }    

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }

    public int getIdTipoPagto() {
        return idTipoPagto;
    }

    public void setIdTipoPagto(int idTipoPagto) {
        this.idTipoPagto = idTipoPagto;
    }

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }
    
}
