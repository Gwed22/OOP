package bubblesort;

import java.util.Scanner;

/**
 * @author Do Huynh Anh Vu CE171446
 */
public class BubbleSort {
    //============== THUOC TINH =================

    private int[] Sort;
    private int length;
    //=============== KHOI TAO ===================

    /**
     *
     * @param Sort
     */
    public BubbleSort(int[] Sort) {
        this.Sort = Sort;
        this.length = length;
    }

    BubbleSort() {
    }
    //=============== GET & SET & toString ===========

    /**
     *
     * @return get array
     */
    public int[] getSort() {
        return Sort;
    }

    /**
     *
     * @param set array
     */
    public void setSort(int[] Sort) {
        this.Sort = Sort;
    }

    /**
     *
     * @return get length of array
     */
    public int getLength() {
        return length;
    }

    /**
     *
     * @param set length of array
     */
    public void setLength(int length) {
        this.length = length;
    }
    Scanner cin = new Scanner(System.in);               // Khoi tao scanner nhap du lieu 

    /**
     * @param kiem tra input hop le hay khong roi cho nhap gia tri phan tu cua
     * mang
     * @return null khi nhap du lieu sai hoac khong nhap du lieu
     * @return input (do dai cua mang)
     */
    public Integer CheckIn(int input) {
        int count = 0;
        boolean valid = false;          // tao bien boolean check input
        input = getLength();            // lay do dai cua mang
        int[] array = new int[input];   // khoi tao mang de luu gia tri voi do dai da nhap
        try {
            do {              // du lieu nhap valid thi thoat vong lap (valid = true)       
                if (input <= 0) {
                    System.err.println("Please enter an positive integer!"); //Thong bao khi nhap sai (input < 0)
                } else {
                    for (int i = 0; i < input; i++) {          // Lap lai khi nhap het cac gia tri cua phan tu
                        try {
                            System.out.print("Enter Element " + ++count + ": ");
                            int element = Integer.parseInt(cin.nextLine());     // Nhap gia tri cho phan tu
                            array[i] = element;

                        } catch (NumberFormatException e) {           // Bat loi du lieu dang so
                            System.err.println("You must enter an integer!"); //Thong bao
                            break;
                        }
                        valid = true;         // tra lai gia tri true de thoat vong lap khi da thoa man dieu kien input
                    }
                    setSort(array);
                }
                return input;
            } while (valid = false);

        } catch (NumberFormatException e) {           // Bat loi du lieu dang so
            System.err.println("You must enter an integer!"); // Thong bao
        }
        return null;
    }

    /**
     * sap xep mang theo gia tri tang dan
     */
    int[] sortAscending() {
        for (int i = 0; i < getLength(); i++) {            // bien dem i bat dau tu phan tu thu nhat den het mang
            for (int j = 1; j < getLength(); j++) {    // bien dem j bat dau tu phan tu thu hai den het mang
                if (Sort[j - 1] > Sort[j]) {         // neu phan tu dung truoc j lon hon j, doi vi tri 2 phan tu
                    int temp = Sort[j - 1];
                    Sort[j - 1] = Sort[j];
                    Sort[j] = temp;
                }
            }
        }
        return Sort;
    }

    /**
     * sap xep mang theo gia tri giam dan
     */
    int[] sortDescending() {

        for (int i = 0; i < getLength(); i++) {                     // bien dem i bat dau tu phan tu thu nhat
            for (int j = 0; j < getLength() - i - 1; j++) {     // bien dem j bat dau tu phan tu thu nhat den vi tri (do dai mang - i -1) (-1 do j so sanh voi phan tu dung sau nen neu khong -1 se bi exception)
                if (Sort[j] < Sort[j + 1]) {                  // neu phan tu dung sau j lon hon j, doi vi tri 2 phan tu
                    int temp = Sort[j];
                    Sort[j] = Sort[j + 1];
                    Sort[j + 1] = temp;
                }
            }
        }
        return Sort;
    }

    /**
     * @param Dinh dang xuat du lieu mang theo yeu cau
     */
    public static String toString(int[] a) {
        if (a == null) {
            return "null";
        }
        int iMax = a.length - 1;
        if (iMax == -1) {
            return "[]";
        }

        StringBuilder b = new StringBuilder();
        for (int i = 0;; i++) {
            b.append('[');
            b.append(a[i]);
            b.append(']');
            if (i == iMax) {
                return b.append("").toString();
            }
            b.append(" -> ");
        }
    }

    /**
     * Ham de nhap du lieu (do dai cua mang) va dan gia tri thuoc tinh cua obj
     */
    public void input() {
        System.out.print("Input Array Length : ");
        int input = Integer.parseInt(cin.nextLine());       // Nhap do dai cua array 
        setLength(input);
    }

    /**
     * menu de hien thi menu cho nguoi dung, thuc hien chuc nang theo tuy chon nguoi dung va goi ham de xu li 
     */
    public void menu() {
        int choice = 0;
        boolean valid = false;
        do { //Hien thi lai menu khi thoat chuong trinh, thoat vong lap khi chon Exit (choice = 4)
            try {
                //Hien thi menu

                Scanner cin = new Scanner(System.in);
                System.out.print(" ========== Bubble Sort program ==========\n"
                        + "1. Input Element.\n"
                        + "2. Sort Ascending.\n"
                        + "3. Sort Descending.\n" // menu hien thi de nguoi dung chon chuc nang
                        + "4. Exit.\n"
                        + "Please choose one option: ");
                choice = Integer.parseInt(cin.nextLine());     // Nhap chuc nang
                if (choice > 1 && valid == false && choice < 4) {                // Chi thuc hien chuc nang 2,3 khi thuc hien chuc nang 1
                    System.err.println("You must input array first (option 1) to execute other function!");
                } else if (choice < 1) {
                    System.err.println("Please choose from 1 -> 4");
                } else {
                    switch (choice) {
                        case 1:
                            System.out.println("---------- Input Element ----------");
                            input();
                            if (CheckIn(getLength()) == null) {          // Co du lieu array moi cho xu li chuc nang 2,3
                                valid = false;
                            } else {
                                valid = true;
                            }
                            break;
                        case 2:
                            System.out.println("---------- Sort Ascending ----------");
                            System.out.println(toString(sortAscending()));        // Goi ham xu li va hien thi array da sort
                            break;
                        case 3:                                                                  // "break" thoat chuong trinh ve menu
                            System.out.println("---------- Sort Descending ----------");
                            System.out.println(toString(sortDescending()));
                            break;
                        case 4:
                            System.out.println("Thanks for using my software !!! Good Bye");  // thoat phan mem
                            break;
                    }
                }
            } catch (NumberFormatException e) {
                System.err.println("Please choose an option above!");                              // Khi bi loi thi xuat thong bao exception
            }
        } while (choice != 4);
    }
}
