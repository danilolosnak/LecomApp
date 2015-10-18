/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HibernateUtil;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author DaniloPC
 */
public class HibernateSessionFactory {

private static final SessionFactory sessionFactory = buildSessionFactory1();

private static SessionFactory buildSessionFactory1() {
    Configuration configuration = new Configuration().configure(); // configuration
                                                                    // settings
                                                                    // from
                                                                    // hibernate.cfg.xml

    StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();


    serviceRegistryBuilder.applySettings(configuration.getProperties());

    ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();

    return configuration.buildSessionFactory(serviceRegistry);
}

public static SessionFactory getSessionFactory() {
    return sessionFactory;
}

public static void shutdown() {
    // Close caches and connection pools
    getSessionFactory().close();
}
}
