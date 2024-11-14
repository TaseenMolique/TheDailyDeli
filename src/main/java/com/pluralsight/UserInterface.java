package com.pluralsight;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;

    public UserInterface() {
        this.scanner = new Scanner(System.in);
    }

    //Displays the main meu and handles user's choice
    public void displayMenu() {
        Order currentOrder = null;
        boolean running = true;

        while (running) {
            System.out.println("Welcome to the Daily Deli!");
            System.out.println("1) New Order");
            System.out.println("0) Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    currentOrder = new Order();
                    processOrder(currentOrder);
                    break;
                case 0:
                    running = false;
                    System.out.println("Thank you for visiting The Daily Deli!");
                    break;
                default:
                    System.out.println("Invalid Choice. Please try again.");
            }
        }
    }

    //Guides the user through adding items to their orders
    private void processOrder(Order order) {
        boolean ordering = true;

        while (ordering) {
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    order.addSandwich(createSandwich());
                    break;
                case 2:
                    order.addDrink(createDrink());
                    break;
                case 3:
                    System.out.println("Enter chip type: ");
                    String chipType = scanner.nextLine();
                    order.addChips(chipType);
                    break;
                case 4:
                    Receipt.saveReceipt(order);
                    ordering = false;
                    break;
                case 0:
                    System.out.println("Order Cancelled.");
                    ordering = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    //Create a new sandwich based on user input
    private Sandwich createSandwich() {
        System.out.println("Enter bread type: ");
        String bread = scanner.nextLine();

        System.out.println("Enter sandwich size (4\", 8\", 12\"): ");
        String size = scanner.nextLine();

        Sandwich sandwich = new Sandwich(bread, size);

        //Adds toppings based on user input
        boolean addingToppings = true;
        while (addingToppings) {
            System.out.println("Select a topping to add:");
            System.out.println("1) Lettuce");
            System.out.println("2) Tomato");
            System.out.println("3) Onions");
            System.out.println("4) Cucumbers");
            System.out.println("5) Jalapenos");
            System.out.println("6) Chipotle Sauce");
            System.out.println("7) BBQ Sauce");
            System.out.println("8) Honey Mustard");
            System.out.println("9) Mayo");
            System.out.println("10) Guacamole (Premium)");
            System.out.println("11) Pickle Chips (Premium)");
            System.out.println("12) Swiss Cheese (Premium)");
            System.out.println("13) Provolone Cheese (Premium)");
            System.out.println("14) Cheddar Cheese (Premium)");
            System.out.println("15) Beef Bacon (Premium)");
            System.out.println("16) Chicken (Premium)");
            System.out.println("17) Steak (Premium)");
            System.out.println("18) Lamb (Premium)");
            System.out.println("0) Finish adding toppings");

            int toppingChoice = scanner.nextInt();
            scanner.nextLine();

            if (toppingChoice == 0) {
                addingToppings = false;
            } else {
                Topping topping = getToppingFromChoice(toppingChoice);
                if (topping != null) {
                    sandwich.addTopping(topping);
                    System.out.println(topping.getName() + " added to your sandwich!");
                } else {
                    System.out.println("Invalid topping choice. Please try again.");
                }
            }
        }

        //Asks if you want your sandwich toasted
        System.out.println("Do you want the sandwich toasted? (yes/no): ");
        String toasted = scanner.nextLine();
        sandwich.setToasted(toasted.equalsIgnoreCase("yes"));

        return sandwich;
    }

    //Maps user choice to a topping
    private Topping getToppingFromChoice(int choice) {
        switch (choice) {
            case 1: return Topping.getAvailableToppings().get(0); //Lettuce
            case 2: return Topping.getAvailableToppings().get(1); //Tomato
            case 3: return Topping.getAvailableToppings().get(2); //Onions
            case 4: return Topping.getAvailableToppings().get(3); //Cucumbers
            case 5: return Topping.getAvailableToppings().get(4); //Jalapenos
            case 6: return Topping.getAvailableToppings().get(5); //Chipotle Sauce
            case 7: return Topping.getAvailableToppings().get(6); //BBQ Sauce
            case 8: return Topping.getAvailableToppings().get(7); //Honey Mustard
            case 9: return Topping.getAvailableToppings().get(8); //Mayo
            case 10: return Topping.getAvailableToppings().get(9); //Guacamole
            case 11: return Topping.getAvailableToppings().get(10); //Pickle Chips
            case 12: return Topping.getAvailableToppings().get(11); //Swiss Cheese
            case 13: return Topping.getAvailableToppings().get(12); //Provolone Cheese
            case 14: return Topping.getAvailableToppings().get(13); //Cheddar Cheese
            case 15: return Topping.getAvailableToppings().get(14); //Beef Bacon
            case 16: return Topping.getAvailableToppings().get(15); //Chicken
            case 17: return Topping.getAvailableToppings().get(16); //Steak
            case 18: return Topping.getAvailableToppings().get(17); //Lamb
            default: return null;
        }
    }

    //Creates a new drink based on user input
    private Drink createDrink() {
        System.out.print("Enter drink size (Small, Medium, Large): ");
        String size = scanner.nextLine();

        System.out.println("Enter drink flavor: ");
        String flavor = scanner.nextLine();

        return new Drink(size, flavor);
    }
}
