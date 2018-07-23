/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.gandalf.DAO;

import com.pi.gandalf.HibernateUtil;
import com.pi.gandalf.models.Aplicacao;
import com.pi.gandalf.models.Cliente;
import org.hibernate.Session;

/**
 *
 * @author Silva
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
