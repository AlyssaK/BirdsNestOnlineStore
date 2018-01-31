/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

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
public class ViewItemAction extends ActionSupport implements SessionAware, ServletContextAware{
    
    private ServletContext servletContext;
    private Map session;
    private String itemID;
    
    
    public ViewItemAction() {
        
    }
    
    @Override
    public String execute() throws Exception {
        Map request = (Map) ActionContext.getContext().get("request");
        String rval = INPUT;
        String msg;
        
        int itemID2 = Integer.parseInt(this.itemID);
        ArrayList<Merchandise> merchandise = (ArrayList<Merchandise>) servletContext.getAttribute("merchandise");
        
        Merchandise viewItem = new Merchandise();
        
        for(Merchandise m : merchandise){
            if(m.getID()== itemID2){
                viewItem = m;
                rval = SUCCESS;
            }
        }

        this.session.put("viewItem", viewItem);
        
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

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }
    
}
