/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import business.Account;
import business.AccountDB;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Alyssa
 */
public class CustomerLoginAction extends ActionSupport implements SessionAware{
    
    private Map session;
    private Account account;
    private String email;
    private String pattempt;
    
    public CustomerLoginAction() {
    }
    
    @Override
    public void validate(){
        if(!AccountDB.checkEmail(this.email)){
            addFieldError("email", "User Not Found!");
        }        
        this.account = AccountDB.getAccount(this.email);
        if(!this.account.getPassword().equals(this.pattempt)){
            addFieldError("password", "Incorrect Password!");
        }
    }    
    
    @Override
    public String execute() throws Exception {
        Map request = (Map) ActionContext.getContext().get("request");
        String rval = INPUT;
        String msg = "";
        
        this.account = AccountDB.getAccount(this.email);
        this.account.setOnline(true);
        this.session.put("account", this.account); 
        msg = "Login Successful!";
        rval = SUCCESS;
        
        request.put("msg", msg);
        
        return rval;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPattempt() {
        return pattempt;
    }

    public void setPattempt(String pattempt) {
        this.pattempt = pattempt;
    }

    @Override
    public void setSession(Map session) {
        this.session = session;
    }
    
}
