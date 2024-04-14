//use multithreading to display the numbers between 1 to 100 continuously
//in a JTextFiled by clicking on JButton (use Runnable interface and swing)

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Slip17Q2 extends JFrame implements ActionListener, Runnable{
    
    JTextField t1;
    JButton btn;

    public Slip17Q2() {

        setTitle("MultiThreading");

        t1 = new JTextField(5);
        add(t1);

        btn = new JButton("Display");
        btn.addActionListener(this);
        add(btn);

        setSize(300,300);
        setVisible(true);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {

        Thread thread = new Thread(this);
        thread.start();

    }

    public void run() {
        try{
            for(int i=1; i<=100; i++) {
                t1.setText(String.valueOf(i));
                Thread.sleep(500);
                t1.setText("");
            }

        }catch(Exception e) {}
    }
    public static void main(String[] args) {
        new Slip17Q2();
    }
}