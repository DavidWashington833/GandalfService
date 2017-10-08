/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.gandalf.DAO;

import com.pi.gandalf.HibernateUtil;
import com.pi.gandalf.models.Produto;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Silva
 */
public class ProdutoDAO {
    
    private Session session;
    
    public ProdutoDAO() {
        session = new HibernateUtil().getSession();
    }
    
    public List<Produto> get() {
        return session.createCriteria(Produto.class).list();
    }
    
    public Produto get(int id) {
        return (Produto) session.get(Produto.class, id);
    }
}
