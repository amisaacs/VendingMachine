package com.techelevator.view;

import java.util.ArrayList;
import java.util.List;

public abstract class SnackItem {

    private String ID;
    private String name;
    private Double price;
    private String sound;



    public SnackItem(String ID, String name, Double price) {
        this.ID = ID;
        this.name = name;
        this.price = price;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    /*   In the child classes this method is set as final.
     *   Not sure making this method final in the child classes is best practice.
     *   There is no reason for it to be overridden,
     *   but, then if there was in the future, making
     *   it final would prevent a child class from overriding it.
     *   I think this might be a security issue.
     *   (I would love feedback on this.)
     * */
    public String getSound() {
        return sound;
    }

    @Override
    public String toString() {
        return "SnackItems{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price + "}";
    }
}
