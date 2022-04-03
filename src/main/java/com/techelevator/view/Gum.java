package com.techelevator.view;

public class Gum extends SnackItem{
    private final String sound =  "Chew Chew, Yum!";

    public Gum(String ID, String name, Double price) {
        super(ID, name, price);
    }

    public final String getSound() {return "Chew Chew, Yum!";}

    @Override
    public String toString() {
        return super.toString() + ", sound='" + sound + '\'' + "Gum";
    }
}
