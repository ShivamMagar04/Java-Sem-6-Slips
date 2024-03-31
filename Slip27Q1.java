//display info of college(cid, cname, addr, year)
//college is already there
//display using swing JTable

import java.io.*;
import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;

public class Slip27Q1 extends JFrame implements ActionListener {

  JButton btn;
  JTable table;
  DefaultTableModel model;
  
  public Slip27Q1() {
  	
  	setTitle("Display Table");
  	
  	btn = new JButton("Display");
  	btn.addActionListener(this);
  	
  	JPanel panel = new JPanel();
  	panel.add(btn);
  	
  	add(panel, BorderLayout.NORTH);
  	
  	setSize(400,300);
  	setVisible(true);
  	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  public void actionPerformed(ActionEvent e) {
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;

    try {
    
        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection("jdbc:postgresql:slips", "postgres", "");

        String[] clmName = {"Cid", "Cname", "Address", "Year"};
        ArrayList<Object[]> data = new ArrayList<>();
        st = con.createStatement();
        rs = st.executeQuery("select * from college");

        while(rs.next()) {
            Object[] row = {rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)};
            data.add(row);
        }

        Object[][] tData = new Object[data.size()][];
        for(int i=0; i<data.size(); i++)
            tData[i] = data.get(i);

        model = new DefaultTableModel(tData, clmName);
        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        this.getContentPane().add(scrollPane, BorderLayout.CENTER); // Ensure it's added to the content pane

        revalidate();

        st.close();
        rs.close();
        con.close();
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}

  public static void main(String[] args) {
  	
  	new Slip27Q1();
  }
}
