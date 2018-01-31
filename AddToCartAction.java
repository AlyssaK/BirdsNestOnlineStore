/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import business.Account;
import business.CartEntry;
import business.CartEntryDB;
import business.Merchandise;
import static com.opensymphony.xwork2.Action.INPUT;
import static com.opensymphony.xwork2.Action.SUCCESS;
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
public class AddToCartAction extends ActionSupport implements SessionAware, ServletContextAware{
    
    private ServletContext servletContext;
    private Map session;
    
    public AddToCartAction() {
    }
    
    @Override
    public String execute() throws Exception {
        Map request = (Map) ActionContext.getContext().get("request");
        String rval = INPUT;
        String msg = "";        
        
        Merchandise buyItem = (Merchandise) this.session.get("viewItem");       
        
        CartEntry cartEntry = new CartEntry();
        double salesTax = 0.04225;
        
        cartEntry.setMerchandiseID(buyItem.getID());
        
        if(buyItem.isOnSale()){
            cartEntry.setPrice(buyItem.getSalesPrice());
        }else{
            cartEntry.setPrice(buyItem.getPrice());
        }
                
        double total = cartEntry.getPrice();
        double tax = total * salesTax;
        double grandTotal = total + tax;
        
        cartEntry.setTotal(total);
        cartEntry.setTax(tax);
        cartEntry.setGrandtotal(grandTotal);
        
        try{            
            Account account = (Account) this.session.get("account");
            cartEntry.setAccountID(account.getID());
            CartEntryDB.addNewCartEntry(cartEntry);            
            account.getPurchases().add(buyItem);
            account.getCart().add(cartEntry);
            this.session.put("account", account);
            rval = SUCCESS;
        }catch(Exception e){
            msg = "Please Log In To Purchase Items";
        }         
               
        request.put("msg", msg);
        
        return rval;
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    @Override
    public void setSession(Map session) {
        this.session = session;
    }
}
