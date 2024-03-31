//accept details from user and store it into database (using swing)

import java.util.*;
import java.io.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Slip1Q2 extends JFrame implements ActionListener{
	
	JTextField t1,t2,t3,t4;
	JLabel l1,l2,l3,l4;
	JButton btn;
	
	public Slip1Q2() {
		
		setTitle("JDBS using Swing");
		
		l1 = new JLabel("Enter eno : ");
		t1 = new JTextField(5);
		add(l1);
		add(t1);
		
		l2 = new JLabel("Enter ename : ");
		t2 = new JTextField(20);
		add(l2);
		add(t2);
		
		l3 = new JLabel("Enter designation : ");
		t3 = new JTextField(20);
		add(l3);
		add(t3);
		
		l4 = new JLabel("Enter salary : ");
		t4 = new JTextField(8);
		add(l4);
		add(t4);
		
		btn = new JButton("Insert");
		btn.addActionListener(this);
		add(btn);
		
		setSize(300,300);
		setLayout(new FlowLayout());
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql:slips","postgres","");
			
			if(con != null) {
				
				int eno = Integer.parseInt(t1.getText());
				String ename = t2.getText();
				String desg = t3.getText();
				int sal = Integer.parseInt(t4.getText());
				
				ps = con.prepareStatement("insert into Emp values(?,?,?,?)");
				
				ps.setInt(1,eno);
				ps.setString(2,ename);
				ps.setString(3,desg);
				ps.setInt(4,sal);
				ps.executeUpdate();
				
				System.out.println("\nData Inserted Succefully!");
				
				st = con.createStatement();
				rs = st.executeQuery("select * from Emp");
				
				System.out.println("\nEno \t Ename \t Desg \t Salary");
				
				while(rs.next()) {
					
					System.out.println(rs.getInt(1) + "\t" + 
					rs.getString(2) + "\t" + rs.getString(3)
					+ "\t" + rs.getInt(4));
				}
			}
			else 
			  System.out.println("Connection Failed");
			
		} catch (Exception ex) {}
	}
	
	public static void main(String[] args) {
		
		new Slip1Q2();
	}
}
