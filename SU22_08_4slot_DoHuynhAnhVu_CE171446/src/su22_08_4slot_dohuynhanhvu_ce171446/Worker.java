package su22_08_4slot_dohuynhanhvu_ce171446;

/**
 *
 * @author Do Huynh Anh Vu - CE171446
 */
public class Worker {

//=========== THUOC TINH ============
    protected String ID;
    protected String Name;
    protected int Age;
    protected int Salary;
    protected String WorkPlace;

//========== KHOI TAO ===============

    public Worker() {
    }

    public Worker(String ID, String Name, int Age, int Salary, String WorkPlace) {
        this.ID = ID;
        this.Name = Name;
        this.Age = Age;
        this.Salary = Salary;
        this.WorkPlace = WorkPlace;
    }

//=========== GET & SET ============
    /**
     * get ID
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
     * get name
     * @return Name
     */
    public String getName() {
        return Name;
    }

    /**
     * sett new name
     * @param Name
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * get age
     * @return age
     */
    public int getAge() {
        return Age;
    }

    /**
     * set new age
     * @param Age
     */
    public void setAge(int Age) {
        this.Age = Age;
    }

    /**
     * get salary
     * @return salary
     */
    public int getSalary() {
        return Salary;
    }

    /**
     * set new salary
     * @param Salary
     */
    public void setSalary(int Salary) {
        this.Salary = Salary;
    }

    /**
     * get workplace
     * @return workplace
     */
    public String getWorkPlace() {
        return WorkPlace;
    }

    /**
     * set new workplace
     * @param WorkPlace
     */
    public void setWorkPlace(String WorkPlace) {
        this.WorkPlace = WorkPlace;
    }
}
