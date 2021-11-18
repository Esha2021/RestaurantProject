package com.foodie.restaurant.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Appetizer extends AbstractEntity {


    private String type;


    public Appetizer() {
    }

    public Appetizer(String type) {
        super();
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type ;
    }
}
