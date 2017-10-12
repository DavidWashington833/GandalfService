/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.gandalf.DAO;

import com.pi.gandalf.HibernateUtil;
import com.pi.gandalf.models.Cliente;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
}
