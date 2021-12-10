package model;

public class FirstLevelDivisions {
    int divisionId;
    String division;

    public FirstLevelDivisions(int divisionId, String division){

        this.divisionId = divisionId;
        this.division = division;
    }

    public int getDivisionId() {
        return divisionId;
    }

    public String getDivision() {
        return division;
    }

    //Overrides the default toString() method that java uses on the combo box
    @Override
    public String toString(){
        return((/*"#" + Integer.toString(divisionId) + " " + */division));
    }


}
