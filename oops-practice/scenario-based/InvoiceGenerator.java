import java.util.Scanner;

class InvalidInvoiceFormatException extends Exception {
    public InvalidInvoiceFormatException(String message) {
        super(message);
    }
}

public class InvoiceGenerator {
	// Creating a method to parse invoice string into individual tasks
    public static String[] parseInvoice(String input) throws InvalidInvoiceFormatException {
    	
    	// Condition to check for invalid input without symbols
    	if (!input.contains("-") || !input.contains(",")) {
            throw new InvalidInvoiceFormatException(
                "Invalid format: Missing '-' or ',' in invoice input"
            );
        }

    	
        return input.split(","); // Splitting the string based on ,
    }

    // Creating a method to calculate the total invoice amount 
    public static int getTotalAmount(String[] tasks) throws InvalidInvoiceFormatException {
        int TOTAL = 0; // Variable for storing the total amount

        // Loop through each task
        for(String task : tasks) {
        	
        	if (!task.contains("-")) {
                throw new InvalidInvoiceFormatException(
                    "Invalid task format: " + task
                );
            } 
        	
            // Splitting task into name and amount using hyphen
            String[] parts = task.split("-");
            
            // Condition to check for invalid input without amount
            if (parts.length < 2) {
                throw new InvalidInvoiceFormatException(
                    "Missing amount in task: " + task
                );
            }

            // parts[1] contains amount with currency
            String amountPart = parts[1].trim();
            
            // Condition to check for invalid input without currency
            if (!amountPart.contains("INR")) {
                throw new InvalidInvoiceFormatException(
                    "Currency missing in task: " + task
                );
            }

            // Removing INR and extra spaces from string
            String amountString = amountPart.replace("INR", "").trim();

            // Converting string amount to integer
            int amount = Integer.parseInt(amountString);
            TOTAL += amount; // Adding amount through each task into the total
        }

        return TOTAL;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
        	System.out.println("Enter the invoice details:");
            String input = sc.nextLine();

            // Calling the method to parse the invoice
            String[] tasks = parseInvoice(input);

            // Calling the method to calculate the total amount
            int totalAmount = getTotalAmount(tasks);
            
            // Loop for displaying the each task separately 
            System.out.println("\nInvoice Breakdown is as follows");
            System.out.println();
            for (String task : tasks) {
                System.out.println(task.trim());
            }        

            System.out.println("\nTotal Invoice Amount: " + totalAmount + " INR");
        } catch (InvalidInvoiceFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
