package helper;

import java.sql.*;

/**Class that connects api to connect to database.*/
public abstract class JDBC {
    private static final String protocol = "jdbc";
    private static final String vendor = ":mysql:";
    private static final String location = "//localhost/";
    private static final String databaseName = "client_schedule";
    private static final String jdbcUrl = protocol + vendor + location + databaseName + "?connectionTimeZone = SERVER"; // LOCAL
    private static final String driver = "com.mysql.cj.jdbc.Driver"; // Driver reference
    private static final String userName = "sqlUser"; // Username
    private static String password = "Passw0rd!"; // Password
    public static Connection connection;  // Connection Interface

    /**Method that opens the connections to the database. */
    public static Connection openConnection()
    {
        try {
            Class.forName(driver); // Locate Driver
            connection = DriverManager.getConnection(jdbcUrl, userName, password); // Reference Connection object
            System.out.println("Connection successful!");
////////////////////////////////////////////////////////////////////////////
            /*Testing to see if database connection and query worked
            String sql = "CREATE TABLE david_and_chelsey"+
                    "(name varchar(10));";
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(sql);*/


        }
        catch(SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
            //System.out.println("Error:" + e.getMessage());
        }
        return connection;
    }

    /**Method that shows the status of the connection to the database.
     @return connection */
    //need to get the connection
    public static Connection getConnection(){

        return connection;
    }

    /**Method that closes the connection to the database. */
    public static void closeConnection() {
        try {
            connection.close();
            System.out.println("Connection closed!");

        }
        catch(Exception e)
        {
            e.printStackTrace();
            //System.out.println("Error:" + e.getMessage());
        }
    }

}
