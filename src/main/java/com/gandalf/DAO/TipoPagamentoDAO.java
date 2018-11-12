/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gandalf.DAO;

import com.gandalf.HibernateUtil;
import com.gandalf.models.StatusPedido;
import com.gandalf.models.TipoPagamento;
import org.hibernate.Session;

/**
 *
 * @author David Washington
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
