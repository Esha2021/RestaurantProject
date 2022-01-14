package com.foodie.restaurant.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cart {

    @Id
    @GeneratedValue
    private int id;
    private int menuid;
 private String name;
 private double price;
 private int itemcount;
 private double amount;


    public Cart() {

    }

    public Cart(int menuid, String name, double price, int itemcount, double amount) {
        this.menuid = menuid;
        this.name = name;
        this.price = price;
        this.itemcount = itemcount;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public int getMenuid() {
        return menuid;
    }

    public void setMenuid(int menuid) {
        this.menuid = menuid;
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

    public void setPrice(double price) {
        this.price = price;
    }

    public int getItemcount() {
        return itemcount;
    }

    public void setItemcount(int itemcount) {
        this.itemcount = itemcount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
