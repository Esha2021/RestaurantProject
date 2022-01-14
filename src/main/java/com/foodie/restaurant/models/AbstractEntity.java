package com.foodie.restaurant.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@MappedSuperclass
public class AbstractEntity {
    @Id
    @GeneratedValue
    private int id;

    @NotBlank(message="Should not be blank")
    private String name;

    @NotBlank(message="Should not be blank")
    private String description;

    @NotNull
    private double price;

    private String type;

    private int itemcount;

    public int getItemCount() {
        return itemcount;
    }

    public void setItemCount(int itemCount) {
        this.itemcount = itemcount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public AbstractEntity() {
    }

    public AbstractEntity(String name, String description, double price, String type, int itemCount) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.type = type;
        this.itemcount = itemCount;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEntity that = (AbstractEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
