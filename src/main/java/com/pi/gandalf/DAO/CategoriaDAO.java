/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.gandalf.DAO;

import com.pi.gandalf.HibernateUtil;
import com.pi.gandalf.models.Categoria;
import com.pi.gandalf.models.Produto;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Silva
 */
public class CategoriaDAO {
    private Session session;
    
    public CategoriaDAO() {
        session = new HibernateUtil().getSession();
    }
    
    public List<Categoria> get() {
        return session.createCriteria(Categoria.class).list();
    }
}
