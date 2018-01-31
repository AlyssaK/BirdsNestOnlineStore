/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.List;
import javax.persistence.NoResultException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

/**
 *
 * @author Alyssa
 */
public class MerchandiseDB {
    public static Merchandise getMerchandiseByID(int ID){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = null;
        Merchandise p = null;
        
        try{
            String qS = "FROM Merchandise m WHERE m.id = :ID";
            session = sessionFactory.openSession();
            Query q = session.createQuery(qS);
            q.setParameter("ID", ID);
            p = (Merchandise) q.uniqueResult();
        }catch(NoResultException e){
            return null;
        }finally{
            if(session!=null && session.isOpen()){
                session.close();
            }
        }
        
        return p;
    }
    
    public static List<Merchandise> loadMerchandiseByDepartmentID(int did){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = null;
        List<Merchandise> merchandise = null;
        
        try{
            String qS = "FROM Merchandise m WHERE m.departmentID = :did";
            session = sessionFactory.openSession();
            Query q = session.createQuery(qS);
            q.setParameter("did", did);
            merchandise = q.list();
        }catch(HibernateException e){
            merchandise = null;            
        }finally{
            if(session!=null && session.isOpen()){
                session.close();
            }
        }
        
        return merchandise;
    }
    
        public static List<Merchandise> loadMerchandise(){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = null;
        List<Merchandise> merchandise = null;
        
        try{
            String qS = "FROM Merchandise m";
            session = sessionFactory.openSession();
            Query q = session.createQuery(qS);            
            merchandise = q.list();
        }catch(HibernateException e){
            merchandise = null;            
        }finally{
            if(session!=null && session.isOpen()){
                session.close();
            }
        }
        
        return merchandise;
    }
}
