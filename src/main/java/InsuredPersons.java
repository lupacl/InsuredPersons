package src.main.java;

import java.util.ArrayList;
import java.util.List;

class InsuredPersons {
    private List<TheUser> insuredList = new ArrayList<>();

    // Method to add an insured person to the list
    public void addUser(TheUser theUser) {
        insuredList.add(theUser);
    }

    // Method to return a list of all insured persons
    public List<TheUser> getAllInsured() {
        return insuredList;
    }

    // Method to search for an insured person by name and last name
    public List<TheUser> searchUser(String firstName, String lastName) {
        List<TheUser> foundInsured = new ArrayList<>();

        for (TheUser theUser : insuredList) {
            if (theUser.getFirstName().equalsIgnoreCase(firstName) && theUser.getLastName().equalsIgnoreCase(lastName)) {
                foundInsured.add(theUser);
            }
        }
        return foundInsured;
    }
}
