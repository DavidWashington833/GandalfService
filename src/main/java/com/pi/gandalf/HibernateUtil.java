package com.pi.gandalf;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;


/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Silva
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    private static Session session;

    public static Session getSession() {
        return getSessionFactory().openSession();
    }

    public static void setSession(Session session) {
        HibernateUtil.session = session;
    }
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new AnnotationConfiguration().configure()
                .addClass(com.pi.gandalf.models.Aplicacao.class)
                .addClass(com.pi.gandalf.models.Categoria.class)
                .addClass(com.pi.gandalf.models.Cliente.class)
                .addClass(com.pi.gandalf.models.Endereco.class)
                .addClass(com.pi.gandalf.models.Estoque.class)
                .addClass(com.pi.gandalf.models.ItemPedido.class)
                .addClass(com.pi.gandalf.models.Pedido.class)
                .addClass(com.pi.gandalf.models.Produto.class)
                .addClass(com.pi.gandalf.models.StatusPedido.class)
                .addClass(com.pi.gandalf.models.TipoPagamento.class)
                .addClass(com.pi.gandalf.models.Usuario.class)
                .setProperty("hibernate.connection.driver_class", "com.microsoft.sqlserver.jdbc.SQLServerDriver")
                .setProperty("hibernate.connection.url", "jdbc:sqlserver://" + System.getenv("DATABASE_URL") + ";databaseName=" + System.getenv("DATABASE_NAME"))
                .setProperty("hibernate.connection.username", System.getenv("DATABASE_USER"))
                .setProperty("hibernate.connection.password", System.getenv("DATABASE_PASSWORD"))
                .setProperty("hibernate.query.factory_class", "org.hibernate.hql.internal.classic.ClassicQueryTranslatorFactory")
                .buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
