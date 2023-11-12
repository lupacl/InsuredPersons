package src.main.java;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {                                     // Main class of the application
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);       // Creating an instance of the Scanner class
        InsuredPersons records = new InsuredPersons();   // Creating an instance of the InsuredPersons class for keeping records of insured persons

        while (true) { // Print navigation menu
            System.out.println("╔════════════════════════════════════════╗");
            System.out.println("║         INSURED PERSONS RECORD         ║");
            System.out.println("╠────────────────────────────────────────╣");
            System.out.println("║  Choose action:                        ║");
            System.out.println("║  1 - Add a new insured person          ║");
            System.out.println("║  2 - List all insured persons          ║");
            System.out.println("║  3 - Search for an insured person      ║");
            System.out.println("║  4 - Exit the application              ║");
            System.out.println("╚════════════════════════════════════════╝");

            int choice = -1; // Initialize choice to an invalid value

            try {
                choice = scanner.nextInt(); // Try to read the choice
            } catch (InputMismatchException e) {
                System.out.println("║▶ Invalid input.");
                scanner.next(); // Read invalid input to move forward
                continue; // Continue to the next iteration of the loop
            }
            scanner.nextLine(); // Clear the line in the console and prepare for the next input on a new line

            switch (choice) { // Choice is compared with cases 1-4, and the corresponding command is executed
                case 1 -> addUser(scanner, records); // Execute the method to add a user (insured person)
                case 2 -> printAllUsers(records); // Display users (insured persons)
                case 3 -> searchUser(scanner, records); // Search for insured persons
                case 4 -> {
                    System.out.println("╔════════════════════════════════════════╗");
                    System.out.println("║   The application has been completed   ║");
                    System.out.println("╚════════════════════════════════════════╝");
                    System.exit(0); // Exit the application
                }
                default -> System.out.println("║▶ Invalid input.");// In case of entering an incorrect number
            }
        }
    }

    // Method to add a new insured person
    private static void addUser(Scanner scanner, InsuredPersons records) {
        System.out.println("╠────────────────────────────────────────╣");
        System.out.println("║  1 - Enter the name:     ");
        String firstName = scanner.nextLine(); // Reading the first name
        while (!isValidName(firstName)) { // Run the method to check the validity of the first name
            System.out.println("║▶ Please enter a valid first name:");
            System.out.println("╠────────────────────────────────────────╣");
            firstName = scanner.nextLine(); // Reading input, if it meets the condition, the program continues
        }
        System.out.println("╠────────────────────────────────────────╣");
        System.out.println("║  2 - Enter the last name:  ");
        String lastName = scanner.nextLine();
        while (!isValidName(lastName)) { // Run the method to check the validity of the last name
            System.out.println("║▶ Please enter a valid last name:");
            System.out.println("╠────────────────────────────────────────╣");
            lastName = scanner.nextLine(); // Reading input, if it meets the condition, the program continues
        }
        int age = readAge(scanner); // Scanner age - separated for condition
        String phone = readPhone(scanner); // Reading and validating the phone number from the user
        TheUser theUser = new TheUser(firstName, lastName, age, phone); // Create a variable theUser and an object using the constructor of the TheUser class with four arguments:
        records.addUser(theUser); // Add the user to the memory - records
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║      Data was successfully stored      ║");
        System.out.println("╠────────────────────────────────────────╣");
        System.out.println("║ Press any key to continue...︎︎︎  ");
        scanner.nextLine();  // Wait for a key press from the user
    }

    // Method to check if the string contains only letters
    private static boolean isValidName(String text) { // Returns yes or no, if it is in the set of characters
        return text.matches("^[a-zA-Zá-žÁ-Ž]+$"); //^ - start of the string, characters we are looking for, +$ - end of the string, all characters must meet the condition
    }

    // Method for age validation
    private static int readAge(Scanner scanner) {
        int age; // Only a whole number
        while (true) { // Capture invalid number format - age must be a non-negative number
            try {
                System.out.println("╠────────────────────────────────────────╣");
                System.out.println("║  3 - Enter the age :       ");
                age = Integer.parseInt(scanner.nextLine()); // Parsing a string to an int while scanning
                if (age >= 15 && age <= 100) { // Check if the age is in the desired range
                    return age;
                } else if (age < 15) { // Cannot insure a user under 15 years old
                    System.out.println("║▶︎ The minimum age is 15 years.");
                } else if (age > 100) { // Cannot insure a user over 100 years old
                    System.out.println("║▶︎ The maximum age is 100 years. ");
                }
            } catch (NumberFormatException e) { // Capture invalid number format, for example, abc
                System.out.println("║▶︎ You entered age format");
            }
        }
    }

    // Method for reading the phone number
    private static String readPhone(Scanner scanner) {
        String phone; // Variable declaration
        while (true) {
            System.out.println("╠────────────────────────────────────────╣");
            System.out.println("║  4 - Enter the phone number:       ");
            phone = scanner.nextLine(); // Reading the phone number
            phone = phone.replaceAll("\\s", ""); // Remove spaces using whitespace \\s
            if (phone.matches("\\d{9}")) { // Check if the phone number has 9 digits using \\d{9}
                return phone;
            } else {
                System.out.println("║▶︎ You entered an invalid phone number"); // If the condition is not met
            }
        }
    }

    // Method to display all insured persons
    private static void printAllUsers(InsuredPersons records) {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║       List of all insured persons      ║");
        System.out.println("╠────────────────────────────────────────╣");

        List<TheUser> allInsured = records.getAllInsured();

        if (allInsured.isEmpty()) { // Condition if no user is saved
            System.out.println("║   You do not have any saved users   ║");
        } else {
            for (TheUser theUser : allInsured) { // Displays insured persons
                System.out.println(theUser);
            }
        }
        System.out.println("╠────────────────────────────────────────╣");
        System.out.println("║ Press any key to continue...     ");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();  // Wait for a key press from the user
    }

    // Method to search for an insured person by name and last name
    private static void searchUser(Scanner scanner, InsuredPersons Records) {
        System.out.println("╠────────────────────────────────────────╣");
        System.out.println("  1 - Enter the name:     ");
        String firstName = scanner.nextLine();
        System.out.println("╠────────────────────────────────────────╣");
        System.out.println("  2 - Enter the last name:  ");
        String lastName = scanner.nextLine();

        List<TheUser> foundInsured = Records.searchUser(firstName, lastName);

        if (!foundInsured.isEmpty()) {
            System.out.println("╔════════════════════════════════════════╗");
            System.out.println("║    The following users were found:     ║");
            System.out.println("╠────────────────────────────────────────╣");
            for (TheUser insured : foundInsured) {
                System.out.println(insured);
            }
        } else {
            System.out.println("╔════════════════════════════════════════╗");
            System.out.println("║           No users were found          ║");
        }
        System.out.println("╠────────────────────────────────────────╣");
        System.out.println("║ Press any key to continue... ");
        scanner.nextLine();  // Wait for a key press from the user
    }
}