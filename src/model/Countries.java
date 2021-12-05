package model;

public class Countries {

    int countryId;
    String countryName;


    public Countries(int countryId, String countryName){

        this.countryId = countryId;
        this.countryName = countryName;
    }


//getter for countryId
    public int getCountryId() {
        return countryId;
    }

//getter for countryName
    public String getCountryName() {
        return countryName;
    }
}
