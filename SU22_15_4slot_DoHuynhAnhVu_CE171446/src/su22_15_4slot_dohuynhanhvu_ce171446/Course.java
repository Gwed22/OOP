package su22_15_4slot_dohuynhanhvu_ce171446;

/**
 *
 * @author Do Huynh Anh Vu - CE171446
 */
public class Course {

    //======= ATTRIBUTE ======/
    private String sName;
    private String cName;
    private int totalCourse;

    //========= CONSTRUCTOR =======/
    public Course() {
    }

    /**
     *
     * @param sName
     * @param cName
     * @param totalCourse
     */
    public Course(String sName, String cName, int totalCourse) {
        this.sName = sName;
        this.cName = cName;
        this.totalCourse = totalCourse;
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
     *
     * @param sName
     */
    public void setsName(String sName) {
        this.sName = sName;
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
     *
     * @param cName
     */
    public void setcName(String cName) {
        this.cName = cName;
    }

    /**
     *
     * @return total course
     */
    public int getTotalCourse() {
        return totalCourse;
    }

    /**
     * set new total course
     *
     * @param totalCourse
     */
    public void setTotalCourse(int totalCourse) {
        this.totalCourse = totalCourse;
    }
}
