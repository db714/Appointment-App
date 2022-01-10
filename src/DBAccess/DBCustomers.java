package DBAccess;

import helper.JDBC;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Customers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBCustomers {


    //adds all customers to an observable list
    public static ObservableList<Customers> getAllCustomers(){

        ObservableList<Customers> custList = FXCollections.observableArrayList();

        try{

            String sql =
                    "SELECT Customer_ID, Customer_Name, countries.Country, first_level_divisions.Division, Address, Postal_Code, Phone\n" +
                    "FROM customers, first_level_divisions, countries\n" +
                    "WHERE customers.Division_ID = first_level_divisions.Division_ID AND first_level_divisions.COUNTRY_ID = countries.Country_ID";

            PreparedStatement ps = JDBC.getConnection().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                int custId = rs.getInt("Customer_ID");
                String custName = rs.getString("Customer_Name");
                String custAddress = rs.getString("Address");
                String postCode = rs.getString("Postal_Code");
                String phoneNum = rs.getString("Phone");
                String custDiv = rs.getString("Division");
                String custCntry = rs.getString("Country");



                Customers c = new Customers(custId, custName, custAddress, postCode, phoneNum, custDiv, custCntry);
                custList.add(c);
                System.out.println(custDiv);
                System.out.println(custCntry);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }


        return custList;
    }

    //create a customer
    public static void createCustomer(int custId, String custName, String custAddress, String postCode, String phoneNum, int custDiv){
        try{
        String sqlCC = "INSERT INTO customers VALUES(NULL, ?, ?, ?, ?, NULL, NULL, CURRENT_TIMESTAMP , NULL, ?);";

        PreparedStatement psCC = JDBC.getConnection().prepareStatement(sqlCC);

        psCC.setString(1, custName);
        psCC.setString(2, custAddress);
        psCC.setString(3, postCode);
        psCC.setString(4, phoneNum);
        psCC.setInt(5, custDiv);

        psCC.execute();







    }

        catch(SQLException e){
            e.printStackTrace();}
    }
    //modify a customer
    public static void modifyCustomer(int custId, String custName, String custAddress, String postCode, String phoneNum, int custDiv){

        try{

            String sqlMC = "UPDATE customers SET Customer_Name = ?, Address = ?, Postal_Code = ?, Phone = ?, Division_ID = ? WHERE Customer_ID = ?;";

            PreparedStatement psMC = JDBC.getConnection().prepareStatement(sqlMC);

            psMC.setString(1, custName);
            psMC.setString(2, custAddress);
            psMC.setString(3, postCode);
            psMC.setString(4, phoneNum);
            psMC.setInt(5, custDiv);
            psMC.setInt(6, custId);

            psMC.execute();
        }


        catch (SQLException e){
            e.printStackTrace();
        }

    }

    //delete a customer
    public static void deleteCustomer(int custId, String custName, String custAddress, String postCode, String phoneNum){

                //when this method is written, you only need to take a customer id.
                //from there you can write a query that finds all of the customers appointments
                //you can then create a while loop with the 'rs.next' paramenter that cycles through...
                //all of the appointments with the given customer id and call the delete appointment method
                //at that point you can delete the customer from the database.
    }
}
