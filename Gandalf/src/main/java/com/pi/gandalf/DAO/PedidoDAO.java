/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.gandalf.DAO;

import com.pi.gandalf.HibernateUtil;
import com.pi.gandalf.models.Pedido;
import com.pi.gandalf.models.Produto;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Silva
 */
public class PedidoDAO {
    private Session session;
    
    public PedidoDAO() {
        session = new HibernateUtil().getSession();
    }
    
    public Pedido get(int id) {
        return (Pedido) session.get(Pedido.class, id);
    }
    
    public List<Pedido> getForCliente(int id) {
        return session.createCriteria(Pedido.class)
                .add(Restrictions.eq("cliente.id", id)).list();
    }
}
