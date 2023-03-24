package su22_04_dohuynhanhvu_ce171446;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Do Huynh Anh Vu CE171446
 */
public class ManageEastAsiaCountries {

    Scanner cin = new Scanner(System.in);
    EastAsiaCountries[] EAC = new EastAsiaCountries[11];
    boolean valid = false;                                     // Khoi tao scanner, cac bien va list de luu gia tri va nhap lieu
    ArrayList<EastAsiaCountries> array = new ArrayList<>();
    EastAsiaCountries ec;
    int count = 0;

    /**
     *
     * @throws Exception
     */
    public void menu() throws Exception {
        int choice = 0;
        do { //Hien thi lai menu khi thoat chuong trinh, thoat vong lap khi chon Exit (choice = 5)
            try {
                //Hien thi menu
                System.out.print("                    MENU                      \n"
                        + "=====================================================\n"
                        + "1. Input the information of 11 countries in East Asia.\n"
                        + "2. Display the information of country you just input.\n"
                        + "3. Search the information of country by user-entered name.\n" // menu hien thi de nguoi dung chon chuc nang
                        + "4. Display the information of countries sorted name in ascending order.\n"
                        + "5. Exit.\n"
                        + "=====================================================\n"
                        + "Please choose one option: "
                );
                choice = Integer.parseInt(cin.nextLine().trim());                // Nhap chuc nang
                if (choice > 1 && choice < 5 && valid == false) {                // Chi thuc hien chuc nang 2,3,4 khi thuc hien chuc nang 1
                    System.err.println("You must input coutries information first (option 1) to execute other function!");
                } else if (choice < 1 || choice > 5) {
                    System.err.println("Please choose from 1 -> 5");
                } else {
                    switch (choice) {
                        case 1:
                            System.out.println("========= Add Information ========");
                            addCountryInformation();                   // Thuc hien ham them country vao array
                            break;
                        case 2:
                            System.out.println("========= Recently Input ========");
                            System.out.println("ID             Name           Total Area         Terrain");
                            getRecentlyEnteredInformation();          //goi ham lay gia tri vua nhap
                            System.out.printf("%-14s %-14s %-18.2f %-14s\n\n", ec.getCountryCode(), ec.getCountryName(), ec.getTotalArea(), ec.getCountryTerrain());  // Hien thi thong tin Country lay duoc
                            break;
                        case 3:
                            System.out.println("========= Search Information by Name ========");
                            System.out.println("Enter the name you want to search:");
                            String entered = cin.nextLine().trim(); // Lay du lieu nhap vao
                            searchInformationByName(entered);       // Xu li co tim thay khong, khong thay tra ve count = 0
                            if (count == 0) {
                                System.err.println("Not Found!");
                            } else {
                                System.out.println("ID             Name           Total Area         Terrain");
                                System.out.println(toString(searchInformationByName(entered)));        // Tim thay thi hien thi mang theo format
                            }
                            break;
                        case 4:
                            System.out.println("========= Sort Information ========");
                            System.out.println("ID             Name           Total Area         Terrain");
                            sortInformationByAscendingOrder();       // Sap xep lai mang
                            System.out.println(toString(EAC));       // Hien Thi mang theo thu tu alphabets tang dan A -> Z (CountryName)
                            break;
                        case 5:
                            System.out.println("Thanks for using my software !!! Good Bye");  // thoat phan mem
                            break;
                    }
                }
            } catch (NumberFormatException e) {
                System.err.println("Please choose an option above!");                              // Khi bi loi thi xuat thong bao exception
            }
        } while (choice != 5);
    }

    /**
     *
     * @throws Exception
     */
    public void addCountryInformation() throws Exception {
        String name = null;
        String code = null;
        float area = 0;                        // Khoi tao cac bien de nhap du lieu
        String terrain = null;
        do {                // Thoat vong lap khi tat ca du lieu dau vao dung
            valid = false;
            try {
                System.out.println("Enter code of country:");
                code = cin.nextLine();
            } catch (InputMismatchException e) {
                System.err.println("Input must be a string");
                valid = true;
            }
            try {
                System.out.println("Enter name of country:");
                name = cin.nextLine();
            } catch (InputMismatchException e) {
                System.err.println("Input must be a string");                   // Nhap 4 thuoc tinh cua object va kiem tra du lieu dau vao
                valid = true;                                                   // Sai se bao loi va cho nhap lai
            }
            try {
                System.out.println("Enter total Area:");
                area = Float.parseFloat(cin.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Input must be a positive number!");
                valid = true;
            }
            try {
                System.out.println("Enter terrain of country:");
                terrain = cin.nextLine();
            } catch (InputMismatchException e) {
                System.err.println("Input must be a string");
                valid = true;
            }
            System.out.println("==================================");
        } while (valid == true);
        EAC[array.size()] = new EastAsiaCountries(code, name, area, terrain);      // Khi nhap dung thi luu cac thuoc tinh vao object
        array.add(EAC[array.size()]);                                              // Luu du lieu vao mang de de xu li
        System.out.println("Add Success!");                                        // Thong bao them thanh cong
        this.valid = true;           // tra ve bien valid de chuong trinh cho thuc hien chuc nang 2,3,4
    }

    /**
     *
     * @return Object vua nhap lieu
     * @throws Exception
     */
    public EastAsiaCountries getRecentlyEnteredInformation() throws Exception {
        ec = EAC[array.size() - 1];                             // Lay du lieu cua object vua nhap
        return ec;
    }

    /**
     *
     * @param input du lieu truyen vao de ham thuc thi
     * @return array co chua cac object tim duoc theo du lieu dau vao
     * @throws Exception
     */
    public EastAsiaCountries[] searchInformationByName(String input) throws Exception {
        EastAsiaCountries[] search = new EastAsiaCountries[11];
        String name = input;
        count = 0;         // tra ve bien count = 0
        for (int i = 0; i < array.size(); i++) {
            if (EAC[i].getCountryName().equalsIgnoreCase(name) && EAC[i] != null) {   // neu thuoc tinh CountryName giong voi du lieu truyen vao input va object khong rong
                search[count] = EAC[i];                                   // luu obj tim duoc vao mang
                count++;                       // tang bien dem de luu gia tri cho mang va thong bao da tim duoc 
            }
        }
        return search;
    }

    /**
     * @return array da duoc sort theo alphabets A -> Z
     * @throws Exception
     */
    public EastAsiaCountries[] sortInformationByAscendingOrder() throws Exception {
        Collections.sort(array, new NameComparator()); // Sap xep mang bang thu vien Collections
        for (int i = 0; i < array.size(); ++i) {
            EAC[i] = new EastAsiaCountries(array.get(i).getCountryCode(), array.get(i).getCountryName(), array.get(i).getTotalArea(), array.get(i).getCountryTerrain());
        }      // Luu gia tri cua mang da sort mang cua cac obj
        return EAC;
    }

    /**
     * @param Obj[]A du lieu obj dau vao
     * @return Chuoi hien thi da duoc format
     */
    public String toString(Object[] a) {
        if (a == null) {
            return "Lack of information!!!";  // Thong bao khi mang cua obj rong
        }

        int iMax = array.size();
        if (iMax == -1) {
            return "Lack of information!!!";  //  Thong bao khi mang cua obj rong
        }

        StringBuilder b = new StringBuilder();
        for (int i = 0; i < array.size(); i++) {
            if (a[i] != null) {        // neu a[i] khong rong thi viet gia tri vao chuoi b
                b.append(String.valueOf(a[i]));
            } else if (i == iMax) {  // tra ve chuoi b khi den gia tri iMax
                return b.toString();
            }
        }
        return b.toString();
    }
}

class Main {

    /**
     * @param Ham main de chay phan mem
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        ManageEastAsiaCountries mn = new ManageEastAsiaCountries();
        mn.menu();         // Goi menu de thuc hien cac chuc nang phan mem
    }
}

class NameComparator implements Comparator<EastAsiaCountries> {

    /**
     * Khoi tao comparater de sort mang theo thu tu alphabet A -> Z
     */
    @Override
    public int compare(EastAsiaCountries c1, EastAsiaCountries c2) {
        return c1.getCountryName().toLowerCase().compareTo(c2.getCountryName().toLowerCase());

    }
}
