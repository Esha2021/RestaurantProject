package com.foodie.restaurant.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Appetizer extends AbstractEntity {




    private String type;


    public Appetizer() {
    }

    public Appetizer( String type) {
        super();

        this.type = type;
    }



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
