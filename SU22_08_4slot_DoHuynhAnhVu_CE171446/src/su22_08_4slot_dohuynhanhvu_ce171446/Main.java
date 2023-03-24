package su22_08_4slot_dohuynhanhvu_ce171446;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

/**
 *
 * @author Do Huynh Anh Vu - CE171446
 */
public class Main {

    CheckInput check = new CheckInput();
    Worker wk = new Worker();
    ArrayList<Worker> List = new ArrayList<>();     // Initiallize array for storing information and object for method to proceed on
    ArrayList<Status> st = new ArrayList<>();

    //show menu
    /**
     * Method show menu and get input option from user
     *
     * @return option user have been choose
     */
    public int menu() {
        System.out.println("======= WORKER MANAGEMENT =======");
        System.out.println("1. Add worker.");
        System.out.println("2. Increase salary for worker.");
        System.out.println("3. Decrease for worker");                     //Show menu to monitor
        System.out.println("4. Show adjusted salary worker information");
        System.out.println("5. Exist");
        System.out.print("Enter your choice: ");
        int choice = check.checkChoice(1, 5);   //Check if input option is valid
        return choice;
    }

    /**
     * Method add worker to worker arraylist(List) and update that status in
     * status arraylist(st)
     */
    public void addWorker() {
        System.out.print("Enter code: ");
        String ID = check.checkString();      //check input String is valid
        if (check.IdExist(List, ID) == true) {
            System.out.println("ID has been existed!"); // return menu if ID is existed
            return;
        }
        System.out.print("Enter name: ");
        String name = check.checkString();
        System.out.print("Enter age: ");
        int age = check.checkChoice(18, 50);       // Enter information of worker (ID, Name, Age, Salary, Workplace) and validated
        System.out.print("Enter salary: ");
        int salary = check.checkInt();
        System.out.print("Enter work location: ");
        String workLocation = check.checkString();
        if (!check.checkWorkerExist(List, name, age, salary, workLocation)) { // Check if there is worker with other ID but with same information
            System.out.println("Duplicate.");   // Show message if found
        } else {
            List.add(new Worker(ID, name, age, salary, workLocation));  //Add that information into worker array List
            st.add(new Status(ID, name, age, salary, workLocation, "UP", getCurrentDate()));    // update salary status of that worker
            System.out.println("Add success.");
        }
    }

    /**
     * Method to update salary of woker
     *
     * @param status
     */
    public void changeSalary(boolean status) {
        if (List.isEmpty()) {
            System.out.println("List empty."); //Return to menu if there is no worker in worker array list
            return;
        }
        System.out.print("Enter code: ");
        String id = check.checkString();
        Worker worker = getWorkerByCode(id);      // Get information of worker with input id
        if (worker == null) {
            System.out.println("Not exist worker.");  //worker = null mean there no worker found with that id, return to menu
        } else {
            int update;
            if (status == true) {
                System.out.print("Enter salary: ");
                while (true) {   //loop until user input salary update > salary current
                    update = check.checkInt();
                    if (update <= worker.getSalary()) {
                        System.out.println("Must be greater than current salary.");
                        System.out.print("Enter again: ");
                    } else {
                        break;
                    }
                }
                st.add(new Status(worker.getID(), worker.getName(), worker.getAge(), update, worker.getWorkPlace(), "UP", getCurrentDate())); //add that salary status to status array list
            } else {
                System.out.print("Enter salary: ");
                while (true) {   //loop until user input salary update < salary current
                    update = check.checkInt();
                    if (update >= worker.getSalary()) {
                        System.out.println("Must be smaller than current salary.");
                        System.out.print("Enter again: ");
                    } else {
                        break;
                    }
                }
                st.add(new Status(worker.getID(), worker.getName(), worker.getAge(), update, worker.getWorkPlace(), "DOWN", getCurrentDate()));  //add that salary status to status array list
            }
            worker.setSalary(update); //set new salary to that worker
            System.out.println("Update success");
        }
    }

    //allow user print history
    /**
     *
     */
    public void printListStatus() {
        if (st.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        System.out.printf("%-5s%-15s%-5s%-10s%-15s%-10s%-20s\n", "Code", "Name", "Age", "Salary", "Workplace", "Status", "Date");
        Collections.sort(st);
        //print history from first to last list
        for (Status item : st) {
            System.out.printf("%-5s%-15s%-5d%-10d%-15s%-10s%-20s\n", item.getID(), item.getName(), item.getAge(), item.getSalary(), item.getWorkPlace(), item.getStatus(), item.getDate());
        }
    }

    /**
     * Method to get worker by ID enter
     *
     * @return
     */
    public Worker getWorkerByCode(String id) {
        for (Worker worker : List) {
            if (id.equalsIgnoreCase(worker.getID())) {
                return worker;
            }
        }
        return null;
    }

    /**
     * Method to get current day (day that change salary status)
     *
     * @return
     */
    public String getCurrentDate() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");   //Initiate day format
        Calendar cd = Calendar.getInstance();                 // get current day
        return df.format(cd.getTime());      // return that day with format
    }
}

/**
 *
 * @author Do Huynh Anh Vu - CE171446
 */
class Execute {

    /*
    * Main method to execute program
     */
    public static void main(String[] args) {

        Main main = new Main();
        while (true) {         //loop until user want to exit
            int choice = main.menu();
            switch (choice) {
                case 1:
                    System.out.println("===== ADD WORKER =====");
                    main.addWorker();
                    break;
                case 2:
                    System.out.println("===== UP SALARY =====");
                    main.changeSalary(true);                                  // Switch to user option and call methed to execute
                    break;
                case 3:
                    System.out.println("===== DOWN SALARY =====");
                    main.changeSalary(false);
                    break;
                case 4:
                    System.out.println("==== DISPLAY SALARY INFORMATION ====");
                    main.printListStatus();
                    break;
                case 5:
                    return;
            }
        }
    }
}
