package customermanage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author Do Huynh Anh Vu - CE171446
 */
public class Manage {

    Scanner cin = new Scanner(System.in);                                 // Khoi tao scanner nhap du lieu
    ArrayList<CustomerManage> Cus = new ArrayList<>();                    // Khoi tao arraylist de luu cac truong cua object (toan cuc)

    /**
     * Ham dung de import du lieu tu tep vao bo dem sau do luu vao arraylist de
     * cung cap du lieu cho chuong trinh hoat dong
     */
    public void importCSV() throws Exception {
        String str = "";
        BufferedReader reader = null;                                     // khoi tao reader de doc

        System.out.print("Enter Import Path: ");                          //Nhap duong dan tep
        String path = cin.nextLine().trim();

        try {
            reader = new BufferedReader(new FileReader(path));            // tao reader moi de doc du lieu tu tep voi duong dan duoc nhap
            while ((str = reader.readLine()) != null) {             // doc toi khi nao reader nhan gia tri null (khong con chu hay du lieu dau vao)
                String[] split = str.split(",");                          // Cat chuoi str thanh cac chuoi nho bang dau "," vao mang split
                Cus.add(new CustomerManage(Integer.parseInt(split[0]), split[1], split[2], split[3], split[4]));
            } // moi chuoi nho duoc cat la mot truong cua object, sau do add vao arraylist theo thu tu da duoc cat

            System.out.println("---------- Import Done!");                // Thong bao da import du lieu xong
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");                        // Thong bao khi khong tim thay tep 
        } catch (Exception e) {
        } finally {
            if (reader != null) {
                try {
                    reader.close();                                       // Close reader de tat dong du lieu tren bo dem (buffer), tep duoc dong va san sang duoc su dung
                } catch (Exception e) {
                    System.out.println("---------Import Fail!");          // Thong bao fail khi bi exception
                }
            }
        }
    }

    /**
     * Ham format lai du lieu truong address cua object theo qui cach Xxxx Xxxx
     * - Xxxx Xxxx - Xxxx Xxxx (moi tu va ki hieu cach mot khoang trang va viet
     * hoa chu cai dau cua tu )
     */
    public void formatAddress() throws Exception {
        try {
            for (int i = 0; i < Cus.size(); i++) {                          // Chay vong lap de lay du lieu truong address cua moi object
                String address = Cus.get(i).getAddress().trim();            // Dan du lieu truong address lay duoc vao bien
                address = address.toLowerCase().replaceAll("\\s+", ",");    // Doi chuoi address thanh chu thuong va khoang cach thanh dau ","
                String[] array = address.split(",");                        // Cat chuoi address thanh cac chuoi nho phantach bang dau ","
                StringBuffer sb = new StringBuffer();                       // tao bo dem de viet
                for (String array1 : array) {
                    sb.append(Character.toUpperCase(array1.charAt(0))).append(array1.substring(1)).append(" ");
                } // In hoa chu cai dau cua moi tu roi sau do viet cac chu con lai cua tu, viet khoang trang roi tuong tu den het mang (het cac tu cua chuoi address ban dau)
                Cus.get(i).setAddress(sb.toString().trim());                // luu lai du lieu truong address da format cua object
            }
            System.out.println("---------- Format Done!");                  // Thong bao khi format xong
        } catch (Exception e) {
            System.out.println("---------Format Fail!");                    // Thong bao khi bi exception
        }
    }

    /**
     * Ham format lai du lieu truong name cua object theo qui cach Xxxx Xxxx
     * Xxxx (moi tu cach mot khoang trang va viet hoa chu cai dau)
     */
    public String formatName() throws Exception {
        try {
            for (int i = 0; i < Cus.size(); i++) {                         // Chay vong lap de lay du lieu truong name cua moi object
                String name = Cus.get(i).getName().trim();                 // Dan du lieu truong name lay duoc vao bien
                name = name.toLowerCase().replaceAll("\\s+", ",");         // Doi chuoi name thanh chu thuong va khoang cach thanh dau ","
                String[] array = name.split(",");                          // Cat chuoi name thanh cac chuoi nho phantach bang dau ","
                StringBuilder sb = new StringBuilder();                    // tao bo dem de viet
                for (String array1 : array) {
                    sb.append(Character.toUpperCase(array1.charAt(0))).append(array1.substring(1)).append(" ");
                } // In hoa chu cai dau cua moi tu roi sau do viet cac chu con lai cua tu, viet khoang trang roi tuong tu den het mang (het cac tu cua chuoi name ban dau)
                Cus.get(i).setName(sb.toString().trim());                 // luu lai du lieu truong name da format cua object

            }
            System.out.println("---------- Format Done!");                // Thong bao khi format xong
        } catch (Exception e) {
            System.out.println("---------Format Fail!");                  // Thong bao khi bi exception
        }
        return null;
    }

    /**
     *
     * @throws Exception
     */
    public void exportCSV() throws Exception {
        FileWriter fw = null;
        System.out.print("Enter Export Path: ");                    // Nhap duong dan tep export
        String path = cin.nextLine().trim();

        try {
            fw = new FileWriter(path);                            // tao file writer moi de viet vao tep co duong dan duoc nhap
            for (CustomerManage list : Cus) {                     // Chay vong lap de luu du lieu trong array list vao tep (Chay het khi nao het du lieu trong list)
                fw.append(String.valueOf(list.getID()));          // luu du lieu dang string cua id
                fw.append(",");                                   // viet them dau "," de phan tach cac thuoc tinh
                fw.append(list.getName());                        // luu du lieu cac thuoc tinh khac tuong tu
                fw.append(",");
                fw.append(list.getEmail());
                fw.append(",");
                fw.append(list.getPN());
                fw.append(",");
                fw.append(list.getAddress());
                fw.append("\n");                                 // luu het 5 thuoc tinh cua object xong thi xuong hang va viet tiep tuc  object ke tiep
            }
            System.out.println("-------- Export Done!");         // Thong bao khi export thanh cong
        } catch (IOException e) {
            System.out.println("------Export Fail!");            // Thong bao khi bij exception
        } finally {
            try {
                fw.flush();                                      // cho file writer ghi tat ca du lieu co trong file writer vao tep
                fw.close();                                          // dong file writer
            } catch (IOException e) {
            }
        }
    }
}
