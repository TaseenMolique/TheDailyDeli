package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Topping {
    private String name;
    private boolean isPremium;
    private double extraCost;

    // List of all available toppings
    private static final List<Topping> availableToppings = new ArrayList<>();

    // Initialize available toppings
    static {
        // Regular toppings
        availableToppings.add(new Topping("Lettuce", false, 0.00));
        availableToppings.add(new Topping("Tomato", false, 0.00));
        availableToppings.add(new Topping("Onions", false, 0.00));
        availableToppings.add(new Topping("Cucumbers", false, 0.00));
        availableToppings.add(new Topping("Jalapenos", false, 0.00));
        availableToppings.add(new Topping("Chipotle Sauce", false, 0.00));
        availableToppings.add(new Topping("BBQ sauce", false, 0.00));
        availableToppings.add(new Topping("Honey Mustard", false, 0.00));
        availableToppings.add(new Topping("Mayo", false, 0.00));

        // Premium toppings
        availableToppings.add(new Topping("Guacamole", true, 0.50));
        availableToppings.add(new Topping("Pickle chips", true, 0.50));
        availableToppings.add(new Topping("Swiss Cheese", true, 0.75));
        availableToppings.add(new Topping("Provolone Cheese", true, 0.75));
        availableToppings.add(new Topping("Cheddar Cheese", true, 0.75));
        availableToppings.add(new Topping("Beef Bacon", true, 1.00));
        availableToppings.add(new Topping("Chicken", true, 1.50));
        availableToppings.add(new Topping("Steak", true, 2.00));
        availableToppings.add(new Topping("Lamb", true, 2.50));
    }

    // Constructor for Topping object
    public Topping(String name, boolean isPremium, double extraCost) {
        this.name = name;
        this.isPremium = isPremium;
        this.extraCost = extraCost;
    }

    // Getter for topping name
    public String getName() {
        return name;
    }

    // Returns true if the topping is premium
    public boolean isPremium() {
        return isPremium;
    }

    // Returns the adjusted cost based on sandwich size
    public double getExtraCost(String size) {
        // If it's not a premium topping, no extra cost
        if (!isPremium) {
            return 0.0;
        }

        // If it's a premium topping, calculate based on size (fixed extra cost)
        switch (size) {
            case "4\"":
                return extraCost;  // No multiplier for smaller size
            case "8\"":
                return extraCost * 1.5;  // Increased cost for larger sizes
            case "12\"":
                return extraCost * 2;  // Even higher cost for the largest size
            default:
                return extraCost;  // Default to original cost if size is unknown
        }
    }

    // Getter for the price of the toppings
    public static List<Topping> getAvailableToppings() {
        return availableToppings;
    }
}
