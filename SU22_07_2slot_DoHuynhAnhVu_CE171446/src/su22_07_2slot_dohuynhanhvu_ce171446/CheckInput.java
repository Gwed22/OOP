package su22_07_2slot_dohuynhanhvu_ce171446;

import java.util.*;
import java.io.*;

/**
 * @author Do Huynh Anh Vu CE171446
 */
public class CheckInput {

    //=========== THUOC TINH =============
    protected File ExecuteF;

    //=========== KHOI TAO ===============
    /**
     * Khoi tao ham khong co tham so
     */
    public CheckInput() {
    }

    /**
     * @param Khoi tao ham co tham so
     */
    public CheckInput(File ExecuteF) {
        this.ExecuteF = ExecuteF;
    }
    //============ GET & SET ===============

    /**
     * @return File dang duoc thuc thi
     */
    public File getExecuteF() {
        return ExecuteF;
    }

    /**
     * @param set File dang duoc thuc thi
     */
    public void setExecuteF(File ExecuteF) {
        this.ExecuteF = ExecuteF;
    }
    
    //============ CHECK INPUT ==============
    Scanner cin = new Scanner(System.in);

    /**
     * @param min
     * @param max
     * Ham kiem tra cac option user nhap o menu co hop le hay khong
     * @return Lua chon hop le da duoc chon
     */
    public int checkChoice(int min, int max) {
        while (true) { // Thoat vong lap khi lua chon hop le
            try {
                int choice = Integer.parseInt(cin.nextLine().trim());      // Nhap du lieu
                if (choice < min || choice > max) {                        // Nhap cac lua chon ngoai menu thi thong bao exception
                    throw new NumberFormatException();

                }
                return choice;
            } catch (NumberFormatException e) {
                System.err.println("Please choose number from [" + min + " -> " + max + "]");     // Thong bao exception
                System.out.print("Enter again: ");       // Cho nguoi dung nhap lai khi sai
            }
        }
    }

    /**
     * Ham kiem tra input dang String co hop le hay khong
     * @return Chuoi da kiem tra
     */
    public String checkInput() {
        while (true) { // thoat vong lap khi input chuoi hop le
            String input = cin.nextLine().trim();        // Nhap du lieu
            if (input.isEmpty()) {                       // Xet chuoi empty hay khong
                System.err.println("Input can not be empty!");        // Thong bao loi chua hop le
                System.out.print("Enter again: "); 
            } else {
                return input;
            }
        }
    }

    /**
     * Ham kiem tra xem file co ton tai hay khong
     * @return gia tri boolean true/false
     */
    public boolean FileExist() {
        File file = new File("F:/user.dat");        // Khoi tao bien dang File trong duong dan co san de kiem tra
        setExecuteF(file);                         // Gan gia tri bien file cho obj
        if (file.exists() == false) {     // Kiem tra file co ton tai hay khong
            System.err.println("File not exist!!!");        // Khong ton tai thi thong bao khong tim thay vao tao file moi voi ten trong duong dan co san
            System.err.println("File created");
            return false;
        }
        return true;
    }

    /**
     * Ham kiem tra username nhap vao co hop le hay khong
     * @return username da kiem tra
     */
    public String checkUsername() {
        System.out.print("Enter username: ");
        while (true) {  // Lap toi khi du lieu dau vao hop le
            String username = checkInput();    // Nhap du lieu
            if (username.matches("^\\S{5}\\S*$")) {      //Kiem tra chuoi nhap co dung dinh dang hay khong (> 5 ky tu va khong co khoang trang)
                return username;
            }
            System.err.println("You must enter least at 5 character, and no space!"); // Thong bao dieu kien nhap dung khi nguoi dung nhao sai
            System.out.print("Enter again: "); // Cho nhap lai
        }
    }

    /**
     * Ham kiem tra password nhap vao co hop le hay khong
     * @return password da kiem tra
     */
    public String checkPassword() {
        System.out.print("Enter password: ");
        while (true) {   // Lap toi khi du lieu dau vao hop le
            String password = checkInput();   // Nhap du lieu
            if (password.matches("^\\S{6}\\S*$")) {   //Kiem tra chuoi nhap co dung dinh dang hay khong (> 6 ky tu va khong co khoang trang)
                return password;
            }
            System.err.println("You must enter least at 6 character, and no space!");   // Thong bao dieu kien nhap dung khi nguoi dung nhao sai
            System.out.print("Enter again: ");
        }
    }
   
    /**
     * Ham kiem tra username moi nhap va co trung voi username da luu hay khong
     * @param username
     * @return true khi khong ton tai/false khi ton tai
     */
    public boolean UsernameExist(String username) {
        try {
            FileReader fr = new FileReader(getExecuteF()); //Khoi tao bien dang file reader de doc file
            BufferedReader br = new BufferedReader(fr);    // Tao bo dem de doc file
            String line;
            while ((line = br.readLine()) != null) {  // Thoat vong lap khi khong con gia tri de doc
                String[] account = line.split(",");   //Chia cac dong bang dau ","
                if (username.equals(account[0])) {    //account[0] chua username duoc doc tu file
                    return false;
                }
            }
            br.close();
            fr.close();
            return true;
        } catch (FileNotFoundException e) {
            System.err.println("Save into file just created!");        // Khong tim thay file thi thong bao loi
        } catch (IOException e) {
            System.err.println("IO Exception!!!");
        }
        return true;
    }
}
