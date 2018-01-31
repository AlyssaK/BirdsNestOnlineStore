/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

/**
 *
 * @author Alyssa
 */
public class DepartmentDB {
    public static List<Department> loadDepartments(){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = null;
        List<Department> departments = null;
        
        try{
            String qS = "FROM Department d";
            session = sessionFactory.openSession();
            Query q = session.createQuery(qS);            
            departments = q.list();
        }catch(HibernateException e){
            departments = null;            
        }finally{
            if(session!=null && session.isOpen()){
                session.close();
            }
        }
        
        return departments;
    }
}
