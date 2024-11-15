package com.pluralsight;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Receipt {

    // Save the receipt to a file with a fancy format
    public static void saveReceipt(Order order) {
        // Create a receipt file name using the current date and time
        String datePart = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        String timePart = LocalTime.now().format(DateTimeFormatter.ofPattern("HHmmss")); // Format for time: HHmmss (24-hour clock)
        String fileName = "receipts/receipt_" + datePart + "_" + timePart + ".txt";

        // Ensure the 'receipts' folder exists
        File receiptsFolder = new File("receipts");
        if (!receiptsFolder.exists()) {
            boolean folderCreated = receiptsFolder.mkdir();
            if (!folderCreated) {
                System.out.println("Failed to create the receipts folder. Make sure the directory is accessible.");
                return;  // Return if folder creation fails
            }
        }

        // Try to write the formatted receipt details to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            // Write the header with borders
            writer.write("********** The Daily Deli **********\n");
            writer.write("=====================================\n");

            // Write receipt number
            writer.write("Receipt #" + datePart + "\n");

            // Write date and time
            writer.write("Date: " + LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")) + "\n");
            writer.write("Time: " + LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm a")) + "\n"); // 12-hour format with AM/PM

            writer.write("-------------------------------------\n");

            // Write the sandwich details
            writer.write("Sandwiches:\n");
            int sandwichCount = 1;
            for (Sandwich sandwich : order.getSandwiches()) {
                writer.write(String.format("%d. %s - $%.2f\n", sandwichCount++, sandwich.getDetails(), sandwich.calculatePrice()));
            }

            // Write chips details (check if chips are added to the order)
            if (order.hasChips()) {
                writer.write("Chips: $" + Pricing.getChipsPrice() + "\n");
            }

            // Write drink details (if there are any drinks in the order)
            if (!order.getDrinks().isEmpty()) {
                writer.write("Drinks:\n");
                int drinkCount = 1;
                for (String drinkSize : order.getDrinks()) {
                    writer.write(String.format("%d. %s - $%.2f\n", drinkCount++, drinkSize, Pricing.getDrinkPrice(drinkSize)));
                }
            }

            // Write total price
            writer.write("-------------------------------------\n");
            writer.write("Total: $" + String.format("%.2f", order.calculateTotalPrice()) + "\n");

            // Footer message
            writer.write("*************************************\n");
            writer.write("Thank you for choosing The Daily Deli!\n");
            writer.write("Visit us again soon!\n");
            writer.write("*************************************\n");

            System.out.println("Receipt saved to: " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());
        }
    }
}