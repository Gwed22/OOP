/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bubblesort;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Do Huynh Anh Vu   CE171446
 */
public class Main {

    public static void main(String[] args) throws Exception {
        int choice;
        boolean valid = false;
        SortMethod sm = new SortMethod();

        try {
            //Hien thi menu
            do {      //Hien thi lai menu khi thoat chuong trinh, thoat phan mem khi bi exception hoac chon Exit
                Scanner cin = new Scanner(System.in);
                System.out.print(" ========== Bubble Sort program ==========\n"
                        + "1. Input Element.\n"
                        + "2. Sort Ascending.\n"
                        + "3. Sort Descending.\n" // menu hien thi de nguoi dung chon chuc nang
                        + "4. Exit.\n"
                        + "Please choose one option: ");
                choice = Integer.parseInt(cin.nextLine());     // Nhap chuc nang
                if (choice != 1 && valid == false && choice != 4) {                // Chi thuc hien chuc nang 2,3 khi thuc hien chuc nang 1
                    System.out.println("You must input array first (option 1) to execute other function!");
                } else {
                    switch (choice) {
                        case 1:
                            System.out.println("---------- Input Element ----------");

                            if (sm.CheckIn() == null) {          // Co du lieu array moi cho xu li chuc nang 2,3
                                valid = false;
                            } else {
                                valid = true;
                            }
                            break;
                        case 2:
                            System.out.println("---------- Sort Ascending ----------");
                            System.out.println(Arrays.toString(sm.sortAscending()));        // Goi ham xu li va hien thi array da sort
                            break;
                        case 3:                                                                  // "break" thoat chuong trinh ve menu
                            System.out.println("---------- Sort Descending ----------");
                            System.out.println(Arrays.toString(sm.sortDescending()));
                            break;
                        case 4:
                            System.out.println("Thanks for using my software !!! Good Bye");  // thoat phan mem
                            break;
                    }
                }
            } while (choice != 4);
        } catch (NumberFormatException e) {
            System.out.println("Please choose an option above");                              // Khi bi loi thi xuat thong bao exception
        }
    }
}
