/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Alyssa
 */
@Entity
@Table(name="cartentry")
public class CartEntry {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "purchaseID")
    private int purchaseID;
    
    @Column(name = "merchandiseID")
    private int merchandiseID;
    
    @Column(name = "accounntID")
    private int accountID;
    
    @Column(name = "price")
    private double price;

    @Column(name = "total")
    private double total;
    
    @Column(name = "tax")    
    private double tax;
      
    @Column(name = "grandtotal")
    private double grandtotal;
    
    public CartEntry(){
        this.merchandiseID = 0;
        this.accountID = 0;
        this.price = 0.0;
        this.tax = 0.0;
        this.total = 0.0;
        this.grandtotal = 0.0;
    }

    public int getPurchaseID() {
        return purchaseID;
    }

    public void setPurchaseID(int purchaseID) {
        this.purchaseID = purchaseID;
    }

    public int getMerchandiseID() {
        return merchandiseID;
    }

    public void setMerchandiseID(int merchandiseID) {
        this.merchandiseID = merchandiseID;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getGrandtotal() {
        return grandtotal;
    }

    public void setGrandtotal(double grandtotal) {
        this.grandtotal = grandtotal;
    }
}
