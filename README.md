
# The Daily Deli

The Daily Deli is a Java-based Point of Sales (POS) application designed for DELI-cious, a custom sandwich shop. This application simplifies the ordering process, allowing customers to customize their sandwiches, add drinks or chips, and generate detailed receipts. It leverages object-oriented programming principles for modularity and scalability.


## Features

1.  Custom Sandwich Builder
* Choose bread type (white, wheat, rye, wrap).
* Select sandwich size (4", 8", 12") with respective pricing.
* Add toppings:
    * Meats (e.g., steak, ham, chicken) with optional extra portions.
    * Cheeses (e.g., American, provolone) with optional extra portions.
    * Free toppings (e.g., lettuce, tomatoes, sauces).
* Option to toast sandwiches.

2. Additional Products:
* Add drinks with size and flavor options.
* Add chips by type.

3. Order Management:
* Add multiple items to an order.
* View and confirm order summary.
* Cancel orders at any stage.

4. Automated Receipt Generation:
* Displays itemized pricing for all components.
* Saves receipts in a local receipts folder.

5. Pricing Overview:
* Sandwiches:
    * 4": $5.50, 8": $7.00, 12": $8.50.
* Meats: $1.00-$3.00 based on size; extra portions available.
* Cheeses: $0.75-$2.25 based on size; extra portions available.
* Drinks: Small $2.00, Medium $2.50, Large $3.00.
* Chips: $1.50.
## Technology Used

* Java 17 (or higher) for application logic.
* Object-Oriented Programming principles for modular code structure.
* File I/O for saving receipts in text files.
* LocalDate for handling dates.

## Usage
1. Launch the application.
2. Follow on-screen prompts to:
* Add sandwiches, drinks, or chips to an order.
* Customize sandwiches with bread, size, toppings, and toasting options.
3. View the total price at checkout.
4. Confirm or cancel the order.
5. Retrieve the receipt from the receipts folder.



## Sample Receipt Output
********** The Daily Deli **********
=====================================
Receipt #20241115
Date: 11/15/2024
Time: 02:27 AM
-------------------------------------
Sandwiches:
1. 12" on White Bread
Toppings:
- Steak (Premium) +$4.0
- Cheddar Cheese (Premium) +$1.5
- Chipotle Sauce (Regular)
- Lettuce (Regular)
- Tomato (Regular)
- Onions (Regular)
- Cucumbers (Regular)
- Mayo (Regular)
 - $14.00
- Chips: $1.5
- Drinks:
1. Large - $3.00
-------------------------------------
Total: $18.50
*************************************
Thank you for choosing The Daily Deli!
Visit us again soon!
*************************************

## Future Enhancements
1. Implement a graphical user interface (GUI).
2. Add support for loyalty programs and discounts.
3. Expand product offerings (e.g., desserts, soups).

## Contributers

- Taseen Molique 
* Email : taseenm100@gmail.com 
* GitHub : https://github.com/TaseenMolique
* Linkedin : www.linkedin.com/in/taseen-molique-85b71221b





## License

[MIT](https://choosealicense.com/licenses/mit/)

This project is licensed under the MIT License. See the LICENSE file for details.
