package su22_07_2slot_dohuynhanhvu_ce171446;

import java.io.*;

/**
 * @author Do Huynh Anh Vu CE171446
 */
public class Input {

    CheckInput ci = new CheckInput();
    //display menu

    /**
     * Ham in menu ra man hinh va nhap option
     *
     * @return option da chon
     */
    public int menu() {
        System.out.println("===== USER MANAGEMENT SYSTEM =====");
        System.out.println("1. Create a new account.");                // In menu
        System.out.println("2. Login system.");
        System.out.println("3. Exit.");
        System.out.print("Enter your choice: ");
        int choice = ci.checkChoice(1, 3);  // Nhap lua chon kiem tra hop le
        return choice;
    }

    /**
     * Ham tao account moi va luu account
     */
    public void createAccount() throws IOException {
        if (ci.FileExist() == false) {
            ci.getExecuteF().createNewFile(); //File khong ton tai thi tao file moi voi duong dan cho san
        }
        String username = ci.checkUsername(); // Nhap username va kiem tra hop le
        String password = ci.checkPassword(); // Nhap password va kiem tra hop le
        if (!ci.UsernameExist(username)) {      // Kiem tra username co ton tai hay khong
            System.err.println("Username exist");
            return;
        }
        saveAccount(username, password);   // Luu account voi username va password da nhap khi thoa man dieu kien
    }

    /**
     * Ham dang nhap
     */
    public void login() {
        if (ci.FileExist() == false) { // Kiem tra file de doc du lieu co ton tai hay khong
            System.err.println("There no save account to login (file does not exist)!");
        } else {
            String username = ci.checkUsername();
            String password = ci.checkPassword();
            //check username exist or not
            if (!ci.UsernameExist(username)) {      // Kiem tra username co ton tai hay khong
                if (!password.equals(passwordByUsername(username))) { // Kiem tra password nhap giong voi password da luu hay khong
                    System.err.println("Password incorrect!");        // Thong bao khi nhap pass sai
                    return;                                           // tro ve menu
                }
                System.err.println("Login success");       // Dung thi thong bao dang nhap thanh cong
            } else {
                System.err.println("No account found!!!");   // Thong ao khi username nhap khong ton tai 
            }
        }
    }

    /**
     * Luu account da nhap 
     * @param username
     * @param password
     */
    public void saveAccount(String username, String password) {
        try {
            FileWriter fw = new FileWriter(ci.getExecuteF(), true); // Viet tiep tuc vao cuoi file 
            fw.write(username + "," + password + "\n");     //username ngan cach password bang dau ","
            fw.close();
            System.out.println("New account has been created!"); //Thong bao account da luu thanh cong
        } catch (IOException e) {
            System.out.println("IO Exception!!!");
        }
    }

    /**
     * Ham lay password theo username da nhap
     * @param username
     * @return password da luu cua username duoc nhap
     */
    public String passwordByUsername(String username) {
        try {
            FileReader fr = new FileReader(ci.getExecuteF());
            BufferedReader bufferedReader = new BufferedReader(fr);         //Tao bo dem doc file
            String line;
            while ((line = bufferedReader.readLine()) != null) {  //Thoat vong lap khi het gia tri de doc
                String[] account = line.split(",");                // Chia username va password
                if (username.equals(account[0])) {                 // Khi ma username luu trung voi username nhap vao thi tra lai password 
                    return account[1];
                }
            }
            bufferedReader.close();   // Dong bo dem
            fr.close();                     
        } catch (IOException e) {
            System.err.println("IO Exception!!!");
        }
        return null;         // Khong tim thay thi tra lai gia tri null
    }

    /**
     * Ham thuc thi chuong trinh
     * @param args
     */
    public static void main(String[] args) throws IOException {
        Input in = new Input();  // Khoi tao obj moi
        //loop until user want to exit
        while (true) {
            int choice = in.menu();  //In menu va cho nhap option
            switch (choice) {
                case 1:
                    in.createAccount();  // Ham tao account
                    break;
                case 2:
                    in.login(); // Ham dang nhap
                    break;
                case 3:
                    System.out.println("Thanh you for using my software!!!");
                    return;   // Ham thoat chuong trinh
            }
        }
    }
}
