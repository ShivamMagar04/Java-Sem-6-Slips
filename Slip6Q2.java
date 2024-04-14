//using multithreading to simulate traffic signal

import java.awt.*;
import javax.swing.*;

public class Slip6Q2 extends JFrame implements Runnable {

    JLabel label;
    String[] signals = {"RED", "YELLOW", "GREEN"};
    int index = 0;

    public Slip6Q2() {

        setTitle("Traffic Signal");

        label = new JLabel(signals[0], JLabel.CENTER);
        add(label);

        setSize(300,300);
        setVisible(true);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Thread thread = new Thread(this);
        thread.start();
    }

    public void run() {

        try{

                while (true) {
                    updateIndex();
                    Thread.sleep(2000);
                }

        }catch(Exception e) {}
    }

    public void updateIndex() {
        index = (index + 1) % signals.length;
        label.setText(signals[index]);
        switch (index) {
            case 0:
                label.setForeground(Color.RED);
                break;
            case 1:
                label.setForeground(Color.YELLOW);
                break;
            case 2:
                label.setForeground(Color.GREEN);
                break;
        }
    }
    
    public static void main(String[] args) {
        new Slip6Q2();
    }
}