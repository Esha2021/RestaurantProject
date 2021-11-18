package com.foodie.restaurant.models;

public class Sweet extends AbstractEntity{

    private String type;

    public Sweet() {
    }

    public Sweet(String type) {
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
