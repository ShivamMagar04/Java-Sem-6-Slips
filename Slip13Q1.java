//display info about database
//use DatabaseMetaData

import java.util.*;
import java.io.*;
import java.sql.*;

public class Slip13Q1 {
    
    public static void main(String[] args) {
        
        Connection con = null;
        
        try {
          
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql:slips", "postgres", "");
            
            if (con != null) {
               
                DatabaseMetaData metaData = con.getMetaData();
                
                System.out.println("Database Product Name: " + metaData.getDatabaseProductName());
                System.out.println("Database Product Version: " + metaData.getDatabaseProductVersion());
                System.out.println("Driver Name: " + metaData.getDriverName());
                System.out.println("Driver Version: " + metaData.getDriverVersion());
                System.out.println("URL: " + metaData.getURL());
                System.out.println("Username: " + metaData.getUserName());
            } else 
                System.out.println("Failed to connect to the database.");
                
            con.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
}

