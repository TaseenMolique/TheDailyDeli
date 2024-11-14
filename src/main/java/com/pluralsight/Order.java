package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Sandwich> sandwiches;
    private List<Drink> drinks;
    private List<String> chips;

    public Order() {
        this.sandwiches = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.chips = new ArrayList<>();
    }

    //Adds a sandwich to the order
    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }

    //Adds a drink to the order
    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    //Adds chips to the order
    public void addChips(String chipType){
        chips.add(chipType);
    }

    //Calculates the total price of the order by adding up the prices of all items
    public double calculateTotalPrice() {
        double totalPrice = 0;

        //Add prices for all sandwiches
        for (Sandwich sandwich : sandwiches) {
            totalPrice += sandwich.calculatePrice();
        }

        //Add prices for all drinks
        for (Drink drink : drinks) {
            totalPrice += drink.getPrice();
        }

        //Add price for all chips
        totalPrice += chips.size() * Pricing.getChipsPrice();

        return totalPrice;
    }

    //Retrieves a string with the order for displaying / receipt purposes
    public String getOrderDetails() {
        StringBuilder details = new StringBuilder("Order Details:\n");

        //append details of each sandwich
        for (Sandwich sandwich : sandwiches) {
            details.append(sandwich.getDetails()).append("\n");
        }

        for (Drink drink : drinks) {
            details.append("Drink: ").append(drink.getSize()).append(" - ").append(drink.getFlavor()).append("\n");
        }

        for (String chip : chips) {
            details.append("Chips: ").append(chip).append("\n");
        }

        //Append total price
        details.append("Total Price: $").append(calculateTotalPrice()).append("\n");

        return details.toString();
    }
}
