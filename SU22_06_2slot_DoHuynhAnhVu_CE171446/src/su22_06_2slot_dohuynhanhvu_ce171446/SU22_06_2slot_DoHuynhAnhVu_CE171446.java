package su22_06_2slot_dohuynhanhvu_ce171446;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Do Huynh Anh Vu CE171446
 */
public class SU22_06_2slot_DoHuynhAnhVu_CE171446 {

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
                int input = Integer.parseInt(cin.nextLine().trim());     // Cho nguoi dung nhap so
                as.setSize(input);                                        // Gan gia tri Size cho obj
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
            Sort[i] = ran.nextInt(20);
            as.setSort(Sort);        // Luu lai mang
        }
        return Sort;
    }

    /**
     * In ra mang da Sort theo format
     */
    public void display() {
        System.out.print("Sorted array: ");
        System.out.print("{");
        for (int i = 0; i < as.getSort().length - 1; i++) { //In tung phan tu cua mang
            System.out.print(as.getSort()[i] + ", ");
        }
        System.out.print(as.getSort()[as.getSize() - 1]);
        System.out.print("}\n");
    }

    /**
     * Main de chay chuong trinh
     *
     * @param args
     */
    public static void main(String[] args) {
        SU22_06_2slot_DoHuynhAnhVu_CE171446 su = new SU22_06_2slot_DoHuynhAnhVu_CE171446();
        Sort as = new Sort();
        int n = su.inputSize();
        if (n <= 0) {               //Kiem tra mang co gia tri de chay hay khong
            System.err.println("No value for sorting!");
        } else {
            int[] a = su.inputValue(n);          //Dan gia tri cho phan tu mang
            as.SelectionSort(a);                  // Goi ham sort theo thuat toan selection
            su.display();                        // Goi ham in ra man hinh mang da sort
        }
    }
}
