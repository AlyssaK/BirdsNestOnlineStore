/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import business.Merchandise;
import business.MerchandiseDB;
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
public class SearchMerchandiseAction extends ActionSupport implements SessionAware, ServletContextAware {
    
    private ServletContext servletContext;
    private Map session;
    private String searchEntry;
    private ArrayList<Merchandise> merchandise;
    
    public SearchMerchandiseAction() {
    }
    
    @Override
    public String execute() throws Exception {
        Map request = (Map) ActionContext.getContext().get("request");
        String rval = INPUT;
        String msg;
        boolean multiple = this.searchEntry.contains(" ");
        String[] searchWords = this.searchEntry.split(" ");           
        ArrayList<Merchandise> searchResults = new ArrayList<>();
        
        this.merchandise = (ArrayList<Merchandise>) MerchandiseDB.loadMerchandise();
        
        this.merchandise.forEach((Merchandise m) -> {
            if(multiple){
                for (String searchWord : searchWords) {
                    boolean contains = m.getName().contains(searchWord);
                    boolean contains2 =  m.getDescription().contains(searchWord);
                    if(contains || contains2){ searchResults.add(m); }
                }
            }else{
                boolean contains = m.getName().contains(this.searchEntry);
                boolean contains2 =  m.getDescription().contains(this.searchEntry);
                if(contains || contains2){ searchResults.add(m); }
            }
        });
        
        rval = SUCCESS;
        this.session.put("searchResults", searchResults);
        msg = "Search Results For: " + this.searchEntry + " " + searchResults.size() + " Found";
        
        request.put("msg", msg);
        
        return rval;
    }

    @Override
    public void setSession(Map session) {
        this.session = session;
    }

    public String getSearchEntry() {
        return searchEntry;
    }

    public void setSearchEntry(String searchEntry) {
        this.searchEntry = searchEntry;
    }

    @Override
    public void setServletContext(ServletContext sc) {
        this.servletContext = sc;
    }
    
}
