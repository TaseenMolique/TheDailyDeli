package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Sandwich {
    private String bread;
    private String size;
    private List<Topping> toppings;
    private boolean isToasted;

    // Constructor to initialize bread, size, and toppings
    public Sandwich(String bread, String size) {
        this.bread = bread;
        this.size = size;
        this.toppings = new ArrayList<>();
        this.isToasted = false;
    }

    // Add a topping to the sandwich
    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    // Set whether the sandwich is toasted
    public void setToasted(boolean toasted) {
        this.isToasted = toasted;
    }

    // Retrieve the list of toppings
    public List<Topping> getToppings() {
        return toppings;
    }

    // Calculate the price of the sandwich
    public double calculatePrice() {
        // Start with the base price of the sandwich
        double price = Pricing.getSandwichPrice(size);

        // Add the topping cost, considering the size and type of topping
        price += Pricing.calculateToppingCost(this);

        return price;
    }

    // Get details of the sandwich in string format
    public String getDetails() {
        StringBuilder details = new StringBuilder(size + " on " + bread);

        // Append whether the sandwich is toasted
        if (isToasted) {
            details.append(" (Toasted)");
        }

        // Add the toppings to the details
        details.append("\nToppings:\n");
        for (Topping topping : toppings) {
            details.append("- ").append(topping.getName());
            // Add Premium or Regular label and show extra cost
            if (topping.isPremium()) {
                details.append(" (Premium) +$").append(topping.getExtraCost(size));
            } else {
                details.append(" (Regular)");
            }
            details.append("\n");
        }
        return details.toString();
    }

    // Getter for the size of the sandwich
    public String getSize() {
        return size;
    }
}
