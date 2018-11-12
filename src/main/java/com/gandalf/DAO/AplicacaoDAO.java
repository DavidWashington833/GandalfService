/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gandalf.DAO;

import com.gandalf.HibernateUtil;
import com.gandalf.models.Aplicacao;
import com.gandalf.models.Cliente;
import org.hibernate.Session;

/**
 *
 * @author David Washington
 */
public class AplicacaoDAO {
    private Session session;
    
    public AplicacaoDAO() {
        session = new HibernateUtil().getSession();
    }
    
    
    public Aplicacao get(byte id) {
        return (Aplicacao) session.get(Aplicacao.class, id);
    }
    
}
