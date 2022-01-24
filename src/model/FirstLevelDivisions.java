package model;

/**Class that defines objects and variable for first level divisions.*/
public class FirstLevelDivisions {
    int divisionId;
    String division;

    /**Method creates a first level division object.
     @param divisionId
     @param division */
    public FirstLevelDivisions(int divisionId, String division){

        this.divisionId = divisionId;
        this.division = division;
    }

    /**Method retrieves divisionId.
     @return divisionId */
    public int getDivisionId() {
        return divisionId;
    }

    /**Method retrieves division.
     @return division */
    public String getDivision() {
        return division;
    }

    /**Method converts division object to string.
     @return division */
    //Overrides the default toString() method that java uses on the combo box
    @Override
    public String toString(){
        return((/*"#" + Integer.toString(divisionId) + " " + */division));
    }


}
