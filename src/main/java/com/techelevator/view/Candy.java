package com.techelevator.view;

public class Candy extends SnackItem{
    private String sound =  "Munch Munch, Yum!";

    public Candy(String ID, String name, Double price) {
        super(ID, name, price);
    }

    /*  Not sure making this method final best practice.
    *   There is no reason for it to be overridden,
    *   but, then if there was in the future, making
    *   it final would prevent a child class from overriding it.
    *   I think this might be a security issue.
    *   (I would love feedback on this.)
    * */
    public final String getSound() {
        return "Munch Munch, Yum!";
    }

    @Override
    public String toString() {
        return super.toString() + ", sound='" + sound + '\'' + "Candy";
    }
}
