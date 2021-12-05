package helper;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DBQuery {

    private static Statement statement;

    //Create Statement Object
    public static void setStatement(Connection conn) throws SQLException {

       statement = conn.createStatement();
    }

    //Return Statement Object
    public static Statement getStatement(){

        return statement;
    }
}
