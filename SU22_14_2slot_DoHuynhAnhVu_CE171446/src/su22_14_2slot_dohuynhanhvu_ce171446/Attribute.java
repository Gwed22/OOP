package su22_14_2slot_dohuynhanhvu_ce171446;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Do Huynh Anh Vu - CE171446
 */
public class Attribute {

    //======== ATTRIBUTE ==========
    protected String str;

    //======== CONSTRUCTOR ==========
    public Attribute() {
    }

    public Attribute(String str) {
        this.str = str;
    }

    //====== GET & SET ========
    /**
     * get input string
     *
     * @return
     */
    public String getStr() {

        return str;
    }

    /**
     * set new String
     *
     * @param str
     */
    public void setStr(String str) {
        this.str = str;
    }

    //======= Method on Attribute ========
    /**
     * Method Number for analyze number in string (even, odd, square, all)
     */
    public void Number() {
        ArrayList<Integer> Odd = new ArrayList<>();
        ArrayList<Integer> Even = new ArrayList<>(); // Initialize array list for storing value with each type of number
        ArrayList<Integer> All = new ArrayList<>();
        ArrayList<Integer> SqrNum = new ArrayList<>();
        HashMap<String, ArrayList<Integer>> Num = new HashMap<>(); // Duplcicate test case and saving array list with its type(key)

        String number = str.replaceAll("\\D+", ","); // Replace all character with ","
        if (number.charAt(0) == ',') {
            number = number.substring(1);
        }
        if (number.charAt(number.length() - 1) == ',') {
            number = number.substring(0, number.length() - 1);    //Get rid of "," create in the previous code
        }
        String[] numberArr = number.split(",");
        for (int i = 0; i < numberArr.length; i++) {
            int checkNum = Integer.parseInt(numberArr[i]);
            if (checkNum % 2 == 1) {
                Odd.add(checkNum);
            }
            if (checkNum % 2 == 0) {                                        //Check number in Str number then add that to each array list of its type
                Even.add(checkNum);
            }
            double checksqr = Math.sqrt(checkNum);
            if ((checksqr - Math.floor(checksqr)) == 0) {
                SqrNum.add(checkNum);
            }
            All.add(checkNum);       //add each number to array with all numberic
        }
        Num.put("Perfect Square Numbers: ", SqrNum);
        Num.put("Odd Numbers: ", Odd);
        Num.put("Even Numbers: ", Even);  //saving array list to hash map with key
        Num.put("All Numbers: ", All);
        Num.entrySet().forEach((m) -> {
            System.out.println(m.getKey() + " " + m.getValue()); // print out value from hashmap
        });
    }

    /**
     * Character method for analyze character in String
     */
    public void Character() {
        HashMap<String, String> Str = new HashMap<>();  //Duplicate test case
        String upper = str.replaceAll("\\W|[0-9]|[a-z]", "");      //Delete all numeric and character except uppercase
        String lower = str.replaceAll("\\W|[0-9]|[A-Z]", "");  //Delete all numeric and character except lowercase
        String specChar = str.replaceAll("\\w", "");      //Delete all character except special character
        String all = str.replaceAll("\\W", "");     // Delete all numeric and special character
        Str.put("Uppercase: ", upper);
        Str.put("Lowercase: ", lower);
        Str.put("Special: ", specChar);       //saving string to hashmap with key
        Str.put("All Character: ", all);
        Str.entrySet().forEach((m) -> {
            System.out.println(m.getKey() + " " + m.getValue());
        });
    }
}
