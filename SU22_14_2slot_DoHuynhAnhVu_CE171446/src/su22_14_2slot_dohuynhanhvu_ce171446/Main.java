package su22_14_2slot_dohuynhanhvu_ce171446;

import java.util.Scanner;

/**
 *
 * @author Do Huynh Anh Vu - CE171446
 */
public class Main {

    /**
     * Main method to execute the program
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Attribute get = new Attribute();  //Allocated memory for execute

        System.out.println("====== Analysis String Program ======");
        System.out.print("Input String: ");
        get.setStr(in.nextLine());    //set string to have string for analysis
        get.Number();      // get numberic analysis from string
        get.Character();    // get character analysis from string
    }
}
