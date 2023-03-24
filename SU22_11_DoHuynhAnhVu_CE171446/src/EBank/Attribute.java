package EBank;

import java.util.*;

/**
 *
 * @author Do Huynh Anh Vu - CE171446
 */
public class Attribute {

    //=========== ATTRIBUTE ==========//
    protected java.util.Locale Lang;

    //=========== CONSTRUCTOR ==========//
    /**
     * @param Initialize Locale with String
     */
    public Attribute(String str) {
    }

    /**
     * @param Lang
     */
    public Attribute(Locale Lang) {
        this.Lang = Lang;
    }

    Attribute() {
    }

    //======== GET & SET =============//
    /**
     *
     * @return Language of Locale
     */
    public Locale getLang() {
        return Lang;
    }

    /**
     * Set new Language to locale
     *
     * @param Lang
     */
    public void setLang(Locale Lang) {
        this.Lang = Lang;
    }

    /**
     * Method to get message value from key in properties file
     */
    void getWord(String key) {
        ResourceBundle words = ResourceBundle.getBundle("Lang/" + getLang(), getLang()); //Get resource from path and locale
        String value = words.getString(key);
        System.out.print(value);
    }
}
