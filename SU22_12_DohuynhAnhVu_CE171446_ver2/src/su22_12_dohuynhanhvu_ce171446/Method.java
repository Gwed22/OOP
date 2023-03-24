package su22_12_dohuynhanhvu_ce171446;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Do Huynh Anh Vu - CE171446
 */
public class Method {

    ArrayList<Contact> ct = new ArrayList<>();   //Array list for saving contact data
    Scanner cin = new Scanner(System.in);

    /**
     * Method to check if phone number is valid or not to add contact
     * @param contact
     * @return boolean
     * Valid format in txt
     */
    public boolean addContact(Contact contact) {       //Phone number must match this format
        if (contact.getPN().matches("(\\+\\d{1,3}\\s?)?((\\(\\d{3}\\)\\s?)|(\\d{3})(\\s|-?))(\\d{3}(\\s|-?))(\\d{4})(\\s?(([E|e]xt[:|.|]?)|x|X)(\\s?\\d+))?")) {
            return true;
        } else {
            return false;
        }
    }  
    

    /**
     * Method for input contact data and check if it is valid to add
     */
    public void add() {
        System.out.print("Enter name: ");
        String name = checkString();
        System.out.print("Enter group: ");
        String group = checkString();              //Input contact data
        System.out.print("Enter address: ");
        String address = checkString();
        System.out.print("Enter phone number: ");
        String phonenumber = checkString();
        Contact contact = new Contact(ct.size() + 1, name, group, address, phonenumber);
        if (addContact(contact)) {
            ct.add(contact);
            System.out.println("Create contact success!");
            System.out.println("");                               //Check phone number to see if contact isvalid to add
        } else {                                                  // Then show message to monitor
            System.out.println("Phone number is invalid!");
            System.out.println("");
        }
    }

    /**
     * Method to display all contact saving in array list ct
     */
    public void displayAll() {
        if (ct.isEmpty()) {
            System.out.println("Array empty.");  //Check if array has data
            return;
        }
        System.out.printf("%-5s%-15s%-15s%-15s%-10s%-15s%-20s\n", "ID", "Name", "Fisrt Name", "Last Name", "Group", "Address", "Phone number");
        for (Contact item : ct) { //list every contact in array
            String[] name = item.getName().split(" ", 2);              //get first name and last name of name
            if (name.length == 1) {
                System.out.printf("%-5s%-15s%-15s%-15s%-10s%-15s%-20s\n", item.getID(), item.getName(), "", "", item.getGroup(), item.getAddress(), item.getPN());
            } else {
                System.out.printf("%-5s%-15s%-15s%-15s%-10s%-15s%-20s\n", item.getID(), item.getName(), name[0], name[1], item.getGroup(), item.getAddress(), item.getPN());
            }
        }
        System.out.println("");
    }

    /**
     * Method to delete contact having in array list
     */
    private void delete() {
        if (ct.isEmpty()) {  // Check the list if it  has data
            System.out.println("List empty");
            return;
        }//Check if task with input ID is exist
        int SearchID = deleteContact();
        if (SearchID != -1) {
            ct.remove(SearchID);
            for (int i = SearchID; i < ct.size(); i++) {
                ct.get(i).setID(ct.get(i).getID() - 1); //update new ID after detete task
            }
            System.out.println("Delete success.");
            System.out.println("");
        }
    }

    /**
     * Method to check if contact with input ID is exist
     *
     * @return
     */
    public int deleteContact() {
        System.out.print("Enter ID: ");
        int ID = checkInt();
        for (int i = 0; i < ct.size(); i++) {
            if (ct.get(i).getID() == ID) {    //If there exist return that id
                return ID;
            }
        }
        System.out.println("Not found.");   //Inform if not found
        System.out.println("");
        return -1;
    }

    /**
     * Method to check input - Integer
     */
    private int checkInt() {
        while (true) {       //loop until input user enter is valid
            try {
                int input = Integer.parseInt(cin.nextLine());
                return input;
            } catch (NumberFormatException e) {
                System.err.println("Must enter a integer!");    // Check if input is integer, if not enter again
                System.out.print("Enter again: ");
            }
        }
    }

    /**
     * Method check the input valid or not (in range min -> max)
     *
     * @param min
     * @param max
     * @return input option (integer)
     */
    public int checkChoice(int min, int max) {
        while (true) { //loop until user input correct
            try {
                int input = Integer.parseInt(cin.nextLine().trim());
                if (input < min || input > max) {
                    throw new NumberFormatException();      //input out of range -> throw exception

                }
                return input;
            } catch (NumberFormatException e) {
                System.out.println("Please input number in range [" + min + ", " + max + "]"); //If wrong, show message and re-input
                System.out.print("Enter again: ");
            }
        }
    }

    /**
     * Method check input String is valid or not (not empty)
     *
     * @return valid String
     */
    public String checkString() {
        //loop until user input correct
        while (true) {
            String input = cin.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return input;
            }
        }
    }

    /**
     * Method for displaying menu and take input option from user
     */
    public void menu() {
        while (true) { //loop until choose exit (choice = 4)
            System.out.println("======== CONTACT MANAGEMENT ==========");
            System.out.println("1. Add contact.");
            System.out.println("2. Display all contact");             // Display menu to monitor
            System.out.println("3. Delete contact");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = checkChoice(1, 4);  //take input option and check
            switch (choice) {
                case 1:
                    System.out.println("===== ADD CONTACT =====");
                    add();
                    break;
                case 2:
                    System.out.println("===== DISPLAY CONTACT =====");
                    displayAll();                                  // Switch to user option and call methed to execute
                    break;
                case 3:
                    System.out.println("===== DELETE CONTACT =====");
                    delete();
                    break;
                case 4:
                    return;
            }
        }
    }

    /**
     * Main method to execute all program
     *
     * @param args
     */
    public static void main(String[] args) {
        //call menu method where to take user input option and call function method to exucute program
        Method m = new Method();
        m.menu();
    }
}
