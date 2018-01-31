/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import business.Account;
import business.AccountDB;
import static com.opensymphony.xwork2.Action.INPUT;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Alyssa
 */
public class AccountCreateAction extends ActionSupport implements SessionAware {
    
    private Map session;    
    private String email;
    private String firstName;
    private String lastName;
    private String password1;
    private String password2; 
    private String address;
    private String address2;
    private String city;
    private String state;
    private String zipcode;
    
    @Override
    public void validate(){
       if(!AccountDB.checkEmail(this.email)){
            addFieldError("email", "Name Already Taken!");
        }
        if(!this.password1.equals(this.password2)){
            addFieldError("password2", "Passwords Do Not Match!");
        }  
    }   
    
    public AccountCreateAction() {
    }
    
    @Override
    public String execute() throws Exception {
        Map request = (Map) ActionContext.getContext().get("request");
        String rval = INPUT;
        String msg = "";
                
        Account account = new Account(this.firstName, this.lastName, this.email, 
                this.password1, this.address, this.address2, this.city, 
                this.state, this.zipcode);
        msg = AccountDB.addNewAccount(account);
        
        if(!msg.startsWith("Error")){
            rval = SUCCESS;
        }
        
        request.put("msg", msg);
        
        return rval;
    }

    public Map getSession() {
        return session;
    }

    @Override
    public void setSession(Map session) {
        this.session = session;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
    
}
