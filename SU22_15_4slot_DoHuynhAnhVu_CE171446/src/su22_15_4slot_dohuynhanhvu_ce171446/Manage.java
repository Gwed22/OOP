package su22_15_4slot_dohuynhanhvu_ce171446;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Do Huynh Anh Vu - CE171446
 */
public class Manage {

    Check ck = new Check();
    Student st = new Student();
    Course cr = new Course();
    ArrayList<Student> stList = new ArrayList<>();
    ArrayList<Student> FindByName = new ArrayList<>();     //Initialize array for storing student list and found student list by name

    /**
     * Method to display menu
     */
    public void menu() {
        System.out.println("===== STUDENT MANAGEMENT =====");
        System.out.println(" 1.	Create");
        System.out.println(" 2.	Find and Sort");
        System.out.println(" 3.	Update/Delete");
        System.out.println(" 4.	Report");
        System.out.println(" 5.	Exit");
        System.out.print(" Enter your choice: ");
    }

    /**
     * Method to create new student
     */
    public void createStudent() {
        //if number of students greater than 10 ask user continue or not
        if (stList.size() > 10) {
            System.out.print("Do you want to continue (Y/N): ");
            if (!ck.InputYN()) {
                return;
            }
        }
        //loop until user input not duplicate
        while (true) {
            System.out.println("\n==== CREATE STUDENT ====");
            System.out.print("Enter ID: ");
            String id = ck.InputString();
            System.out.print("Enter student name: ");
            String name = ck.InputString();
            System.out.print("Enter semester: ");
            String semester = ck.InputString();
            System.out.print("Enter course name: ");
            String course = ck.checkInputCourse();
            //check student exist or not
            if (ck.checkStudentExist(stList, id, name, semester, course)) {
                stList.add(new Student(id, name, semester, course));
                System.out.println("Add student success.");
                System.out.println("");
                return;
            }
            System.out.println("Duplicate. Enter again :");
        }
    }

    /**
     * Method to find student in student list by name and sorted by name
     */
    public void findAndSort() {
        //check list empty 
        if (stList.isEmpty()) {
            System.out.println("List empty.");
            return;
        }
        ArrayList<Student> StudentF = FindByName();
        if (StudentF.isEmpty()) {
            System.out.println("Not exist.");
        } else {
            Collections.sort(StudentF);
            System.out.printf("%-15s%-15s%-15s\n", "Student name", "semester", "Course Name");
            //loop from first to last element of list student
            for (Student item : StudentF) {
                item.display();
            }
            System.out.println("");
        }
    }

    /**
     * Method to find student by name then add to array list
     *
     * @return
     */
    public ArrayList<Student> FindByName() {
        FindByName = new ArrayList<>();
        System.out.print("Enter name to search: ");
        String name = ck.InputString();
        for (Student item : stList) {
            //check student have name contains input
            if (item.getsName().contains(name)) {
                FindByName.add(item);
            }
        }
        return FindByName;
    }

    /**
     * Method to update and delete student by ID input
     */
    public void updateOrDelete() {
        //if list empty 
        if (stList.isEmpty()) {
            System.out.println("List empty.");
            return;
        }
        System.out.print("Enter ID: ");
        String ID = ck.InputString();
        FindByName = getListStudentByID(ID);
        //check list empty
        if (FindByName.isEmpty()) {
            System.out.println("Not found student.");
            System.out.println("");
            return;
        } else {
            Student student = getStudentByListFound();
            System.out.print("Do you want to update (U) or delete (D) student: ");
            //check user want to update or delete
            if (ck.InputUD()) {
                System.out.print("Enter ID: ");
                String id = ck.InputString();
                System.out.print("Enter student name: ");
                String name = ck.InputString();
                System.out.print("Enter semester: ");
                String semester = ck.InputString();
                System.out.print("Enter course name: ");
                String course = ck.checkInputCourse();
                //check user change or not
                if (!ck.checkChangeInfomation(student, id, name, semester, course)) {
                    System.out.println("Not Update.");
                }
                //check student exist or not
                if (ck.checkStudentExist(stList, id, name, semester, course)) {
                    student.setID(id);
                    student.setsName(name);
                    student.setSemester(semester);
                    student.setcName(course);
                    System.out.println("Update success.");
                    System.out.println("");
                } else {
                    System.out.println("Duplicate. Not update");
                    return;
                }
            } else {
                stList.remove(student);
                System.out.println("Delete success.");
                System.out.println("");
                return;
            }
        }
    }

    /**
     * Method to get a student in the list found by ID
     *
     * @return
     */
    public Student getStudentByListFound() {
        System.out.println("List student found: ");
        int count = 0;
        System.out.printf("%-10s%-15s%-15s%-15s\n", "Number", "Student name",
                "Semester", "Course Name");
        //display list student found
        for (Student item : FindByName) {
            System.out.printf("%-10d%-15s%-15s%-15s\n", ++count,
                    item.getsName(), item.getSemester(),
                    item.getcName());
        }
        System.out.println("");
        System.out.print("Enter student: ");
        int choice = ck.checkChoice(1, FindByName.size());
        return FindByName.get(choice - 1);
    }

    /**
     * Method to get a list of student by name
     *
     * @param ID
     * @return
     */
    public ArrayList<Student> getListStudentByID(String ID) {
        ArrayList<Student> getListStudentById = new ArrayList<>();
        for (Student student : stList) {
            if (ID.contains(student.getID())) {
                getListStudentById.add(student);
            }
        }
        return getListStudentById;
    }

    /**
     * Method to analyze then print out report
     */
    public void report() {
        if (stList.isEmpty()) {
            System.out.println("List empty.");
            return;
        }
        ArrayList<Course> crList = new ArrayList<>();
        for (int i = 0; i < stList.size(); i++) {
            for (Student student : stList) {
                int total = 0;
                String id = student.getID();
                String courseName = student.getcName();
                String studentName = student.getsName();
                for (Student studentCountTotal : stList) {
                    if (id.equalsIgnoreCase(studentCountTotal.getID())
                            && courseName.equalsIgnoreCase(studentCountTotal.getcName())) {
                        total++;
                    }
                }
                if (ck.checkReportExist(crList, studentName,
                        courseName, total)) {
                    crList.add(new Course(studentName, courseName, total));
                }
            }
        }
        //print report
        for (int i = 0; i < crList.size(); i++) {
            System.out.printf("%-15s|%-10s|%-5d\n", crList.get(i).getsName(),
                    crList.get(i).getcName(), crList.get(i).getTotalCourse());
        }
        System.out.println("");
    }
}
