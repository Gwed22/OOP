package su22_09_dohuynhanhvu_ce171446;

import java.text.DecimalFormat;
import java.util.*;

/**
 *
 * @author Do Huynh Anh Vu - CE171446
 */
public class Manage {

    Scanner cin = new Scanner(System.in);
    Coefficient Equation = new Coefficient();

    /**
     * Menu for user to choose the option
     *
     * @return the choice
     */
    public int menu() {
        System.out.println("======= EQUATION PROGRAM =======");
        System.out.println("1. Calculate Superlative Equation.");
        System.out.println("2. Calculate Quadratic Equation.");               //Show menu to monitor
        System.out.println("3. Exit.");
        System.out.print("Enter your choice: ");
        int choice = checkChoice(1, 3);   //Check if input option is valid
        return choice;
    }

    /**
     * Method check the input valid or not (in range min -> max)
     *
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
                System.err.println("Please input number in range [" + min + ", " + max + "]"); //If wrong, show message and re-input
                System.out.print("Enter again: ");
            }
        }
    }

    /**
     * Check if input is valid (double)
     *
     * @return input has been check
     */
    public double checkNum() {

        while (true) {  //loop until user input correct
            try {
                double input = Double.parseDouble(cin.nextLine().trim());
                return input;
            } catch (NumberFormatException e) {
                System.err.println("You must enter a number");     //If wrong show message and re-input
                System.out.print("Enter again: ");
            }
        }
    }

    /**
     * Method that take input (coefficient of equation) then solving the
     * equation, then showing which coefficient is odd, even, of perfect square
     * / Linear Equation
     */
    public void Linear() {

        System.out.println("===== CALCULATE SUPERLATIVE EQUATION =====");
        ArrayList<Double> arr = new ArrayList<>();     // Initialize arraylist for storing coefficient

        System.out.print("Enter A: ");
        double a = checkNum();
        arr.add(a);                           // Enter coefficient, check valid of input then add to arraylist
        System.out.print("Enter B: ");
        double b = checkNum();
        arr.add(b);
        if (a == 0) {
            if (b == 0) {      // Infinite solution case
                System.out.println("Equation has infinite solutions");           // Solving linear equation
            } else {           // No solution case                                     
                System.out.println("Equation has no solution");
            }
        } else {               // Normal case
            double result = -b / a;
            arr.add(result);                   //Add result to arraylist then show result to monitor
            System.out.printf("Solution: x = %.3f \n", result);
        }
        Equation.setResult(arr);
        System.out.print("Number is Odd: ");
        Equation.CheckOdd();
        System.out.print("Number is Even: ");              // Show all which coefficient, result is even, odd or perfect square
        Equation.CheckEven();
        System.out.print("Number is Perfect Square: ");
        Equation.CheckSquare();
    }

    /**
     * Method that take input (coefficient of equation) then solving the
     * equation, then showing which coefficient is odd, even, of perfect square
     * / Quadratic Equation
     */
    public void Quadratic() {
        
        System.out.println("===== CALCULATE QUADRATIC EQUATION =====");
        ArrayList<Double> arr = new ArrayList<>();   // Initialize arraylist for storing coefficient

        System.out.print("Enter A: ");
        double a = checkNum();
        arr.add(a);
        System.out.print("Enter B: ");           // Enter coefficient, check valid of input then add to arraylist
        double b = checkNum(); 
        arr.add(b);
        System.out.print("Enter C: ");
        double c = checkNum();
        arr.add(c);
        double delta = b * b - 4 * a * c;
        if (delta < 0) { // No solution case
            System.out.println("Equation has no solution");
        } else if (delta == 0) {  // One solution case
            double x = (-b - Math.sqrt(delta)) / (2 * a);
            System.out.printf("Solution: x = %.3f \n", x);
            arr.add(x);                                            // Solving Quadratic Equation, add result to arraylist if exist, then show result to monitor
        } else {      // Two solution case (normal case)
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            arr.add(x1);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            arr.add(x2);
            System.out.printf("Solution: x1 = %.3f and x2 = %.3f", x1, x2);
        }
        Equation.setResult(arr);
        System.out.print("Number is Odd: ");
        Equation.CheckOdd();
        System.out.print("Number is Even: ");                // Show all  which coefficient, result is even, odd or perfect square
        Equation.CheckEven();
        System.out.print("Number is Perfect Square: ");
        Equation.CheckSquare();
    }
}

/*
* @author Do Huynh Anh Vu   -    CE171446
 */
class Main {

    /*
    * Main method for program to run
     */
    public static void main(String[] args) {

        Manage mn = new Manage();
        while (true) {         //loop until user want to exit
            int choice = mn.menu();
            switch (choice) {
                case 1:
                    mn.Linear();
                    break;                 // Call Method to process
                case 2:
                    mn.Quadratic();
                    break;
                case 3:
                    return;
            }
        }
    }
}
