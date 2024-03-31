//accept details of teacher(tno, tname, sub)
//insert 5 records into teacher table 
//display teacher who is teaching java subject
//assume table is already created

import java.util.*;
import java.sql.*;
import java.io.*;

public class Slip16Q2 {
	
   public static void main(String[] args) {
		
	Connection con = null;
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement ps = null;
	Scanner sc = new Scanner(System.in);
		
	try {
			
		Class.forName("org.postgresql.Driver");
		con = DriverManager.getConnection("jdbc:postgresql:slips","postgres",""); 
		int ch = -1;
			
		if(con != null) {
				
		  System.out.println("\nConnection Succesful");	
				
		  do {
				
			System.out.println("\n1. Insert values");
			System.out.println("2. Display teacher info who teaching JAVA");
			System.out.println("3. Display table");
			System.out.println("0. Exit");
			System.out.print("Enter your choice : ");
			ch = sc.nextInt();
				
			switch(ch) {
					
			  case 1 : 
				System.out.print("\nEnter Tno : ");
				int tno = sc.nextInt();
				System.out.print("Enter Tname : ");
				String tname = sc.next();
				System.out.print("Enter sub : ");
				String sub = sc.next();
				  	  
				ps = con.prepareStatement("insert into teacher values(?,?,?)");
				ps.setInt(1,tno);
				ps.setString(2,tname);
				ps.setString(3,sub);
				ps.executeUpdate();
				  	  
				break;
				  	  
			  case 2 :
				st = con.createStatement();
				rs = st.executeQuery("select * from teacher where sub = 'java'");
				System.out.println("\nTno\tTname\tSub");

				while(rs.next()) {
				  System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
				}
				  	  
				break;
				  	  
			  case 3 :
				st = con.createStatement();
				rs = st.executeQuery("select * from teacher");
				  	  
				System.out.println("\nTno\tTname\tSub");

				while(rs.next()) {
				  System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
				 }
				  	  
				 break;
			}
			
		}while(ch != 0);
			
		con.close();
			
	  } else 
		System.out.println("Connection Failed!");
	}catch(Exception e) {}
  }
}
