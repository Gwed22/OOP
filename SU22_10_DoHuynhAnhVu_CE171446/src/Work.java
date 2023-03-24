
/**
 *
 * @author Do Huynh Anh Vu   -   CE171446
 */

public class Work {

    //========= ATTRIBUTES =========
    
    protected int ID;
    protected String TaskTypeID;
    protected String RequirementName;
    protected String date;
    protected String planF;
    protected String planT;
    protected String Assigner;
    protected String Reviewer;

    //========= CONSTRUCTOR ============
    
    public Work() {
    }

    public Work(int ID, String TaskTypeID, String RequirementName, String date, String planF, String planT, String Assigner, String Reviewer) {
        this.ID = ID;
        this.TaskTypeID = TaskTypeID;
        this.RequirementName = RequirementName;
        this.date = date;
        this.planF = planF;
        this.planT = planT;
        this.Assigner = Assigner;
        this.Reviewer = Reviewer;
    }

    //======= GET & SET ========
    /**
     * get ID
     * @return ID
     */
    public int getID() {
        return ID;
    }

    /**
     * set new ID
     * @param ID
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * get Task Type ID
     * @return TaskTypeID
     */
    public String getTaskTypeID() {
        return TaskTypeID;
    }

    /**
     * set new Task Type ID
     * @param TaskTypeID
     */
    public void setTaskTypeID(String TaskTypeID) {
        this.TaskTypeID = TaskTypeID;
    }

    /**
     * get Requirement Name
     * @return Requirement Name
     */
    public String getRequirementName() {
        return RequirementName;
    }

    /**
     * set new Requirement Name
     * @param RequirementName
     */
    public void setRequirementName(String RequirementName) {
        this.RequirementName = RequirementName;
    }

    /**
     * get Date
     * @return Date
     */
    public String getDate() {
        return date;
    }

    /**
     * set Date
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * get plan from
     * @return plan from
     */
    public String getPlanF() {
        return planF;
    }

    /**
     * set new plan from
     * @param planF
     */
    public void setPlanF(String planF) {
        this.planF = planF;
    }

    /**
     * get plan to
     * @return plan to
     */
    public String getPlanT() {
        return planT;
    }

    /**
     * set new plan to
     * @param planT
     */
    public void setPlanT(String planT) {
        this.planT = planT;
    }

    /**
     * get Assigner
     * @return Assigner
     */
    public String getAssigner() {
        return Assigner;
    }

    /**
     * set new Assigner
     * @param Assigner
     */
    public void setAssigner(String Assigner) {
        this.Assigner = Assigner;
    }

    /**
     * get Reviewer
     * @return Reviewer
     */
    public String getReviewer() {
        return Reviewer;
    }

    /**
     * set new Reviewer
     * @param Reviewer
     */
    public void setReviewer(String Reviewer) {
        this.Reviewer = Reviewer;
    }
}
