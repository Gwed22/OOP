package su22_04_dohuynhanhvu_ce171446;

/**
 * @author Do Huynh Anh Vu CE171446
 */
public class EastAsiaCountries extends Country {

    private String countryTerrain;

    /**
     *
     * @param countryCode
     * @param countryName
     * @param totalArea
     * @param countryTerrain
     */
    public EastAsiaCountries(String countryCode, String countryName, float totalArea, String countryTerrain) {
        super(countryCode, countryName, totalArea);  //goi ham khoi tao tu lop cha
        this.countryTerrain = countryTerrain;
    }

    EastAsiaCountries() {
    }

    /**
     *
     * @return countryTerrain
     */
    public String getCountryTerrain() {
        return countryTerrain;
    }

    /**
     *
     * @param set countryTerrain
     */
    public void setCountryTerrain(String countryTerrain) {
        this.countryTerrain = countryTerrain;
    }

    @Override
    public String toString() {
        System.out.printf("%-14s %-14s %-18.2f %-14s\n", countryCode, countryName, totalArea, countryTerrain);  // Hien thi theo format
        return "\n";
    }
}
