package su22_04_dohuynhanhvu_ce171446;

/**
 * @author Do Huynh Anh Vu CE171446
 */
public class Country {

    //========== THUOC TINH ===========
    protected String countryCode;
    protected String countryName;
    protected float totalArea;

    //========== KHOI TAO ==============
    /**
     * @param countryCode
     * @param countryName
     * @param totalArea
     */
    public Country(String countryCode, String countryName, float totalArea) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.totalArea = totalArea;
    }

    Country() {
    }

    //=========== GET & SET & toString ============
    /**
     *
     * @return countryCode
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     *
     * @param get countryCode
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    /**
     *
     * @return CountryName
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     *
     * @param set countryName
     */
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    /**
     *
     * @return Total Area
     */
    public float getTotalArea() {
        return totalArea;
    }

    /**
     *
     * @param set totalArea
     */
    public void setTotalArea(float totalArea) {
        this.totalArea = totalArea;
    }

    @Override
    public String toString() {
        return "Country{" + "countryCode=" + countryCode + ", countryName=" + countryName + ", totalArea=" + totalArea + '}';
    }

}
