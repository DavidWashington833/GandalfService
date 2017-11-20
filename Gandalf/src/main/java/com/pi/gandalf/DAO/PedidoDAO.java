/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.gandalf.DAO;

import com.pi.gandalf.HibernateUtil;
import com.pi.gandalf.models.Cliente;
import com.pi.gandalf.models.Pedido;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
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
    
    public void add(Pedido pedido) {
        try {
            Transaction tx = session.beginTransaction();
            session.save(pedido);
            tx.commit();
        }   
        catch (Exception e) {
        };
    }
    
    public Pedido get(int id) {
        return (Pedido) session.get(Pedido.class, id);
    }
    
    public List<Pedido> getForCliente(int id) {
        return session.createCriteria(Pedido.class)
                .add(Restrictions.eq("cliente.id", id)).list();
    }
}
