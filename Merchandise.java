/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.io.Serializable;
import java.text.NumberFormat;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Alyssa
 */

@Entity
@Table(name="merchandise")
public class Merchandise implements Serializable {
    
    @Id
    @Column(name = "id")
    private int ID;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "price")
    private double price;
    
    @Column(name = "pictureURL")
    private String picture;
    
    @Column(name = "pictureURL2")
    private String picture2;
    
    @Column(name = "description")
    private String description;

    @Column(name = "salesPrice")
    private double salesPrice;
    
    @Column(name = "onSale")
    private boolean onSale;
    
    @Column(name = "departmentID")
    private int departmentID;
    
    @Transient
    private int quantity;
    
    @Transient
    NumberFormat curr = NumberFormat.getCurrencyInstance();
    
    public Merchandise(){
        this.ID = 0;
        this.name = "";
        this.price = 0.0;
        this.salesPrice = 0.0;
        this.onSale = false;
        this.picture =  "";
        this.picture2 = "";
        this.description = "";
        this.departmentID = 0;        
    }    

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }
    
    public String getPriceF(){
        return curr.format(this.price);
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isOnSale() {
        return onSale;
    }

    public void setOnSale(boolean onSale) {
        this.onSale = onSale;
    }

    public double getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(double salesPrice) {
        this.salesPrice = salesPrice;
    }
    
    public String getSalesPriceF(){
        return curr.format(this.salesPrice);
    }

    public String getPicture2() {
        return picture2;
    }

    public void setPicture2(String picture2) {
        this.picture2 = picture2;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }
}
