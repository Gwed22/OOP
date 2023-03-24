package su22_2slot_15_dohuynhanhvu_ce171446;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Do Huynh Anh Vu CE171446
 */
public class Main {
    
    Scanner cin = new Scanner(System.in);       // Khoi tao scanner nhap lieu
    Sort as = new Sort();                       // Khoi tao obj moi de xu li

    //check user input a number integer
    /**
     *
     * @return
     */
    public int checkInt() {
        while (true) {         // Khi nao nhap dung se thoat vong lap
            try {
                int input = Integer.parseInt(cin.nextLine().trim());     // Cho nguoi dung nhap so                                       // Gan gia tri Size cho obj
                if (input <= 0) {
                    System.err.println("You must enter a positive integer!"); // Kiem tra gia tri nho hon khong
                }
                return input;
            } catch (NumberFormatException e) {
                System.err.println("You must enter a positive integer!");
                System.out.println("==================================");    // Thong bao khi nhap sai va cho nhap lai
                System.out.println("Enter number of array: ");
            }
        }
    }
//allow user input number of array

    /**
     *
     * @return
     */
    public int inputSize() {
        System.out.println("Enter number of array: ");
        int n = checkInt();
        return n;
    }
    //allow user input value of array

    /**
     * @return mang da khoi tao gia tri random
     */
    public int[] inputValue(int n) {
        Random ran = new Random();
        int[] Sort = new int[n];
        for (int i = 0; i < n; i++) {        // Gan gia tri random cho mang
            Sort[i] = ran.nextInt(n);
        }
        return Sort;
    }

    /**
     * Main de chay chuong trinh
     *
     * @param args
     */
    public static void main(String[] args) {
        Main mn = new Main();
        Sort as = new Sort();
        
        int n = mn.inputSize();
        if (n <= 0) {               //Kiem tra mang co gia tri de chay hay khong
            System.err.println("No value for sorting!");
        } else {
            as.setSort(mn.inputValue(n));    // Gan gia tri cho mang
            as.InsertionSort();                  // Goi ham sort theo thuat toan insertion
            as.display();                        // Goi ham in ra man hinh mang da sort
        }
    }
}
