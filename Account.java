/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Alyssa
 */

@Entity
@Table(name="account")
public class Account implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int ID;
    
    @Column(name = "firstname")
    private String firstName;
    
    @Column(name = "lastname")
    private String lastName;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "online")
    private boolean online;
    
    @Column(name = "address")
    private String address;
    
    @Column(name = "address2")
    private String address2;
    
    @Column(name = "city")
    private String city;
    
    @Column(name = "us_state")
    private String state;
   
    @Column(name = "zipcode")
    private String zipcode;
    
    @Transient
    private ArrayList<Merchandise> purchases;
    
    @Transient 
    private ArrayList<CartEntry> cart;
    
    public Account(){
        this.firstName = "";
        this.lastName = "";
        this.email = "";
        this.password = "";
        this.purchases = new ArrayList<>();
        this.cart = new ArrayList<>();
        this.online = false;
        this.address = "";
        this.address2 = "";
        this.city = "";
        this.state = "";
        this.zipcode = "";
    }

    public Account(String fn, String ln, String em, String pw, String ad, String ad2, String ct, String st, String zc){
        this.firstName = fn;
        this.lastName = ln;
        this.email = em;
        this.password = pw; 
        this.address = ad;
        this.address2 = ad2;
        this.city = ct;
        this.state = st;
        this.zipcode = zc;
         this.purchases = new ArrayList<>();
        this.cart = new ArrayList<>();
        this.online = true;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Merchandise> getPurchases() {
        return purchases;
    }

    public void setPurchases(ArrayList<Merchandise> purchases) {
        this.purchases = purchases;
    }

    public boolean isOnline() {
        return this.online;
    }

    public void setOnline(boolean online) {
        this.online = online;
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

    public ArrayList<CartEntry> getCart() {
        return cart;
    }

    public void setCart(ArrayList<CartEntry> cart) {
        this.cart = cart;
    }
}
