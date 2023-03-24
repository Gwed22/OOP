/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileprocessor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Do Huynh Anh Vu CE171446
 */
public class FileManage {

    /**
     *
     * @param Ham kiem tra xem duong dan cua nguoi dung nhap vao la duong dan
     * thu muc, duong dan tap tin hay la duong dan khong ton tai, du lieu dau
     * vao la duong dan
     * @throws Exception
     */
    public void CheckInputPath() {
        FileClass f = new FileClass();
        Scanner cin = new Scanner(System.in); // Tao scanner nhap du lieu
        try {
            System.out.print("Enter path:");
            String path = cin.nextLine().trim();
            f.setPath(path);
            if (new File(path).isFile()) {                            // kiem tra duong dan co phai la duong dan tep, thong bao 
                System.out.println("Path to file");
            } else if (new File(path).isDirectory()) {                // kiem tra duong dan co phai la duong dan thu muc, thong bao
                System.out.println("Path to directory");
            } else {                                                  // khong phai 2 truong hop tren la duong dan khong ton tai, thong bao
                System.out.println("Path doesn't exist");
            }
        } catch (InputMismatchException e) {           // Bat loi du lieu dang chu
            System.out.println("Path doesn't exist");  // Nhap sai thi thong bao va thoat chuong trinh ve menu
        }
    }

    // List liet ke cac file co duoi java trong duong dan ma nguoi dung nhap vao
    List<String> getAllFileNameJavaInDirectory() throws Exception {
        FileClass f = new FileClass();
        Scanner cin = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        String path;
        System.out.print("Enter path:");
        path = cin.nextLine().trim();
        f.setPath(path);
        if (new File(path).isDirectory()) {       // kiem tra duong dan co phai la thu muc hay khong, roi tiep tuc xu li
            if (new File(path).exists()) {                               // kiem tra duong dan co ton tai hay khong
                File directoryPath = new File(path);
                FilenameFilter javaFilter = new FilenameFilter() {       // tao filter de loc cac file co duoi .java
                    public boolean accept(File dir, String name) {       // ham boolean kiem tra tap tin khi filter
                        String lowercaseName = name.toLowerCase();
                        if (lowercaseName.endsWith(".java")) {           // kiem tra duoi tap tin co .java hay khong
                            return true;
                        } else {
                            return false;
                        }
                    }
                };
                //List of all the text files
                File filesList[] = directoryPath.listFiles(javaFilter);  // liet ra danh sach cac file co duoi .java vao mang file
                List<String> newList = new ArrayList<String>();
                for (File file : filesList) {
                    System.out.println(file.getName());                        // them cac file da loc vao mang
                    list.add(file.getName());
                }  // Dung thi goi ham va xu li xem tep nao co duoi .java trong thu muc
            } else {
                System.out.println("Path doesn't exist");                    // Sai thi thong bao va thoat chuong trinh ve menu
            }
            if (list.size() > 1) {         // Xu li chuc nang xong thi dem co bao nhieu tep co duoi .java
                System.out.println("Result: " + list.size() + " files");
            } else {
                System.out.println("Result: " + list.size() + " file");
            }
        }
        return null;
    }

    /**
     * @param Ham co chuc nang loc ra cac file co size lon hon size nhap vao co
     * trong duong dan ma nguoi dung nhap
     * @param Du lieu dau vao la duong dan va size
     * @throws Exception
     */
    public void display() throws Exception {
        FileClass f = new FileClass();
        Scanner cin = new Scanner(System.in); //Creates a scanner
        String path;
        long size;
        boolean isValid;
        try {
            System.out.print("Enter size(Integer):");
            size = Long.parseLong(cin.nextLine());
            f.setSize(size);
        } catch (NumberFormatException e) {                 // Nhap du lieu va kiemtra du lieu dau vao, sai thoat chuong tring ve menu
            System.out.println("Size must be a digit");
        }
        do {   // Neu duong dan khong hop le se cho nguoi dung nhap lai, dung thi thoat vong lap
            isValid = false;
            try {
                System.out.print("Enter path:");
                path = cin.nextLine().trim();
                f.setPath(path);
                if (new File(path).isDirectory()) {
                    File directoryPath = new File(path);                       // Khoi tao file object moi
                    File filesList[] = directoryPath.listFiles();              // them tat ca file trong duong dan vao list file
                    for (File f1 : filesList) {                                // Cho chay list file
                        Path address = Paths.get(f1.getAbsolutePath());        // tao bien duong dan cho file 
                        if ((Files.size(address) / 1024) >= f.getSize()) {            // neu size file lon hon size nhap vao thi in ten file ra man hinh
                            System.out.println(f1.getName());
                        }
                    }
                    isValid = true;
                } else {                                       // Nhap du lieu va kiem tra du lieu, sai nhap lai
                    System.out.println("Path doesn't exist");
                }
            } catch (InputMismatchException e) {
                System.out.println("Path doesn't exist");
            }
        } while (isValid == false);
    }

    /**
     *
     * @param path
     * @param du lieu dau vao la duong dan va du lieu can nhap vao file
     * @return tra ve trang thai true/false (da viet/chua viet)
     * @throws Exception
     */
    public boolean appendContentToFile() throws Exception {
        FileClass f = new FileClass();
        Scanner cin = new Scanner(System.in);
        boolean isValid = false;
        try {
            System.out.print("Enter input content:");
            String InputContent = cin.nextLine();        // Nhap thuoc tinh vao cho object
            f.setInputContent(InputContent);
        } catch (InputMismatchException e) {             // kiem tra dang du lieu nhap vao dung hay khong
            System.out.println("Input invalid");
        }
        do {          // Nhap du lieu va kiem tra du lieu, sai nhap lai 
            try {
                System.out.print("Enter path:");
                String path = cin.nextLine().trim();
                f.setPath(path);               
                if (new File(path).isFile()) {            // kiem tra duong dan co phai la tep hay khong
                    isValid = true;
                } else {
                    System.out.println("Path doesn't exist");     // sai thi thong bao, nhap lai
                }
            } catch (InputMismatchException e) {             // kiem tra dang du lieu nhap vao dung hay khong
                System.out.println("Path doesn't exist");
            }
        } while (isValid == false);
        try {
            Files.write(Paths.get(f.getPath()), f.getInputContent().getBytes(), StandardOpenOption.APPEND);  // su dung chuc nang write va nhap cac thong so de chuc nang hoat dong 
            System.out.println("Write done");                                                  // bao gom duong dan vao file can viet, du lieu can viet, chuc nang nao duoc thuc thi
        } catch (IOException e) {                                                              // chuyen doi noi dung dau vao thanh dong byte du lieu va duoc thuc thi append vao tep can viet
            System.out.println("Can't write");                                          // tra ve va thong bao da viet duoc hay chua
            return false;
        }
        return true;
    }

    /**
     *
     * @param Ham co chuc nang dem cac tu trong file bang cach phan biet cac tu
     * qua dau cach
     * @return so tu duoc phan biet bang dau " "
     * @throws FileNotFoundException
     * @throws IOException
     */
    public int countCharacter() throws FileNotFoundException, IOException {
        FileClass f = new FileClass();
        Scanner cin = new Scanner(System.in);
        int count = 0;                                         // tao bien dem
        try {
            System.out.print("Enter path:");
            String path = cin.nextLine().trim();                      // Nhap du lieu va kiem tra du lieu
            f.setPath(path);
            if (new File(path).isFile()) {
                File file = new File(f.getPath());                            // khoi tao 
                FileInputStream fis = new FileInputStream(file);       // tao dong du lieu tu file vao bo nho
                byte[] array = new byte[(int) file.length()];     // khoi tao cac dong du lieu de doc thong tin
                fis.read(array);                                  // doc cac mang byte
                String s = new String(array);                     // khoi tao chuoi moi tu noi dung duoc doc tu mang bytes
                String[] sotu = s.split(" ");                          // chia chuoi bang cach cat bang dau " "
                for (int i = 0; i < sotu.length; i++) {                // dem xem mang co bao nhieu phan tu duoc cat thi co bao nhieu tu
                    count++;
                }
                if (count > 1) {             // Thuc hien chu nang dem so tu trong tep co duong dan da nhap
                    System.out.println("Total: " + count + " words");
                } else {
                    System.out.println("Total: " + count + " word");
                }
            } else {
                System.out.println("Path doesn't exist");                                       // Khong co tep thi thong bao va thoat chuong trinh ve menu
            }
        } catch (InputMismatchException e) {                 // kiem tra dang du lieu nhap dung hay khong
            System.out.println("Path doesn't exist");                                        // tra ve so tu dem duoc
        }
        return 0;
    }

    public static void main(String[] args) {

        int choice; // tao bien lua chon de nguoi dung nhap  
        FileManage fm = new FileManage();
        try {
            //Hien thi menu
            do {      //Hien thi lai menu khi thoat chuong trinh, thoat phan mem khi bi exception hoac chon Exit
                Scanner cin = new Scanner(System.in);
                System.out.print(" ========== File Processing ==========\n"
                        + "1. Check Path.\n"
                        + "2. Get file name with type java.\n"
                        + "3. Get file with size greater than input.\n" // menu hien thi de nguoi dung chon chuc nang
                        + "4. Write more content to file.\n"
                        + "5. Read file and count characters.\n"
                        + "6. Exit.\n"
                        + "Please choose one option: ");

                choice = Integer.parseInt(cin.nextLine());     // Nhap chuc nang
                if (choice < 1 || choice > 6) {                // Chi nhan gia tri tu 1 den 6, bao loi neu nhap sai va cho nhap lai
                    System.out.println("The function must be between 1 and 6!");
                } else {
                    switch (choice) {
                        case 1:
                            System.out.println("---------- Check Path ----------");
                            fm.CheckInputPath();
                            break;
                        case 2:
                            System.out.println("------ Get file name with type java ------");
                            fm.getAllFileNameJavaInDirectory();
                            break;                                             
                        case 3:                                                                                // "break" thoat chuong trinh ve menu
                            System.out.println("----- Get file with size greater than input -----");           // "fm. ....." goi ham xu li chuong trinh
                            break;
                        case 4:
                            System.out.println("-------- Write more content to file --------");
                            fm.appendContentToFile();
                            break;
                        case 5:
                            System.out.println("----- Read file and count characters -----");
                            fm.countCharacter();                             
                            break;
                        case 6:               
                            System.out.println("Thanks for using my software !!! Good Bye");   // thoat phan mem
                            break;
                    }
                }
            } while (choice != 6);
        } catch (Exception e) {
            System.out.println("Please choose an option above");   // Khi bi loi thi xuat thong bao exception
        }
    }
}
