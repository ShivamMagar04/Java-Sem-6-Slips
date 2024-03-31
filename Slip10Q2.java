//display first record of student using swing
//student table is already created

import java.io.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Slip10Q2 extends JFrame implements ActionListener{

	Label l1,l2,l3;
	TextField t1,t2,t3;
	Button btn;
	
	public Slip10Q2() {
		
		setTitle("Java AWT");
		
		l1 = new Label("Roll NO : ");
		t1 = new TextField(3);
		add(l1);
		add(t1);
		
		l2 = new Label("Name : ");
		t2 = new TextField(20);
		add(l2);
		add(t2);
		
		l3 = new Label("Percentage : ");
		t3 = new TextField(4);
		add(l3);
		add(t3);
		
		btn = new Button("Display");
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
		
		try {
			
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql:slips","postgres","");
			
			if(con != null) {
				
				st = con.createStatement();
				rs = st.executeQuery("select * from student");
				
				while(rs.next()) {
					
					t1.setText(String.valueOf(rs.getInt(1)));
					t2.setText(rs.getString(2));
					t3.setText(String.valueOf(rs.getInt(3)));
					break;
				}
			}
			con.close();
		
		}catch(Exception ex) {}
	}
	
	public static void main(String[] args) {
		
		new Slip10Q2();
	}
}
