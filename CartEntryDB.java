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
public class CartEntryDB {
    public static List<CartEntry> loadCartByAccountID(int aid){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = null;
        List<CartEntry> cart = null;
        
        try{
            String qS = "FROM CartEntry c WHERE c.accountID = :aid";
            session = sessionFactory.openSession();
            Query q = session.createQuery(qS);
            q.setParameter("aid", aid);
            cart = q.list();
        }catch(HibernateException e){
            cart = null;            
        }finally{
            if(session!=null && session.isOpen()){
                session.close();
            }
        }
        
        return cart;
    }
        
    public static String addNewCartEntry(CartEntry c){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = null;
        String msg = "";
        
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.persist(c);
            session.getTransaction().commit();
            session.flush();
            session.refresh(c);
            msg = "Cart Entry Added!";                    
        }catch(HibernateException e){
            msg = "Error Adding Cart Entry: " + e.getMessage();
            session.getTransaction().rollback();
        }finally{            
            if(session!=null && session.isOpen()){
                session.close();
            }
        }
        
        return msg;
    }
    
}
