package com.foodie.restaurant.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.foodie.restaurant.models.ResMenu;

@Entity
public class OrderMenu {

    @Id
    @GeneratedValue
    private int orderid;

    private double totalcost;

    @OneToMany(mappedBy = "id")
    private List<ResMenu> resMenu;

    public OrderMenu() {
    }

    public OrderMenu(List<ResMenu> resMenu) {
        this.resMenu = resMenu;
    }

    public List<ResMenu> getResMenu() {
        return resMenu;
    }

    public void setResMenu(List<ResMenu> resMenu) {
        this.resMenu = resMenu;
    }

    public double getTotalcost() {
        return totalcost;
    }

    public void setTotalcost(double totalcost) {
        this.totalcost = totalcost;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
 }
}

