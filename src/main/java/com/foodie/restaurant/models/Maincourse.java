package com.foodie.restaurant.models;

public class Maincourse  extends AbstractEntity{

    private String typeOfFood;

    public Maincourse() {
    }

    public Maincourse(String typeOfFood) {
        super();
        this.typeOfFood = typeOfFood;
    }

    public String getTypeOfFood() {
        return typeOfFood;
    }

    public void setTypeOfFood(String typeOfFood) {
        this.typeOfFood = typeOfFood;
    }
}
