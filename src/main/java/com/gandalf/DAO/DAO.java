package com.gandalf.DAO;

import com.gandalf.HibernateUtil;
import org.hibernate.Session;

public class DAO {
    protected Session session;
    
    public DAO() {
        session = new HibernateUtil().getSession();
    }
}
