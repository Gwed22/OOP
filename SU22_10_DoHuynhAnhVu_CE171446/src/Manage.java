
import java.text.*;
import java.util.*;

/**
 *
 * @author Do Huynh Anh Vu - CE171446
 */
public class Manage {

    Scanner cin = new Scanner(System.in);

    /**
     * Method to check input that in range of min and max
     */
    private int checkChoice(int min, int max) {
        while (true) {     //loop until input user enter is valid
            try {
                int n = Integer.parseInt(cin.nextLine());
                if (n < min || n > max) {
                    throw new NumberFormatException();         //out of range min max throw Exception
                }
                return n;
            } catch (NumberFormatException ex) {
                System.err.println("Please choose from " + min + " -> " + max + "!");        //If not valid throw exception and inform the right input
                System.out.print("Enter again: ");  //Enter again
            }
        }
    }

    /**
     * Method to check input with date format (DD-MM-YYYY)
     */
    private String checkDate() {
        while (true) { //loop until input user enter is valid
            try {
                String inputD = cin.nextLine().trim();
                SimpleDateFormat fm = new SimpleDateFormat("dd-MM-yyyy");
                Date date = fm.parse(inputD);
                if (inputD.equalsIgnoreCase(fm.format(date))) {          // Check if input is valid with the format
                    return inputD;
                } else {
                    throw new NumberFormatException();    //Wrong format throw Exception
                }
            } catch (NumberFormatException | ParseException e) {
                System.err.println("You must enter following format DD-MM-YYYY!");  //If not valid throw exception and inform the right input
                System.out.print("Enter again: ");  //Enter again
            }
        }
    }

    /**
     * Method to check String input - not empty
     */
    private String checkString() {
        while (true) {      //loop until input user enter is valid
            String inputS = cin.nextLine().trim();
            if (inputS.isEmpty()) {                // Check if input string is empty
                System.err.println("String can not be empty!");
                System.out.print("Enter again: ");         //Enter again if input is empty
            } else {
                return inputS;
            }
        }
    }

    /**
     * Method to check input - Integer
     */
    private int checkInt() {
        while (true) {       //loop until input user enter is valid
            try {
                int result = Integer.parseInt(cin.nextLine());    
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Must enter a integer!");    // Check if input is integer, if not enter again
                System.out.print("Enter again: ");
            }
        }
    }

    /**
     * Method to check input with plan format - 8h -> 17h30 (8.0; 8.5; 9.0; 9.5; ...)
     */
    private String checkPlan() {
        while (true) {      //loop until input user enter is valid
            String inputS = checkString();
            if (inputS.matches("^[0-9]{1,2}\\.5|[0-9]{1,2}\\.0$") && Double.parseDouble(inputS) >= 8.0
                    && Double.parseDouble(inputS) <= 17.5) {         // check if input plan is from 8.0 - 17.5
                return inputS;
            } else {
                System.err.println("You must enter from 8h -> 17h30 (8.0; 8.5; 9.0; 9.5; ...)!");  //Inform the right input form and enter again if wrong input
                System.out.print("Enter again: ");
            }
        }
    }

    /**
     * Method to check input Task Type ID 
     */
    private String InputTaskTypeID() {
        while (true) {
            int n = checkChoice(1, 4);    //Check input integer is from 1-4
            String task = null;
            switch (n) {
                case 1:
                    task = "Code";
                    break;
                case 2:
                    task = "Analyze";        //When choose return that value
                    break;
                case 3:
                    task = "Debug";
                    break;
                case 4:
                    task = "Test";
            }
            return task;
        }
    }

    /**
     * Method to display menu to monitor and take option input from user
     */
    public void menu() {
        while (true) {
            System.out.println("====== TASK PROGRAM ======");
            System.out.println("1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("3. Display Task");
            System.out.println("4. Exit");             //Display menu to monitor
            System.out.print("Enter your choice: ");
            int choice = checkChoice(1, 4);    //take option choice
            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    deleteTask();    // Call method to process to option user enter
                    break;
                case 3:
                    getDataTask();
                    break;
                case 4:
                    return;

            }
        }
    }

    ArrayList<Work> wk = new ArrayList<>();  // Initialize array list of obj to save data

    /**
     * Method to add new task and check if input valid
     */
    private void addTask() {
        System.out.println("\n========= ADD TASK =========");
        System.out.print("Enter Requirement Name: ");
        String name = checkString();
        System.out.print("Enter Task ID: ");
        String taskID = InputTaskTypeID();
        System.out.print("Enter Date: ");
        String date = checkDate();                      // Input data and check if input is valid
        System.out.print("Enter Plan from: ");
        String planF = checkPlan();
        System.out.print("Enter Plan To: ");
        String planT = checkPlan();
        while (true) {   //loop until plan from is smaller than plan to
            if (Double.parseDouble(planF) >= Double.parseDouble(planT)) {  //Check plan from < plan to, if wrong enter again 
                System.err.println("Plan to can not be smaller than plan from!");
                System.out.print("Enter Plan from: ");           
                planF = checkPlan();
                System.out.print("Enter Plan To: ");
                planT = checkPlan();
            } else {
                break; // if valid break the loop
            }
        }
        System.out.print("Enter Assigner: ");
        String assigner = checkString();
        System.out.print("Enter Reviewer: ");
        String reviewer = checkString();
        wk.add(new Work(wk.size() + 1, taskID, name, date, planF, planT, assigner, reviewer)); //add new task to the array list
        System.out.println("Add Task Success."); //Inform that adding is success
        System.out.println("");
    }

    /**
     * Method to delete task having in array list
     */
    private void deleteTask() {
        System.out.println("\n======== DELETE TASK =========");
        if (wk.isEmpty()) {  // Check the list if it  has data
            System.err.println("List empty");
            return;
        }
        int SearchID = TaskExist(); //Check if task with input ID is exist
        if (SearchID != -1) {
            wk.remove(SearchID);
            for (int i = SearchID; i < wk.size(); i++) {
                wk.get(i).setID(wk.get(i).getID() - 1); //update new ID after detete task
            }
            System.out.println("Delete success.");
            System.out.println("");
        }
    }

    /**
     * Method to check if task with input ID is exist
     */
    private int TaskExist() {
        System.out.print("Enter ID: ");
        int ID = checkInt();
        for (int i = 0; i < wk.size(); i++) {
            if (wk.get(i).getID() == ID) {    //If there exist return that id
                return i;
            }
        }
        System.out.println("Not found.");   //Inform if not found
        System.out.println("");
        return -1;
    }

    /**
     * Method to display all data in array list to monitor
     */
    private void getDataTask() {
        System.out.println("\n============================================== TASK =====================================================");
        if (wk.isEmpty()) {
            System.err.println("List empty."); // Check if list have data to display
            return;
        }
        System.out.printf("%-5s%-25s%-15s%-15s%-15s%-15s%-15s\n",
                "ID", "Name", "Task Type", "Date", "Time", "Assign", "Reviewer");
        for (int i = 0; i < wk.size(); i++) {
            System.out.printf("%-5d%-25s%-15s%-15s%-15.1f%-15s%-15s\n",
                    wk.get(i).getID(),
                    wk.get(i).getRequirementName(),        // Display all obj in array list
                    wk.get(i).getTaskTypeID(),
                    wk.get(i).getDate(),
                    Double.parseDouble(wk.get(i).getPlanT()) - Double.parseDouble(wk.get(i).getPlanF()),
                    wk.get(i).getAssigner(),
                    wk.get(i).getReviewer());
        }
        System.out.println("");
    }

    /**
     * Main method to process the program
     * @param args
     */
    public static void main(String[] args) {
        Manage mn = new Manage();
        mn.menu(); //call menu to execute all function of program
    }
}
