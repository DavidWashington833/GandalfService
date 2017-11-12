/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.gandalf.DAO;

import com.pi.gandalf.HibernateUtil;
import com.pi.gandalf.models.Cliente;
import com.pi.gandalf.models.Produto;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author david.wfsilva
 */
public class ClienteDAO {
    private Session session;
    
    public ClienteDAO() {
        session = new HibernateUtil().getSession();
    }
    
    public void add(Cliente cliente) {
        try {
            Transaction tx = session.beginTransaction();
            session.save(cliente);
            tx.commit();
        }   
        catch (Exception e) {
        };
    }
    
    
    public Cliente get(String email, String password) {
        Cliente cliente = null;
        List<Cliente> clientes = session.createCriteria(Cliente.class)
                .add(Restrictions.eq("emailCliente", email))
                .add(Restrictions.eq("senhaCliente", password)).list();
        if (clientes.size() > 0) {
            cliente = clientes.get(0);
        }
        
        return cliente;
    }
}
