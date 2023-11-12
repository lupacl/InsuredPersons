package src.main.java;

class TheUser {

    // Class to represent insured persons
    private String firstName;
    private String lastName;
    private int age;
    private String phone;

    // Constructor for the Insured class that initializes the object with the necessary information
    public TheUser(String firstName, String lastName, int age, String phone) {
        // Convert the first letter of the first name to uppercase, the rest to lowercase
        this.firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase();
        // Convert the first letter of the last name to uppercase, the rest to lowercase
        this.lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1).toLowerCase();
        this.age = age;
        this.phone = phone;
    }

    // Method for a clear overview of information about the insured person
    @Override
    public String toString() {
        return String.format("%-13s %-12s %-3d %-9s", "║ " + firstName, lastName, age, phone + " ║");
    }

    // Getters to get the first name and last name (for searching)
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}

