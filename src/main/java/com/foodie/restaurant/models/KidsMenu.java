package com.foodie.restaurant.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Entity
public class KidsMenu  extends AbstractEntity{

    @NotBlank(message = "Spicelevel is required")
    private String Spicelevel;

    public KidsMenu() {
    }

    public KidsMenu(String spicelevel) {
        super();
        Spicelevel = spicelevel;
    }

    public String getSpicelevel() {
        return Spicelevel;
    }

    public void setSpicelevel(String spicelevel) {
        Spicelevel = spicelevel;
    }
}
