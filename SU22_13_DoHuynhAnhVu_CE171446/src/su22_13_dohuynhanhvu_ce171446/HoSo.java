package su22_13_dohuynhanhvu_ce171446;

import java.util.Scanner;
import java.io.Serializable;

/**
 *
 * @author Do Huynh Anh Vu - CE171446
 */
public class HoSo implements Serializable {
// implement Serializable to serialize attribute data
    
    //========== ATTRIBUTE ==========

    protected String ID;
    protected String sName;
    protected String Year;
    protected String Addr;
    private static final long serialVersionUID = 1;

    //========= CONSTRUCTOR ==========

    /**
     * Constructor with no parameter
     */
    public HoSo() {
    }

    /**
     * Constructor have parameter
     * @param ID
     * @param sName
     * @param Year
     * @param Addr
     */
    public HoSo(String ID, String sName, String Year, String Addr) {
        this.ID = ID;
        this.sName = sName;
        this.Year = Year;
        this.Addr = Addr;
    }

    //========= GET & SET ==========

    /**
     *
     * @return ID
     */
    public String getID() {
        return ID;
    }

    /**
     * set new ID
     * @param ID
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     *
     * @return Name
     */
    public String getsName() {
        return sName;
    }

    /**
     * set new Name
     * @param sName
     */
    public void setsName(String sName) {
        this.sName = sName;
    }

    /**
     *
     * @return Year
     */
    public String getYear() {
        return Year;
    }

    /**
     * set new year
     * @param Year
     */
    public void setYear(String Year) {
        this.Year = Year;
    }

    /**
     *
     * @return address
     */
    public String getAddr() {
        return Addr;
    }

    /**
     * set new address
     * @param Addr
     */
    public void setAddr(String Addr) {
        this.Addr = Addr;
    }

    //======= CHECK INPUT ========
    
    //make scanner transient because its not serializable
    private transient Scanner cin = new Scanner(System.in);

    /**
     * Method to check if user choice in menu is valid
     * @param min
     * @param max
     * @return choice entered by user
     */
    int checkChoice(int min, int max) {
        while (true) {  //Loop until input is valid
            try {
                int input = Integer.parseInt(cin.nextLine());
                if (input < min || input > max) {          // Check if user choice is in range 1 - 3
                    throw new NumberFormatException();
                }
                return input;
            } catch (NumberFormatException ex) {
                System.out.println("Please choose option from [" + min + "] -> [" + max + "] !");  // Inform message if wrong and re-input
                System.out.print("Enter again");
            }
        }
    }

    /**
     * Enter String and check if valid (not empty)
     * @return Checked String
     */
    String CheckEmpty() {
        while (true) { //Loop until input is valid
            String input = cin.nextLine();
            if (input.isEmpty()) {    //String can not be empty
                System.out.println("Ten va dia chi khong duoc de trong!");  // Inform message if wrong and re-input
                System.out.print("Nhap lai: ");
            } else {
                return input;
            }
        }
    }

    /**
     * Enter String and check if valid (must be a number and > 1900)
     * @return Checked String
     */
    String CheckYear() {
        while (true) { //Loop until input is valid
            try {
                String input = cin.nextLine();
                if (Integer.parseInt(input) <= 1900) {    //String must larger than 1900
                    throw new NumberFormatException();
                } else {
                    return input;
                }
            } catch (NumberFormatException e) {
                System.out.println("Nam dang ky phai la so va lon hon 1900!");  // Inform message if wrong and re-input
                System.out.print("Nhap lai: ");
            }
        }
    }

    /**
     * Enter String and check if valid (has 4 characters)
     * @return Checked String
     */
    String CheckID() {
        while (true) { //Loop until input is valid
            String input = cin.nextLine();
            if (input.length() != 4) {    //String must ahve 4 character
                System.out.println("ID hoc sinh phai co 4 ky tu!");  // Inform message if wrong and re-input
                System.out.print("Nhap lai: ");
            } else {
                return input;
            }
        }
    }
}
