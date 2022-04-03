package com.techelevator.view;

public class Chips extends SnackItem{
    public String sound = "Crunch Crunch, Yum!";

    public Chips(String ID, String name, Double price) {
        super(ID, name, price);
    }

    public final String getSound() {
        return "Crunch Crunch, Yum!";
    }

    @Override
    public String toString() {
        return super.toString() + ", sound='" + sound + '\'' + "Chip";
    }
}
