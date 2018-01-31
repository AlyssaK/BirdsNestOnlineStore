/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import business.Department;
import business.DepartmentDB;
import business.Merchandise;
import business.MerchandiseDB;
import java.util.ArrayList;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author Alyssa
 */
public class SCL implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent sce) {
       ArrayList<Department> departments = (ArrayList<Department>) DepartmentDB.loadDepartments();
       ArrayList<Merchandise> merchandise = (ArrayList<Merchandise>) MerchandiseDB.loadMerchandise();
       ArrayList<Merchandise> sales = new ArrayList<>();
       for(Merchandise m : merchandise){
           if(m.isOnSale()){
               sales.add(m);
           }
       }
       sce.getServletContext().setAttribute("sales", sales);
       sce.getServletContext().setAttribute("departments", departments);
       sce.getServletContext().setAttribute("merchandise", merchandise);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
       
    }
    
}
