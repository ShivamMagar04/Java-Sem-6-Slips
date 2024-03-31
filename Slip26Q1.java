//delete details of emp1(eno, ename, sal) is already there
//accept id and delete details of emp

import java.io.*;
import java.sql.*;
import java.util.*;

public class Slip26Q1 {
  
  public static void main(String[] args) {
    
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    
    try {
    	
    	Class.forName("org.postgresql.Driver");
    	con = DriverManager.getConnection("jdbc:postgresql:slips", "postgres", "");
    	
    	if(con != null) {
    		
    		System.out.println("\nConnection Succesful");
    		
    		int eno = Integer.parseInt(args[0]);
    		
    		System.out.println("\nBefore Delete : ");
    		System.out.println("\nEno\tEname\tSalary");
    		
    		st = con.createStatement();
    		rs = st.executeQuery("select * from emp1");
    		
    		while(rs.next()) {
    		  System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3));
    		}
    		
    		ps = con.prepareStatement("delete from emp1 where eno = ?");
    		ps.setInt(1,eno);
    		ps.executeUpdate();
    		
    		System.out.println("\nAfter delete : ");
    		System.out.println("\nEno\tEname\tSalary");
    		
    		st = con.createStatement();
    		rs = st.executeQuery("select * from emp1");
    		
    		while(rs.next()) {
    		  System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3));
    		}
    		
    		con.close();
    		
    	} else 
    	    System.out.println("\nConnection Failed");
    } catch(Exception e) {}
  }
}
