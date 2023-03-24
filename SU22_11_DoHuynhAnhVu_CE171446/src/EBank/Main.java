package EBank;

import java.util.*;

/**
 *
 * @author Do Huynh Anh Vu - CE171446
 */
public class Main {

    Scanner cin = new Scanner(System.in);       // Scanner for input
    Attribute lan = new Attribute();         // Initialize obj

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
                lan.getWord("CheckChoice");   // Inform message if wrong and re-input
            }
        }
    }

    /**
     * Enter String and check if valid (not empty)
     * @return Checked String
     */
    String InputString() {
        while (true) { //Loop until input is valid
            String input = cin.nextLine();
            if (input.length() == 0) {    //String can not be empty
                lan.getWord("CheckInputString");  // Inform message if wrong and re-input
            } else {
                return input;
            }
        }
    }

    /**
     * Method to enter account number and check if valid (must be a 10 digits
     * string)
     * @return Checked account number
     */
    int InputAccount() {
        while (true) { //Loop until input is valid
            lan.getWord("enterAccountNumber");
            String input = cin.nextLine();
            if (input.matches("^\\d{10}$")) {  // match a ten digits string
                return Integer.parseInt(input);
            }
            lan.getWord("CheckInputAccount"); // Inform message if wrong and re-input
            System.out.println();
        }
    }

    /**
     * Method to enter password and check if valid (method isPassValid)
     * @return
     */
    String InputPassword() {
        String input;
        while (true) {  //Loop until input is valid
            lan.getWord("enterPassword");
            input = InputString();
            if (isPassValid(input)) {
                return input;
            }
        }
    }

    /**
     * Method to check password
     * @param password
     * @return
     */
    boolean isPassValid(String password) {
        int lengthPassword = password.length();
        if (lengthPassword < 8 || lengthPassword > 31) { //password must be between 8 - 31 character
            lan.getWord("CheckLengthPassword");  // Inform message if wrong
            System.out.println();
            return false;
        } else {
            int countDigit = 0;
            int countLetter = 0;
            for (int i = 0; i < lengthPassword - 1; i++) {
                if (Character.isDigit(password.charAt(i))) {                // password must have both digit and letter
                    countDigit++;
                } else if (Character.isLetter(password.charAt(i))) {
                    countLetter++;
                }
            }
            if (countDigit == 0 || countLetter == 0) {
                lan.getWord("CheckAlphanumericPassword"); // Inform message if wrong 
                System.out.println();
                return false;
            }
        }
        return true;
    }

    /**
     * Method to check if captcha input is correct
     * @param captchaGenerated
     * @return
     */
    boolean InputCaptcha(String captchaGenerated) {  //get the random generated captcha
        System.out.println(captchaGenerated);  // print that captcha to moniter
        lan.getWord("enterCaptcha");
        String captchaInput = InputString();
        for (int i = 0; i < captchaInput.length(); i++) { // Check if user input have a character that match with a character in the captcha string => correct
            if (!captchaGenerated.contains(Character.toString(captchaInput.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Method to create a random String (captcha)
     * @return a randomize generate captcha string
     */
    String generateCaptchaText() {
        char[] chars = {'1', 'A', 'a', 'B', 'b', 'C',
            'c', '2', 'D', 'd', 'E', 'e', 'F', 'f', '3', 'G', 'g', 'H', 'h',
            'I', 'i', 'J', 'j', 'K', 'k', 'L', 'l', '4', 'M', 'm', 'N', 'n',
            'O', 'o', '5', 'P', 'p', 'Q', 'q', 'R', 'r', 'S', 's', 'T', 't',
            '6', '7', 'U', 'u', 'V', 'v', 'U', 'u', 'W', 'w', '8', 'X', 'x', // Initiallize an character array for randomize character
            'Y', 'y', 'Z', 'z', '9'};
        String randomStrValue = ""; // Initialize the string
        final int LENGTH = 6; //captcha length is 6 character
        StringBuilder sb = new StringBuilder(); // Create buffer for writing
        int index = 0;
        for (int i = 0; i < LENGTH; i++) {
            index = (int) (Math.random() * (chars.length - 1));
            sb.append(chars[index]);     // Write a random character to the string
        }
        return sb.toString();
    }

    /**
     * Method to login to EBank
     */
    void login() {
        int accountNumber = InputAccount();    // Input account number
        String passString = InputPassword();   // Input password 
        String captchaGenerated = generateCaptchaText(); // Input captcha
        while (true) {  //Loop until captcha is correct
            if (InputCaptcha(captchaGenerated)) {
                lan.getWord("loginSuccess");
                System.out.println();
                return;
            } else {
                lan.getWord("CaptchaIncorrect");
                System.out.println();
            }
        }
    }

    /**
     * Method for displaying menu to monitor and option for user to choose
     */
    void menu() {

        Locale vi = new Locale("vi");    //Initialize Locale
        Locale en = new Locale("en");
        //Display menu
        System.out.println("========== LOGIN PROGRAM ===========");
        System.out.println("1. Vietnamese");
        System.out.println("2. English");
        System.out.println("3. Exit");
        System.out.print("Please choice one option: ");
        int choice = checkChoice(1, 3);
        switch (choice) {
            case 1:
                lan.setLang(vi);
                login();
                break;          //set language to each option
            case 2:
                lan.setLang(en);
                login();
                break;
            case 3:
                return;
        }
    }

    /**
     * Main method to execute program
     * @param args
     */
    public static void main(String[] args) {
        Main mn = new Main();  //Allocated memory 
        //and execute program - call menu
        mn.menu();
    }
}
