/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import business.Account;
import business.CartEntry;
import static com.opensymphony.xwork2.Action.INPUT;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.text.NumberFormat;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Alyssa
 */
public class CheckoutAction extends ActionSupport implements SessionAware{
    
    private Map session;
    
    public CheckoutAction() {
    }
    
    @Override
    public String execute() throws Exception {
        Map request = (Map) ActionContext.getContext().get("request");
        NumberFormat curr = NumberFormat.getCurrencyInstance();
        String rval = INPUT;
        String msg = "";
        
        Account account = (Account) this.session.get("account");
        
        double subtotal = 0;
        double tax = 0;        
        double total = 0;
        
        for(CartEntry c : account.getCart()){
            subtotal += c.getTotal();
            tax += c.getTax();
            total += c.getGrandtotal();            
        }
        
        String subtotalF = curr.format(subtotal);
        String taxF = curr.format(tax);
        String totalF = curr.format(total);
        
        this.session.put("subtotal", subtotal);
        this.session.put("tax", tax);
        this.session.put("total", total);
        
        this.session.put("subtotalF", subtotalF);
        this.session.put("taxF", taxF);
        this.session.put("totalF", totalF);
        rval = SUCCESS;
        
        return rval;
    }

    @Override
    public void setSession(Map session) {
        this.session = session;
    }
    
}
