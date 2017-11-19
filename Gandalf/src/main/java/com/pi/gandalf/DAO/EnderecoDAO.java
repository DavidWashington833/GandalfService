/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.gandalf.DAO;

import com.pi.gandalf.HibernateUtil;
import com.pi.gandalf.models.Cliente;
import com.pi.gandalf.models.Endereco;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Silva
 */
public class EnderecoDAO {
    private Session session;
    
    public EnderecoDAO() {
        session = new HibernateUtil().getSession();
    }
    
    public List<Endereco> getForCliente(int id) {
        List<Endereco> endereco = new ArrayList<Endereco>();
        endereco = session.createCriteria(Endereco.class)
            .add(Restrictions.eq("cliente.id", id)).list();
        
        return endereco;
    }
    
    public Endereco get(int id) {
        return (Endereco) session.get(Endereco.class, id);
    }
}
