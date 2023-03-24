package bubblesort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Do Huynh Anh Vu CE171446
 */
public class SortMethod {

    boolean valid = false;
    Scanner cin = new Scanner(System.in);               // Khoi tao scanner nhap du lieu
    ArrayList<BubbleSort> bs = new ArrayList<>();       // Khoi tao arraylist de luu phan tu nhap vao

    public Integer CheckIn() {
        int count = 0;
        try {
            do {              // du lieu nhap valid thi thoat vong lap (valid = true)
                System.out.print("Input Array Length : ");
                int input = Integer.parseInt(cin.nextLine());       // Nhap do dai cua array             
                if (input < 0) {
                    System.err.println("Please enter an positive integer!"); //Thong bao khi nhap sai (input < 0)
                } else {
                    for (int i = 0; i < input; i++) {          // Lap lai khi nhap het cac gia tri cua phan tu
                        try {
                            do {
                                System.out.print("Enter Element " + ++count + ": ");
                                int element = Integer.parseInt(cin.nextLine());     // Nhap gia tri cho phan tu
                                bs.add(new BubbleSort(element));       // Luu gia tri cua phan tu vao arraylist
                                bs.get(i).setValue(element);            // dat gia tri cho phan tu cua obj
                            } while (valid = false);

                        } catch (NumberFormatException e) {           // Bat loi du lieu dang so
                            System.err.println("You must enter an integer!"); //Thong bao
                        }
                        valid = true;         // tra lai gia tri true de thoat vong lap khi da thoa man dieu kien input
                    }
                }
                return input;
            } while (valid = false);

        } catch (NumberFormatException e) {           // Bat loi du lieu dang so
            System.err.println("You must enter an integer!"); // Thong bao
        }
        return null;
    }

    int[] sortAscending() {
        int i = 0;
        int[] Sort = new int[bs.size()];            // Khoi tao mang voi so phan tu la do dai cua arraylist
        for (i = 0; i < bs.size(); i++) {
            Sort[i] = bs.get(i).getValue();         // gan gia tri cua phan tu trong arraylist vao mang
        }
        for (i = 0; i < bs.size(); i++) {            // bien dem i bat dau tu phan tu thu nhat den het mang
            for (int j = 1; j < bs.size(); j++) {    // bien dem j bat dau tu phan tu thu hai den het mang
                if (Sort[j - 1] > Sort[j]) {         // neu phan tu dung truoc j lon hon j, doi vi tri 2 phan tu
                    int temp = Sort[j - 1];
                    Sort[j - 1] = Sort[j];
                    Sort[j] = temp;
                }
            }
        }
        return Sort;
    }

    int[] sortDescending() {
        int i = 0;
        int[] Sort = new int[bs.size()];           // Khoi tao mang voi so phan tu la do dai cua arraylist
        for (i = 0; i < bs.size(); i++) {
            Sort[i] = bs.get(i).getValue();          // gan gia tri cua phan tu trong arraylist vao mang
        }
        for (i = 0; i < bs.size(); i++) {                     // bien dem i bat dau tu phan tu thu nhat
            for (int j = 0; j < bs.size() - i - 1; j++) {     // bien dem j bat dau tu phan tu thu nhat den vi tri (do dai mang - i -1) (-1 do j so sanh voi phan tu dung sau nen neu khong -1 se bi exception)
                if (Sort[j] < Sort[j + 1]) {                  // neu phan tu dung sau j lon hon j, doi vi tri 2 phan tu
                    int temp = Sort[j];
                    Sort[j] = Sort[j + 1];
                    Sort[j + 1] = temp;
                }
            }
        }
        return Sort;
    }
}
