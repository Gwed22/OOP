package customermanage;

import java.util.Scanner;

/**
 *
 * @author Do Huynh Anh Vu - CE171446
 */
public class Main {

    public static void main(String[] args) throws Exception {
        int choice;   // tao bien lua chon de nguoi dung nhap 
        boolean valid = false;
        Manage ma = new Manage();
        try {
            //Hien thi menu
            do {      //Hien thi lai menu khi thoat chuong trinh, thoat phan mem khi bi exception hoac chon Exit
                Scanner cin = new Scanner(System.in);
                System.out.print(" ========== Format CSV Program ==========\n"
                        + "1. Import CSV.\n"
                        + "2. Format Address.\n"
                        + "3. Format Name.\n" // menu hien thi de nguoi dung chon chuc nang
                        + "4. Export CSV.\n"
                        + "5. Exit.\n"
                        + "Please choose one option: ");

                choice = Integer.parseInt(cin.nextLine());     // Nhap chuc nang
                if (choice != 1 && valid == false) {                // Chi thuc hien chuc nang 2,3,4 khi thuc hien chuc nang 1
                    System.out.println("You must import file first (option 1) to execute other function!");
                } else {
                    switch (choice) {
                        case 1:
                            System.out.println("---------- Import CSV ----------");
                            ma.importCSV();
                            valid = true;
                            break;
                        case 2:
                            System.out.println("---------- Format Address ----------");
                            ma.formatAddress();
                            break;
                        case 3:                                                               // "break" thoat chuong trinh ve menu
                            System.out.println("---------- Format Name ----------");          // "ma. ....." goi ham xu li chuong trinh
                            ma.formatName();
                            break;
                        case 4:
                            System.out.println("-------- Export CSV --------");
                            ma.exportCSV();
                            break;
                        case 5:
                            System.out.println("Thanks for using my software !!! Good Bye");  // thoat phan mem
                            break;
                    }
                }
            } while (choice != 5);
        } catch (NumberFormatException e) {
            System.out.println("Please choose an option above");                              // Khi bi loi thi xuat thong bao exception
        }
    }
}
