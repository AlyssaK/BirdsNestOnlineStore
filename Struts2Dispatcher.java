
package util;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

/**
 *
 * @author Alyssa
 */
public class Struts2Dispatcher extends StrutsPrepareAndExecuteFilter{
    
    @Override
    public void init(FilterConfig filterConfig) 
            throws ServletException {
        
        super.init(filterConfig);
        
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if(sessionFactory == null){
                throw new HibernateException("SessionFactory is null");
            }else{
                System.out.println("SessionFactory is active");
            }            
        }catch(HibernateException e){
            throw new ServletException(e.getMessage());
        }        
    }
}
