/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gandalf.DAO;

import com.gandalf.HibernateUtil;
import com.gandalf.models.Produto;
import com.gandalf.models.StatusPedido;
import org.hibernate.Session;

/**
 *
 * @author Silva
 */
public class StatusPedidoDAO {
    private Session session;
    
    public StatusPedidoDAO() {
        session = new HibernateUtil().getSession();
    }
    
    public StatusPedido get(byte id) {
        return (StatusPedido) session.get(StatusPedido.class, id);
    }
    
}
