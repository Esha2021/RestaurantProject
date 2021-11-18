package com.foodie.restaurant.models;

public class Soup extends AbstractEntity{

    private  String level;

    public Soup() {
    }

    public Soup(String level) {
        super();
        this.level = level;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
