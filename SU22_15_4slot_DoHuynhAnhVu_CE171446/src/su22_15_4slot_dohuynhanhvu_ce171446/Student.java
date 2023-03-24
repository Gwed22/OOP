package su22_15_4slot_dohuynhanhvu_ce171446;

/**
 *
 * @author Do Huynh Anh Vu - CE171446
 */
public class Student implements Comparable<Student> {

    //======== ATTRIBUTE ========//

    protected String ID;
    protected String sName;
    protected String semester;
    protected String cName;

    //======= CONSTRUCTOR =======//

    /**
     *
     * @param ID
     * @param sName
     * @param semester
     * @param cName
     */
    public Student(String ID, String sName, String semester, String cName) {
        this.ID = ID;
        this.sName = sName;
        this.semester = semester;
        this.cName = cName;
    }

    public Student() {
    }

    //======= GET & SET ======//

    /**
     *
     * @return student ID
     */
    public String getID() {
        return ID;
    }

    /**
     * set new student ID
     * @param ID
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * 
     * @return student name
     */
    public String getsName() {
        return sName;
    }

    /**
     * set new student name
     * @param sName
     */
    public void setsName(String sName) {
        this.sName = sName;
    }

    /**
     *
     * @return semester
     */
    public String getSemester() {
        return semester;
    }

    /**
     * set new semester
     * @param semester
     */
    public void setSemester(String semester) {
        this.semester = semester;
    }

    /**
     *
     * @return course name
     */
    public String getcName() {
        return cName;
    }

    /**
     * set new course name
     * @param cName
     */
    public void setcName(String cName) {
        this.cName = cName;
    }

    @Override
    public int compareTo(Student t) {
        return sName.compareTo(t.getsName());
    }

    /**
     * Display student object formated when call
     */
    public void display() {
        System.out.printf("%-15s%-15s%-15s\n", sName, semester, cName);
    }
}
