package com.pluralsight;

public class Drink {
    private String size;
    private String flavor;

    public Drink(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    public String getSize() {
        return size;
    }

    public String getFlavor() {
        return flavor;
    }

    //Get the price of the drink, based on the size
    public double getPrice() {
        return Pricing.getDrinkPrice(this.size);
    }
}
