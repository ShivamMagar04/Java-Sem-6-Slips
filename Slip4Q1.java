//use runnable interface to blick text on JFrame

import java.awt.*;
import javax.swing.*;

class BlinkingText extends JFrame implements Runnable {

    JLabel label;

    public BlinkingText() {

        setTitle("Blinking Text Example");

        label = new JLabel("Blink");
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

            while(true) {
                if(label.isVisible()) 
                    label.setVisible(false);
                else 
                    label.setVisible(true);
                Thread.sleep(500);
            }
        }catch(Exception e) {}
    }
}

public class Slip4Q1 {
    public static void main(String[] args) {
        new BlinkingText();
    }
}