package model;

/**Class that defines objects and variables for countries.*/
public class Countries {

    int countryId;
    String countryName;


    /**Method creates a country object.
     @param countryId
     @param countryName */
    public Countries(int countryId, String countryName){

        this.countryId = countryId;
        this.countryName = countryName;
    }


    /**Method retrieves countryId.
     @return countryId */
//getter for countryId
    public int getCountryId() {
        return countryId;
    }

    /**Method retrieves countryName.
     @return  countryName */
//getter for countryName
    public String getCountryName() {
        return countryName;
    }
}
