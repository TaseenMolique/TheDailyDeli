package com.pluralsight;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Receipt {
    private static final String receiptFolder = "receipts"; //Directory for receipts

    //Saves the order details to the receipt file
    public static void saveReceipt(Order order) {
        try {
            Files.createDirectories(Paths.get(receiptFolder));

            //Format the current time for the file name
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
            String timeStamp = LocalDateTime.now().format(formatter);
            String fileName = receiptFolder + "/" + timeStamp + ".txt";

            //Write order details to the file
            try (FileWriter writer = new FileWriter(fileName)) {
                writer.write(order.getOrderDetails());
            }

            System.out.println("Receipt saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());
        }
    }

}
