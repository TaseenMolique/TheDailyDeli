package com.pluralsight;

public class Pricing {

    // Base prices for sandwiches by size
    public static final double smallSandwichPrice = 5.50;
    public static final double mediumSandwichPrice = 7.00;
    public static final double largeSandwichPrice = 8.50;

    // Drink prices by size
    public static final double smallDrinkPrice = 2.00;
    public static final double mediumDrinkPrice = 2.50;
    public static final double largeDrinkPrice = 3.00;

    // Chips price
    public static final double chipsPrice = 1.50;

    // Price Calculations for Sandwich size
    public static double getSandwichPrice(String size) {
        switch (size) {
            case "4\"": return smallSandwichPrice;
            case "8\"": return mediumSandwichPrice;
            case "12\"": return largeSandwichPrice;
            default: return 0.0;
        }
    }

    // Calculate price for drink based on the size
    public static double getDrinkPrice(String size) {
        switch (size) {
            case "Small": return smallDrinkPrice;
            case "Medium": return mediumDrinkPrice;
            case "Large": return largeDrinkPrice;
            default: return 0.0;
        }
    }

    // Price for chips
    public static double getChipsPrice() {
        return chipsPrice;
    }

    // Calculate the price for toppings, based on the sandwich size
    public static double calculateToppingCost(Sandwich sandwich) {
        double totalToppingCost = 0.0;

        // Loop through the toppings in the sandwich and calculate extra cost
        for (Topping topping : sandwich.getToppings()) {
            totalToppingCost += topping.getExtraCost(sandwich.getSize());
        }

        return totalToppingCost;
    }
}
