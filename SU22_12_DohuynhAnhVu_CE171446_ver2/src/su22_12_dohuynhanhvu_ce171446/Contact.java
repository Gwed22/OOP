package su22_12_dohuynhanhvu_ce171446;

/**
 *
 * @author Do Huynh Anh Vu - CE171446
 */
public class Contact {

    //========= ATTRIBUTE ===========//

    protected int ID;
    protected String Name;
    protected String Group;
    protected String Address;
    protected String PN;

    //========== CONSTRUCTOR =========//

    public Contact() {
    }

    /**
     *
     * @param ID
     * @param Name
     * @param Group
     * @param Address
     * @param PN
     */
    public Contact(int ID, String Name, String Group, String Address, String PN) {
        this.ID = ID;
        this.Name = Name;
        this.Group = Group;
        this.Address = Address;
        this.PN = PN;
    }

    //========= GET & SET ===========//

    /**
     * 
     * @return ID of object
     */
    public int getID() {
        return ID;
    }

    /**
     * set ID to object
     * @param ID
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * 
     * @return name of object
     */
    public String getName() {
        return Name;
    }

    /**
     * set name to object
     * @param Name
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     *
     * @return group of object
     */
    public String getGroup() {
        return Group;
    }

    /**
     * set group to object
     * @param Group
     */
    public void setGroup(String Group) {
        this.Group = Group;
    }

    /**
     * 
     * @return address of object
     */
    public String getAddress() {
        return Address;
    }

    /**
     * set address to object
     * @param Address
     */
    public void setAddress(String Address) {
        this.Address = Address;
    }

    /**
     *
     * @return phone number of object
     */
    public String getPN() {
        return PN;
    }

    /**
     * set phone number to object
     * @param PN
     */
    public void setPN(String PN) {
        this.PN = PN;
    }

}
