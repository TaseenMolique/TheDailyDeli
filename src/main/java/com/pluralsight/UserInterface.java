package com.pluralsight;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;

    // ANSI Escape codes for colors
    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String CYAN = "\u001B[36m";
    private static final String BLUE = "\u001B[34m";

    // Box Drawing Characters
    private static final String BOX_BORDER = "╔═════════════════════════════════╗";
    private static final String BOX_BOTTOM = "╚═════════════════════════════════╝";

    public UserInterface() {
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        boolean running = true;

        while (running) {
            printTitle("The Daily Deli");
            System.out.println(CYAN + BOX_BORDER + RESET);
            System.out.println(GREEN + "1) New Order" + RESET);
            System.out.println(RED + "0) Exit" + RESET);
            System.out.println(CYAN + BOX_BOTTOM + RESET);

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    Order currentOrder = new Order();
                    processOrder(currentOrder);
                    break;
                case 0:
                    System.out.println(GREEN + "Thank you for visiting The Daily Deli!" + RESET);
                    running = false;
                    break;
                default:
                    System.out.println(RED + "Invalid option. Please try again." + RESET);
            }
        }
    }

    private void processOrder(Order currentOrder) {
        // Process the order in a fancy manner
        String bread = getBreadChoice();
        String size = getSizeChoice();
        Sandwich sandwich = new Sandwich(bread, size);

        // Add toppings
        addToppings(sandwich);
        currentOrder.addSandwich(sandwich);

        // Confirm sandwich creation
        System.out.println(CYAN + "Your sandwich has been created!" + RESET);
        System.out.println(sandwich.getDetails());

        // Add chips and drinks, if desired
        String addChips = getUserInput("Would you like to add chips? (yes/no): ");
        if (addChips.equalsIgnoreCase("yes")) {
            currentOrder.addChips();
        }

        String addDrink = getUserInput("Would you like to add a drink? (yes/no): ");
        if (addDrink.equalsIgnoreCase("yes")) {
            String drinkSize = getDrinkSizeChoice();
            currentOrder.addDrink(drinkSize); // Pass the drink size here
        }

        // Display the loading animation
        displayLoading();

        // Print the final receipt
        Receipt.saveReceipt(currentOrder);
    }

    private String getDrinkSizeChoice() {
        System.out.println(CYAN + "Choose your drink size: Small, Medium, Large" + RESET);
        return getUserInput("Enter drink size: ");
    }

    private String getBreadChoice() {
        System.out.println(CYAN + "Choose your bread: White, Wheat, Rye, Wrap" + RESET);
        return getUserInput("Enter bread choice:");
    }

    private String getSizeChoice() {
        System.out.println(CYAN + "Choose your sandwich size (4\", 8\", 12\")" + RESET);
        return getUserInput("Enter size: ");
    }

    private void addToppings(Sandwich sandwich) {
        String addToppings;
        do {
            System.out.println(CYAN + "Choose your toppings (enter 'done' to finish):" + RESET);
            System.out.println(GREEN + "Available Toppings:" + RESET);
            for (Topping topping : Topping.getAvailableToppings()) {
                System.out.println(topping.getName() + (topping.isPremium() ? " (Premium)" : ""));
            }

            addToppings = getUserInput("Enter toppings or 'done': ");
            if (!addToppings.equalsIgnoreCase("done")) {
                Topping topping = getToppingByName(addToppings);
                if (topping != null) {
                    sandwich.addTopping(topping);
                    System.out.println(GREEN + "Topping added: " + topping.getName() + RESET);
                } else {
                    System.out.println(RED + "Invalid topping. Try again." + RESET);
                }
            }
        } while (!addToppings.equalsIgnoreCase("done"));
    }

    private Topping getToppingByName(String name) {
        for (Topping topping : Topping.getAvailableToppings()) {
            if (topping.getName().equalsIgnoreCase(name)) {
                return topping;
            }
        }
        return null;
    }

    private String getUserInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public void printTitle(String title) {
        System.out.println(CYAN + BOX_BORDER + RESET);
        System.out.println(CYAN + " " + title + " ");
        System.out.println(CYAN + BOX_BOTTOM + RESET);
    }

    private void displayLoading() {
        String[] animation = {"|", "/", "-", "\\"};
        for (int i = 0; i < 10; i++) {
            try {
                System.out.print("\r" + BLUE + "Processing " + animation[i % 4] + RESET);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("\r" + GREEN + "Done!" + RESET);
    }
}
