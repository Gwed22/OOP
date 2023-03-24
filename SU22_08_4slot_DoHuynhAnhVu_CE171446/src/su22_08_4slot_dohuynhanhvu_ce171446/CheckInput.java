package su22_08_4slot_dohuynhanhvu_ce171446;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Do Huynh Anh Vu - CE171446
 */
public class CheckInput {

    Scanner cin = new Scanner(System.in);

    /**
     * Method check the input valid or not (in range min -> max)
     * @param min
     * @param max
     * @return option enter (integer)
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
                System.err.println("Please input number in rage [" + min + ", " + max + "]"); //If wrong, show message and re-input
                System.out.print("Enter again: ");
            }
        }
    }

    /**
     * Method check input String is valid or not (not empty)
     * @return valid String 
     */
    public String checkString() {
        //loop until user input correct
        while (true) {
            String input = cin.nextLine().trim();
            if (input.isEmpty()) {
                System.err.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return input;
            }
        }
    }

    /**
     * Method check if the input ID existed in array or not
     * @param Input array
     * @param ID that want to check
     * @return
     */
    public boolean IdExist(ArrayList<Worker> wk, String ID) {
        //check from first to last list id worker exist or not
        for (Worker item : wk) {
            if (ID.equalsIgnoreCase(item.getID())) {       // If find any match (Ignore case) return true
                return true;
            }
        }
        return false;
    }

    /**
     * Method check input integer valid or not (>0)
     * @return valid int has been check
     */
    public int checkInt() {
        //loop until user input correct
        while (true) {
            try {
                int input = Integer.parseInt(cin.nextLine().trim());
                if (input < 0) {
                    throw new NumberFormatException();     //If int < 0 -> thrown Exception
                }
                return input;
            } catch (NumberFormatException e) {
                System.err.println("Salary must be greater than 0");     //If wrong show message and re-input
                System.out.print("Enter again: ");
            }
        }
    }

    //check worker duplicate

    /**
     * Method check if there is existed worker in array (same information, except ID)
     * @return boolean if worker existed or not
     */
    public boolean checkWorkerExist(ArrayList<Worker> wk, String name, int age, int salary, String workLocation) {
        //check from first to last list worker  worker exist or not
        for (Worker item : wk) {
            if (name.equalsIgnoreCase(item.getName()) && age == item.getAge() && salary == item.getSalary()) {
                return false;
            }
        }
        return true;
    }

}
