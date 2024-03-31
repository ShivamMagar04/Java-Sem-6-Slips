//create product table
//insert values
//display table data in table format using swing

import java.io.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;

public class Slip12Q2 extends JFrame implements ActionListener {

    JButton btnCreate, btnInsert, btnDisplay;
    JLabel l1;
    JTable table;
    DefaultTableModel model;

    public Slip12Q2() {

        setTitle("Java Swing");

        btnCreate = new JButton("Create Table");
        btnInsert = new JButton("Insert Values");
        btnDisplay = new JButton("Display Table");
        l1 = new JLabel();

        btnCreate.addActionListener(this);
        btnInsert.addActionListener(this);
        btnDisplay.addActionListener(this);

        JPanel panel = new JPanel();
        panel.add(btnCreate);
        panel.add(btnInsert);
        panel.add(btnDisplay);

        add(panel, BorderLayout.NORTH);
        add(l1, BorderLayout.CENTER);

        setSize(400, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent e) {

    	Object source = e.getSource();

    	Connection con = null;
    	Statement st = null;
    	ResultSet rs = null;
    	PreparedStatement ps = null, ps1 = null, ps2 = null;

    	try {
        		Class.forName("org.postgresql.Driver");
        		con = DriverManager.getConnection("jdbc:postgresql:slips", "postgres", "");

        		if (source == btnCreate) {

            	ps = con.prepareStatement("create table product1(pno int primary key, pname varchar, pdes varchar, pstatus varchar)");
            	ps.executeUpdate();
            	l1.setText("Table Created");

        		} else if (source == btnInsert) {

            		int pid = Integer.parseInt(JOptionPane.showInputDialog("Enter pid : "));
            		String pname = JOptionPane.showInputDialog("Enter pname : ");
            		String des = JOptionPane.showInputDialog("Enter description : ");
            		String status = JOptionPane.showInputDialog("Enter status : ");

            		ps1 = con.prepareStatement("insert into product1 values(?,?,?,?)");
            		ps1.setInt(1, pid);
            		ps1.setString(2, pname);
            		ps1.setString(3, des);
            		ps1.setString(4, status);
            		ps1.executeUpdate();

            		l1.setText("Value inserted");

        		} else if (source == btnDisplay) {

            		st = con.createStatement();
    			rs = st.executeQuery("select * from product1"); // Corrected table name

    			String[] clmName = {"PNO", "PName", "PDescription", "PStatus"};
    			ArrayList<Object[]> data = new ArrayList<>();

    			while (rs.next()) {
        			  Object[] row = {rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)};
      			  data.add(row);
    			}

    			Object[][] tdata = new Object[data.size()][];
    			for (int i = 0; i < data.size(); i++)
        				tdata[i] = data.get(i);

    			model = new DefaultTableModel(tdata, clmName);
    			table = new JTable(model);

    			// Add table to a JScrollPane and display
    			JScrollPane scrollPane = new JScrollPane(table);
    			add(scrollPane, BorderLayout.SOUTH);
    			revalidate(); // Refresh the frame to show the table
            
    			ps2 = con.prepareStatement("drop table product1");
    			ps2.executeUpdate();
        	}

    	} catch (Exception ex) {
        		ex.printStackTrace();
        		// Display error message to the user
        		JOptionPane.showMessageDialog(this, "An error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    	} finally {
        		// Close resources in a finally block
        		// Note: This is simplified for demonstration. You may need to close more resources in a real application.
        		try {
            		if (con != null) con.close();
            		if (st != null) st.close();
            		if (rs != null) rs.close();
            		if (ps != null) ps.close();
            		if (ps1 != null) ps1.close();
        		} catch (SQLException ex) {
            		ex.printStackTrace();
        }
    }
}


    public static void main(String[] args) {
        new Slip12Q2();
    }
}

