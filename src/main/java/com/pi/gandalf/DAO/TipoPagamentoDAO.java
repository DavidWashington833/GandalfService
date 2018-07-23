/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.gandalf.DAO;

import com.pi.gandalf.HibernateUtil;
import com.pi.gandalf.models.StatusPedido;
import com.pi.gandalf.models.TipoPagamento;
import org.hibernate.Session;

/**
 *
 * @author Silva
 */
public class TipoPagamentoDAO {
    private Session session;
    
    public TipoPagamentoDAO() {
        session = new HibernateUtil().getSession();
    }
    
    public TipoPagamento get(byte id) {
        return (TipoPagamento) session.get(TipoPagamento.class, id);
    }
}
