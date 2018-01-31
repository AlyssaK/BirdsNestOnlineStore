/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

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
public class AccountDB {
    public static Account getAccount(String email){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = null;
        Account a = null;
        
        try{
            String qS = "FROM Account a WHERE a.email = :email";
            session = sessionFactory.openSession();
            Query q = session.createQuery(qS);
            q.setParameter("email", email);
             a = (Account) q.uniqueResult();
        }catch(NoResultException e){
            return null;
        }finally{
            if(session!=null && session.isOpen()){
                session.close();
            }
        }
        
        return a;
    }
    
    public static boolean checkEmail(String email){
        boolean used = false;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = null;
        Account a;
        
        try{
            String qS = "FROM Account a WHERE a.email = :email";
            session = sessionFactory.openSession();
            Query q = session.createQuery(qS);
            q.setParameter("email", email);
            a = (Account) q.uniqueResult();
            used = true;
        }catch(NoResultException e){
            used = false;
        }finally {
            if(session!=null && session.isOpen()){
                session.close();
            }
        }     
        
        return used;
    }
    
    
    public static String syncAccount(Account a){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = null;
        String msg = "";
        
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.merge(a);
            session.getTransaction().commit();
            session.flush();
            session.refresh(a);
            msg = "Account Synced!";           
        }catch(HibernateException e){
            msg = "Error Syncing Account: " + e.getMessage();
            session.getTransaction().rollback();            
        }finally{            
            session.close();            
        }
        
        return msg;
    }
    
    public static String addNewAccount(Account a){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = null;
        String msg = "";
        
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.persist(a);
            session.getTransaction().commit();
            session.flush();
            session.refresh(a);
            msg = "Account Created!";                    
        }catch(HibernateException e){
            msg = "Error Creating Account: " + e.getMessage();
            session.getTransaction().rollback();
        }finally{            
            if(session!=null && session.isOpen()){
                session.close();
            }
        }
        
        return msg;
    }
}
