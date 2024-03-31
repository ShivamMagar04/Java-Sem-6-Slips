//isert into emp(eno, ename, salary) table already created (emp1 is alrerady there)
//update
//display

import java.io.*;
import java.sql.*;
import java.util.*;

public class Slip22Q1 {
	
  public static void main(String[] args) {
		
	Connection con = null;
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement ps1 = null, ps2 = null;
	Scanner sc = new Scanner(System.in);
	int ch, eno, sal;
		
	  try {
			
		Class.forName("org.postgresql.Driver");
		con = DriverManager.getConnection("jdbc:postgresql:slips","postgres","");
			
		  if(con != null) {
		  
		  	System.out.println("\nConnection Succesful");	
		    do {
		  	
		  		
		  	System.out.println("\n1. Insert");
		  	System.out.println("2. Update");
		  	System.out.println("3. Display");
		  	System.out.println("0. Exit");
		  	System.out.print("Enter your choice : ");
		  	ch = sc.nextInt();
		  		
		  	switch(ch) {
		  			
		  	  case 1 :
		  	  	System.out.print("\nEnter Eno : ");
		  	  	eno = sc.nextInt();
		  	  	System.out.print("Enter Ename : ");
		  	  	String ename = sc.next();
		  	  	System.out.print("Enter Salary : ");
		  	  	sal = sc.nextInt();
		  	  	
		  	  	ps1 = con.prepareStatement("insert into emp1 values(?,?,?)");
		  	  	ps1.setInt(1,eno);
		  	  	ps1.setString(2,ename);
		  	  	ps1.setInt(3,sal);
		  	  	ps1.executeUpdate();
		  	  	
		  	  	break;
		  	  	
		  	  case 2 :
		  	  	System.out.print("\nEnter eno to update salary : ");
		  	  	eno = sc.nextInt();
		  	  	System.out.print("Enter new salary : ");
		  	  	sal = sc.nextInt();
		  	  	
		  	  	ps2 = con.prepareStatement("update emp1 set sal = ? where eno = ?");
		  	  	ps2.setInt(1,sal);
		  	  	ps2.setInt(2,eno);
		  	  	ps2.executeUpdate();
		  	  	
		  	  	break;
		  	  	
		  	  case 3 :
		  	  	st = con.createStatement();
		  	  	rs = st.executeQuery("select * from emp1");
		  	  	
		  	  	System.out.println("\nEno\tEname\tSalary");
		  	  	
		  	  	while(rs.next()) {
		  	  	  System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3));
		  	  	}
		  	  	
		  	  	break;
		  	}	
		  		
		      }while(ch != 0);
		      
		      con.close();
			
		  } else
		      System.out.println("\nConnection Failed");
	} catch(Exception e) {}
  }
}
