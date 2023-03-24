package su22_13_dohuynhanhvu_ce171446;

import java.util.*;
import java.io.*;

/**
 *
 * @author Do Huynh Anh Vu - CE171446
 */
public class QLHoSo {

    private ArrayList<HoSo> dsHoSo;  // Arraylist for saving data
    private HoSo check = new HoSo();

    /**
     * Method to input attribute value to object and add object to array list
     */
    public void Add() {
        Scanner cin = new Scanner(System.in);
        System.out.println("======= THEM HO SO ========");
        System.out.print("Nhap so ho so can them: ");
        int n = Integer.parseInt(cin.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("=======================");
            System.out.print("Nhap ID hoc sinh: ");
            String IDHS = check.CheckID();
            System.out.print("Nhap TenTC: ");
            String TenTC = check.CheckEmpty();
            System.out.print("Nhap nam dang ky: ");
            String NamDK = check.CheckYear();                      // Input data and check if input is valid
            System.out.print("Nhap dia chi: ");
            String DChi = check.CheckEmpty();
            dsHoSo.add(new HoSo(IDHS, TenTC, NamDK, DChi));
        }
    }

    /**
     * Method to show data saving in array list 
     */
    public void show() {
        System.out.println("======= DANH SACH HO SO ========");
        if (dsHoSo.isEmpty()) {
            System.out.println("Danh sach ho so khong co du lieu."); // Check if list have data to display
            return;
        }
        System.out.printf("%-6s%-15s%-8s%-15s\n", "ID", "TenTC", "NamDK", "DChi"); //Display attribute
        for (int i = 0; i < dsHoSo.size(); i++) {
            System.out.printf("%-6s%-15s%-8s%-15s\n", dsHoSo.get(i).getID(), dsHoSo.get(i).getsName(), dsHoSo.get(i).getYear(), dsHoSo.get(i).getAddr()); 
        }          //Display attribute value each line for each object
        System.out.println("");
    }

    /**
     * Method to save data from array list to file by object input stream
     * @throws IOException
     */
    public void saveFile() throws IOException {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null; //Initialize file output stream and object output stream
        File file = new File("Data.txt");
        try {
            fos = new FileOutputStream(file);  //create output data stream to file
            oos = new ObjectOutputStream(fos);   //create output data stream from object
            oos.writeObject(dsHoSo); //write data stream from array list to file
            System.out.println("Luu du lieu thanh cong!");
            System.out.println("Luu xong [" + dsHoSo.size() + " ho so!]");
            oos.close();
            fos.close(); //close stream
        } catch (IOException e) {
            System.out.println(e);  //print out exception if error
        }
    }

    /**
     * Method to load data from file to array list by object input stream
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void loadFile() throws IOException, ClassNotFoundException {
        dsHoSo = new ArrayList<>(); // Initialize new array list for storing data
        FileInputStream fis = null;
        ObjectInputStream ois = null;  //Initialize file input stream and object input stream
        File file = new File("Data.txt");
        try {
            fis = new FileInputStream(file);  //create input data stream from file
            ois = new ObjectInputStream(fis); //create input data stream from object in file
            dsHoSo = (ArrayList<HoSo>) ois.readObject(); //read data stream from file then save to array list
            System.out.println("Tai du lieu thanh cong - [" + dsHoSo.size() + " ho so]");
            ois.close();
            fis.close(); //close stream
        } catch (IOException e) {
            System.out.println(e); //print out exception if error
        }
    }

    /**
     * Method to check if task with input ID is exist
     */
    private boolean IDExist(String ID) {
        for (int i = 0; i < dsHoSo.size(); i++) {
            if (dsHoSo.get(i).getID().equals(ID)) {    //If there exist return that id
                return true;
            }
        }
        return false;
    }

    /**
     * Method for displaying menu to monitor and option for user to choose
     */
    void menu() throws IOException, ClassNotFoundException {
        loadFile(); //load file to array list when program start
        //Display menu
        while (true) {
            System.out.println("========== MENU ===========");
            System.out.println("1. Them ho so");
            System.out.println("2. Hien thi danh sach ho so");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon: ");
            int choice = check.checkChoice(0, 2);
            switch (choice) {
                case 1:
                    Add();
                    break;
                case 2:
                    show();           // Call method to execute option from user
                    break;
                case 0:
                    saveFile();
                    return;
            }
        }
    }

    /**
     * Main method to execute program
     * @param args
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        QLHoSo m = new QLHoSo();
        //and execute program - call menu
        m.menu();
    }
}
