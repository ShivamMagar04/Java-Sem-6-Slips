//display info of columns 
//use ResultSetMetaData
//instead of donor i used student table

import java.util.*;
import java.io.*;
import java.sql.*;

public class Slip11Q2 {
	
  public static void main(String[] args) {
		
	Connection con = null;
	Statement st = null;
	ResultSet rs = null;
		
	try {
			
		Class.forName("org.postgresql.Driver");
		con = DriverManager.getConnection("jdbc:postgresql:slips","postgres","");
			
		if(con != null) {
				
			st = con.createStatement();
			rs = st.executeQuery("select * from student");
				
			ResultSetMetaData rsmd = rs.getMetaData();
				
			int col = rsmd.getColumnCount();
			System.out.println("Total number of colmns : " + col);
				
			for(int i=1; i<= col; i++) {
					
			  System.out.println("\nColumn Number : " + i);
			  System.out.println("Column Name : " + rsmd.getColumnName(i));
			  System.out.println("Column Type : " + rsmd.getColumnTypeName(i));
			  System.out.println("Column Size : " + rsmd.getColumnDisplaySize(i));
			}
		}
	}catch(Exception e) {}
  }
}
