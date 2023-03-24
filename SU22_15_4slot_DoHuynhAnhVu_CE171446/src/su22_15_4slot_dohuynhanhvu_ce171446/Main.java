package su22_15_4slot_dohuynhanhvu_ce171446;

/**
 *
 * @author Do Huynh Anh Vu - CE171446
 */
public class Main {

    /**
     * Main method to execute program
     * @param args
     */
    public static void main(String[] args) {

        Check ck = new Check();
        Manage mn = new Manage();

        //loop until user want to exit program
        while (true) {
            //Show menu option
            mn.menu();
            int choice = ck.checkChoice(1, 5);
            switch (choice) {
                case 1:
                    mn.createStudent();
                    break;
                case 2:
                    mn.findAndSort();
                    break;
                case 3:
                    mn.updateOrDelete();
                    break;
                case 4:
                    mn.report();
                    break;
                case 5:
                    return;
            }

        }
    }

}
