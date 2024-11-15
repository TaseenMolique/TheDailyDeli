package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Sandwich> sandwiches;
    private List<String> drinks;
    private boolean hasChips;

    public Order() {
        this.sandwiches = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.hasChips = false;
    }

    // Adds a sandwich to the order
    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }

    // Adds chips to the order
    public void addChips() {
        this.hasChips = true;
    }

    // Adds a drink to the order
    public void addDrink(String size) {
        drinks.add(size);
    }

    // Calculates the total price of the order by adding up the prices of all items
    public double calculateTotalPrice() {
        double totalPrice = 0;

        // Add prices for all sandwiches
        for (Sandwich sandwich : sandwiches) {
            totalPrice += sandwich.calculatePrice();
        }

        // Add chips price if included
        if (hasChips) totalPrice += Pricing.getChipsPrice();

        // Add prices for each drink based on size
        for (String drinkSize : drinks) {
            totalPrice += Pricing.getDrinkPrice(drinkSize);
        }
        return totalPrice;
    }

    // Retrieves a string with the order for displaying / receipt purposes
    public String getReceiptDetails() {
        StringBuilder receipt = new StringBuilder();
        receipt.append("Order Summary:\n");

        int sandwichCount = 1;
        for (Sandwich sandwich : sandwiches) {
            receipt.append("Sandwich ").append(sandwichCount++).append(": ").append(sandwich.getDetails()).append("\n");
        }

        if (hasChips) {
            receipt.append("Chips: ").append(Pricing.getChipsPrice()).append("\n");
        }

        int drinkCount = 1;
        for (String drinkSize : drinks) {
            receipt.append("Drink ").append(drinkCount++).append(" (").append(drinkSize).append("): ")
                    .append(Pricing.getDrinkPrice(drinkSize)).append("\n");
        }

        receipt.append("Total: $").append(String.format("%.2f", calculateTotalPrice()));
        return receipt.toString();
    }

    // Getter for sandwiches list
    public List<Sandwich> getSandwiches() {
        return sandwiches;
    }

    // Getter for drinks list
    public List<String> getDrinks() {
        return drinks;
    }

    // Check if the order includes chips
    public boolean hasChips() {
        return hasChips;
    }
}
