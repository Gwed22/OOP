package su22_15_4slot_dohuynhanhvu_ce171446;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Do Huynh Anh Vu - CE171446
 */
public class Check {

    Scanner in = new Scanner(System.in);
    Student st = new Student();

    //check user input number limit
    /**
     *
     * @param min
     * @param max
     * @return
     */
    public int checkChoice(int min, int max) {
        //loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();

                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Please input number in range [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    //check user input string
    /**
     *
     * @return
     */
    public String InputString() {
        //loop until user input correct
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.out.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    //check user input yes/ no
    /**
     *
     * @return
     */
    public boolean InputYN() {
        //loop until user input correct
        while (true) {
            String result = InputString();
            //return true if user input y/Y
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            //return false if user input n/N
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.out.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }

    //check user input u / d
    /**
     *
     * @return
     */
    public boolean InputUD() {
        //loop until user input correct
        while (true) {
            String result = InputString();
            //return true if user input u/U
            if (result.equalsIgnoreCase("U")) {
                return true;
            }
            //return false if user input d/D
            if (result.equalsIgnoreCase("D")) {
                return false;
            }
            System.out.println("Please input u/U or d/D.");
            System.out.print("Enter again: ");
        }
    }

    //check user input course
    /**
     *
     * @return
     */
    public String checkInputCourse() {
        //loop until user input correct
        while (true) {
            String result = InputString();
            //check input course in java/ .net/ c/c++
            if (result.equalsIgnoreCase("Java")
                    || result.equalsIgnoreCase(".Net")
                    || result.equalsIgnoreCase("C/C++")) {
                return result;
            }
            System.out.println("There are only three courses: Java, .Net, C/C++");
            System.out.print("Enter again: ");
        }
    }
    
    /**
     * Check if student exist
     * @param stList
     * @param ID
     * @param sName
     * @param semester
     * @param cName
     * @return
     */
    public boolean checkStudentExist(ArrayList<Student> stList, String ID,
            String sName, String semester, String cName) {
        int size = stList.size();
        for (Student student : stList) {
            if (ID.equalsIgnoreCase(student.getID())
                    && sName.equalsIgnoreCase(student.getsName())
                    && semester.equalsIgnoreCase(student.getSemester())
                    && cName.equalsIgnoreCase(student.getcName())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check if report is exist
     * @param crList
     * @param name
     * @param course
     * @param total
     * @return
     */
    public boolean checkReportExist(ArrayList<Course> crList, String name,
            String course, int total) {
        for (Course cr : crList) {
            if (name.equalsIgnoreCase(cr.getsName())
                    && course.equalsIgnoreCase(cr.getcName())
                    && total == cr.getTotalCourse()) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Method to check if ID exist
     * @param stList
     * @param ID
     * @param name
     * @return
     */
    public boolean IDExist(ArrayList<Student> stList, String ID, String name) {
        for (Student student : stList) {
            if (ID.equalsIgnoreCase(student.getID())
                    && !name.equalsIgnoreCase(student.getsName())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check if update information is change or not
     * @param st
     * @param ID
     * @param name
     * @param semester
     * @param course
     * @return
     */
    public boolean checkChangeInfomation(Student st, String ID,
            String name, String semester, String course) {
        if (ID.equalsIgnoreCase(st.getID())
                && name.equalsIgnoreCase(st.getsName())
                && semester.equalsIgnoreCase(st.getSemester())
                && course.equalsIgnoreCase(st.getcName())) {
            return false;
        }
        return true;
    }

}
