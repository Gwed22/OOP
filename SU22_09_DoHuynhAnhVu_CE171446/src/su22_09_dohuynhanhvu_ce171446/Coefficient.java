package su22_09_dohuynhanhvu_ce171446;

import java.util.*;

/**
 *
 * @author Do Huynh Anh Vu - CE171446
 */
public class Coefficient {

    //======= THUOC TINH =========
    protected ArrayList<Double> result;

    //======= KHOI TAO ==========
    public Coefficient() {
    }

    public Coefficient(ArrayList result) {
        this.result = result;
    }

    //========= GET & SET ========
    /**
     * get Result array
     *
     * @return array
     */
    public ArrayList getResult() {
        return result;
    }

    /**
     * set new result array
     *
     * @param result
     */
    public void setResult(ArrayList result) {
        this.result = result;
    }

    /**
     * Method to check if number is odd or not, display
     */
    public void CheckOdd() {
        ArrayList<Double> arr = new ArrayList<>();  // Initialize new array to not affect the data of main array
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i) % 2 != 0) {          // If number is valid add to the new array
                arr.add(result.get(i));
            }
        }
        display(arr);      //Show to the monitor
    }

    /**
     * Method to check if number is even or not, display
     */
    public void CheckEven() {
        ArrayList<Double> arr = new ArrayList<>(); // Initialize new array to not affect the data of main array
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i) % 2 == 0) {              // If number is valid add to the new array
                arr.add(result.get(i));
            }
        }
        display(arr);   //Show to the monitor
    }

    /**
     * Method to check if number is perfect square or not, display
     */
    public void CheckSquare() {
        ArrayList<Double> arr = new ArrayList<>(); // Initialize new array to not affect the data of main array
        for (int i = 0; i < result.size(); i++) {
            int j = 0;
            while (j <= result.get(i)) {
                if (Math.pow(j, 2) == result.get(i)) {
                    arr.add(result.get(i));                // If number is valid add to the new array
                    break;
                }
                j++;
            }
        }
        display(arr);   //Show to the monitor
    }

    /**
     * Method to show input array to monitor
     * @param input
     */
    public void display(ArrayList<Double> input) {
        int n = input.size();
        for (int i = 0; i < n - 1; i++) {
            System.out.print(input.get(i) + ", "); // Have ", " between elements
        }
        System.out.println(input.get(n - 1));     // Last element does not have ","
    }
}
