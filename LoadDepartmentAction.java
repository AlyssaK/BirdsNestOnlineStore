/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import business.Account;
import business.Department;
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
public class LoadDepartmentAction extends ActionSupport implements SessionAware, ServletContextAware {
    
    private ServletContext servletContext;
    private Map session;
    private int departmentID;
    private ArrayList<Merchandise> departmentMerchandise;
    private ArrayList<Department> departments;
    
    
    public LoadDepartmentAction() {
    }
    
    @Override
    public String execute() throws Exception {
        Map request = (Map) ActionContext.getContext().get("request");
        String rval;
        String dName = "";
        
        this.departments = (ArrayList<Department>) servletContext.getAttribute("departments");
        this.departmentMerchandise = (ArrayList<Merchandise>) MerchandiseDB.loadMerchandiseByDepartmentID(departmentID);
        
        this.session.put("departmentMerchandise", departmentMerchandise);
        
        for(Department d: this.departments){
            if(d.getID()==this.departmentID){
                dName = d.getName();
            }
        }
        
        request.put("dName", dName);
        
        rval = SUCCESS;        
        
        return rval;
    }

    @Override
    public void setSession(Map session) {
        this.session = session;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    @Override
    public void setServletContext(ServletContext sc) {
        this.servletContext = sc;
    }
    
}
