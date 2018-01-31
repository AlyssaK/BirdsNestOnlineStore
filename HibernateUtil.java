
package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author Alyssa
 */

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            
            //load configuration and mappings from hibernate.cfg.xml
            Configuration configuration = new Configuration().configure();
            ServiceRegistry serviceRegistry = 
                new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            
            //build session factory from service registry
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);            
        }
        return sessionFactory;
    }    
}
