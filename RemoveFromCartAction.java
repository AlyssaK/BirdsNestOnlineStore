/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import business.Account;
import business.CartEntry;
import business.Merchandise;
import static com.opensymphony.xwork2.Action.INPUT;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.Map;
import javax.servlet.ServletContext;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

/**
 *
 * @author Alyssa
 */
public class RemoveFromCartAction extends ActionSupport implements SessionAware, ServletContextAware {
    
    private ServletContext servletContext;
    private Map session;
    private String itemID;
    
    public RemoveFromCartAction() {
    }
    
    @Override
    public String execute() throws Exception {
        Map request = (Map) ActionContext.getContext().get("request");
        String rval = INPUT;
        String msg = "";
        
        Account account = (Account) this.session.get("account");
        ArrayList<Merchandise> merchandise = (ArrayList<Merchandise>) servletContext.getAttribute("merchandise");
        int id = Integer.parseInt(itemID);
        
        for(Merchandise m : merchandise){
            if(m.getID()== id){
                account.getPurchases().remove(m);
                
            }
        }       
        
        int index = 0;
        for(CartEntry c : account.getCart()){
            if(c.getMerchandiseID() == id){
                index = account.getCart().indexOf(c);
            }
        }
        
        account.getCart().remove(index);
        
        rval = SUCCESS;
        this.session.put("account", account);
        
        return rval;
    }

    @Override
    public void setSession(Map session) {
        this.session = session;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }
    
    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
   
}
