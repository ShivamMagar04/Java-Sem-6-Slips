//create produt(pid, pname, price) table
//insert records
//display table

import java.io.*;
import java.sql.*;
import java.util.*;

public class Slip7Q2 {
	
  public static void main(String[] args) {
		
	Connection con = null;
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement ps1 = null, ps2 = null, ps3 = null;
	int ch = -1;
	Scanner sc = new Scanner(System.in);
		
	try {
			
		Class.forName("org.postgresql.Driver");
		con = DriverManager.getConnection("jdbc:postgresql:slips","postgres","");
			
		if(con != null) {
				
		  System.out.println("\nConnection Succesful!");
		  System.out.println("\nIf table is already created first drop or dont click 1.");
			    
		  do{
			    
			System.out.println("\n1. Create table");
			System.out.println("2. Inset values");
			System.out.println("3. Display table");
			System.out.println("4. Drop table");
			System.out.println("0. Exit");
			System.out.print("Enter your choice : ");
			ch = sc.nextInt();
				
			switch(ch) {
					
			  case 1 : 
				ps1 = con.prepareStatement("create table product(pid int primary key, pname varchar, price int)");
				ps1.executeUpdate();
				System.out.println("\nTable created succesfully");
				break;
						
			  case 2 : 
				System.out.print("Enter pno : ");
				int pno = sc.nextInt();
				System.out.print("Enter pname : ");
				String name = sc.next();
				System.out.print("Enter price : ");
				int price = sc.nextInt();
						
				ps2 = con.prepareStatement("insert into product values(?,?,?)");
				ps2.setInt(1,pno);
				ps2.setString(2,name);
				ps2.setInt(3,price);
				ps2.executeUpdate();
						
				System.out.println("\nValue inserted!");
				break;
						
			  case 3 :
				st = con.createStatement();
				rs = st.executeQuery("select * from product");
						
				System.out.println("\nPno\tPname\tPrice");
						
				while(rs.next()) {
							
				  System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3));
				}
				break;
						
			  case 4 : 
				ps3 = con.prepareStatement("drop table product");
				ps3.executeUpdate();
				System.out.println("\nTable deleted!");
				break;
				
			}
			    
		  }while(ch != 0);
			    
		} else 
			    System.out.println("Connection Failed!");
	} catch (Exception e ) {}
  }
}
