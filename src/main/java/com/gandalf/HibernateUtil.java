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
                    .addClass(com.gandalf.models.Application.class)
                    .addClass(com.gandalf.models.Category.class)
                    .addClass(com.gandalf.models.Client.class)
                    .addClass(com.gandalf.models.Address.class)
                    .addClass(com.gandalf.models.ItemRequest.class)
                    .addClass(com.gandalf.models.Request.class)
                    .addClass(com.gandalf.models.Product.class)
                    .addClass(com.gandalf.models.StatusRequest.class)
                    .addClass(com.gandalf.models.TypePayment.class)
                    .addClass(com.gandalf.models.User.class)
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
