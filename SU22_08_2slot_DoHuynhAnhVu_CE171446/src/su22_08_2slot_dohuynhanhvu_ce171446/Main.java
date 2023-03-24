package su22_08_2slot_dohuynhanhvu_ce171446;

import java.util.*;

/**
 * @author Do Huynh Anh Vu - CE171446
 */
class SU22_08_2slot_DoHuynhAnhVu_CE171446 {

    Scanner cin = new Scanner(System.in);

    /**
     * Ham kiem tra gia tri Integer dau vao (khong phai chu va > 0)
     *
     * @return gia tri int da kiem tra
     */
    public int checkInt() {
        while (true) { // thoat vong lap khi input hop le
            try {
                int input = Integer.parseInt(cin.nextLine());        // Nhap du lieu
                if (input < 1) {                       // Xet chuoi empty hay khong
                    System.err.println("Input can not be lower than 1 !");        // Thong bao loi chua hop le
                    System.out.print("Enter again: ");
                } else {
                    return input;
                }
            } catch (NumberFormatException e) {
                System.err.println("Please enter a positive number!!");  //Nhap sai thi thong bao loi va cho nhap lai
                System.out.print("Enter again: ");
            }
        }
    }

    /*
    * Ham kiem traa gia tri input dang int (khong phai chu)
    * @return gia tri int da kiem tra
     */
    public int checkInput() {
        while (true) { // thoat vong lap khi input hop le
            try {
                int input = Integer.parseInt(cin.nextLine());        // Nhap du lieu
                return input;
            } catch (NumberFormatException e) {
                System.err.println("Please enter a number!!");      //Nhap sai thi thong bao loi va cho nhap lai
                System.out.print("Enter again: ");
            }
        }
    }
}

/**
 * @author Do Huynh Anh Vu - CE171446
 */
public class Main {

    /**
     * Ham main xu li chay chuog trinh
     */
    public static void main(String[] args) {

        SU22_08_2slot_DoHuynhAnhVu_CE171446 input = new SU22_08_2slot_DoHuynhAnhVu_CE171446();
        Array arr = new Array();  // Khoi tao obj de luu mang

        System.out.println("Enter number of array:"); //Nhap do dai mang
        int length = input.checkInt();

        System.out.println("Enter search value:");   // Nhap gia tri can tim
        int search = input.checkInput();

        arr.inputValue(length);
        arr.SelectionSort();  //Sap xep mang theo selection sort
        System.out.print("Sorted array: ");
        arr.display();   //In mang da sap xep

        int idx = arr.BinarySearch(arr.getArray(), search, 0, length - 1);  //Tim kiem gia tri can tim theo binary search
        if (idx != -1) {
            System.out.println("Found " + search + " at index: " + idx);  //Tim thay thi in vi tri phan tu
        } else {
            System.out.println("Not Found!!!"); // Khong thay thi thong bao
        }
    }
}
