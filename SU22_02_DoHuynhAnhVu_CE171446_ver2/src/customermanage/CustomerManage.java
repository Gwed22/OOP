package customermanage;

/**
 *
 * @author Do Huynh Anh Vu - CE171446
 */
public class CustomerManage {

    // ===================== THUOC TINH =================
    private int ID;
    private String Name;
    private String Email;
    private String PN;
    private String Address;

    // ====================== KHOI TAO ==================
    public CustomerManage() {
    }

    public CustomerManage(int ID, String Name, String Email, String PN, String Address) {
        this.ID = ID;
        this.Name = Name;
        this.Email = Email;
        this.PN = PN;
        this.Address = Address;
    }

    // ================= GET & SET & toString ==========
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPN() {
        return PN;
    }

    public void setPN(String PN) {
        this.PN = PN;
    }

    @Override
    public String toString() {
        return "CustomerManage{" + "ID=" + ID + ", Name=" + Name + ", Email=" + Email + ", PN=" + PN + ", Address=" + Address + '}';
    }

}
