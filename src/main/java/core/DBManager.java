package core;

import java.sql.*;

public class DBManager {
    // Connection object
    public static Connection con;

    public static boolean connectionManager() throws ClassNotFoundException, SQLException {
        boolean db_connected = false;
        try {
            //String dbUrl = "jdbc:mysql://colins-macbook-pro.local:3036/qa_test";
            String dbUrl = "jdbc:mysql://localhost:3306/qa_test";

            //Database Username
            String username = "root";

            //Database Password
            String password = "";

            //Load mysql jdbc driver
            Class.forName("com.mysql.jdbc.Driver");

            //Create Connection to DB
            con = DriverManager.getConnection(dbUrl, username, password);
            System.out.println("Successfully Connected to the database!");
            db_connected = true;
        }
        catch (Exception e ){
            e.printStackTrace();
            System.out.println("Could not find the database driver " + e.getMessage());
        }
        return db_connected;

        //Create Statement Object




    }
    public static ResultSet executeQueries (String query) throws SQLException, ClassNotFoundException {
        ResultSet rs = null;
        boolean dbStatus =  connectionManager();
        if(dbStatus) {
            Statement stmt = con.createStatement();

            // Execute the SQL Query. Store results in ResultSet
            rs = stmt.executeQuery(query);
        }
        return  rs;


    }

}
