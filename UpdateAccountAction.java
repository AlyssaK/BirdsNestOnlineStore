/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import business.Account;
import business.AccountDB;
import static com.opensymphony.xwork2.Action.INPUT;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Alyssa
 */
public class UpdateAccountAction extends ActionSupport implements SessionAware{
    
    private Map session;
    private Account account;    
    
    public Account getAccount(){
        return this.account;
    }
    
    public void setAccount(Account account){
        this.account = account;
    }
    
    public UpdateAccountAction() {
    }
    
    @Override
    public String execute() throws Exception {
        Map request = (Map) ActionContext.getContext().get("request");
        String msg = AccountDB.syncAccount(this.account);
        String rval;  
        
        if(!msg.startsWith("Error")){
            this.account = AccountDB.getAccount(this.account.getEmail());
            this.session.put("account", this.account);   
            rval = SUCCESS;
        }else{
            rval = INPUT;
        }        
        
        request.put("msg", msg);
        return rval;
    }
    
    @Override
    public void setSession(Map session) {
        this.session = session;
    }
}
