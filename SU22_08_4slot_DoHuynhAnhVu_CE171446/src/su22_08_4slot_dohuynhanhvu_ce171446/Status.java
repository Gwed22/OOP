package su22_08_4slot_dohuynhanhvu_ce171446;

/**
 * @author Do Huynh Anh Vu - CE171446
 */
public class Status extends Worker implements Comparable<Status> {

    //============== THUOC TINH ===============

    protected String Status;
    protected String Date;

    //============== KHOI TAO ================

    public Status() {
    }

    public Status(String ID, String Name, int Age, int Salary, String WorkPlace, String Status, String Date) {
        super(ID, Name, Age, Salary, WorkPlace);
        this.Status = Status;
        this.Date = Date;
    }

    //============ GET & SET ===========

    /**
     * get status
     * @return status
     */
    public String getStatus() {
        return Status;
    }

    /**
     * set new status
     * @param Status
     */
    public void setStatus(String Status) {
        this.Status = Status;
    }

    /**
     * get date
     * @return date
     */
    public String getDate() {
        return Date;
    }

    /**
     * set new date
     * @param Date
     */
    public void setDate(String Date) {
        this.Date = Date;
    }

    /*
    * Comparator to sort array list by ID
    */
    @Override
    public int compareTo(Status st) {
        return this.getID().compareTo(st.getID());
    }
}
