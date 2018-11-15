package com.gandalf;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    private static Session session;

    static {
        try {
            sessionFactory = new AnnotationConfiguration().configure()
                    .addClass(com.gandalf.models.Aplicacao.class)
                    .addClass(com.gandalf.models.Categoria.class)
                    .addClass(com.gandalf.models.Cliente.class)
                    .addClass(com.gandalf.models.Endereco.class)
                    .addClass(com.gandalf.models.Estoque.class)
                    .addClass(com.gandalf.models.ItemPedido.class)
                    .addClass(com.gandalf.models.Pedido.class)
                    .addClass(com.gandalf.models.Produto.class)
                    .addClass(com.gandalf.models.StatusPedido.class)
                    .addClass(com.gandalf.models.TipoPagamento.class)
                    .addClass(com.gandalf.models.Usuario.class)
                    .setProperty("hibernate.connection.driver_class", "com.microsoft.sqlserver.jdbc.SQLServerDriver")
                    .setProperty("hibernate.connection.url", "jdbc:sqlserver://" + System.getenv("DATABASE_URL") + ";databaseName=" + System.getenv("DATABASE_NAME"))
                    .setProperty("hibernate.connection.username", System.getenv("DATABASE_USER"))
                    .setProperty("hibernate.connection.password", System.getenv("DATABASE_PASSWORD"))
                    .setProperty("hibernate.query.factory_class", "org.hibernate.hql.internal.classic.ClassicQueryTranslatorFactory")
                    .buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() {
        return getSessionFactory().openSession();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
