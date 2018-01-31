/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import static com.opensymphony.xwork2.Action.INPUT;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;

/**
 *
 * @author Alyssa
 */
public class PaymentReceivedAction extends ActionSupport {
    
    private String nonce;
    
    public PaymentReceivedAction() {
    }
    
    public String execute() throws Exception {
        Map request = (Map) ActionContext.getContext().get("request");
        String msg = nonce;
        request.put("msg", msg);
        
        return SUCCESS;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }
    
}
