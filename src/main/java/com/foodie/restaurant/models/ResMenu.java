package com.foodie.restaurant.models;

import javax.persistence.*;
import javax.persistence.criteria.Order;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class ResMenu extends AbstractEntity {

    public ResMenu() {
        super();
    }


    @ManyToOne
    private OrderMenu orderMenu;



    public OrderMenu getOrderMenu() {
        return orderMenu;
    }

    public void setOrderMenu(OrderMenu orderMenu) {
        this.orderMenu = orderMenu;
    }
}




