//displa 'A' to 'Z' in 2 sec delay using multithreading

class DisplayAtoZ extends Thread {

    public void run() {

        try {
            for(char i='A'; i<='Z'; i++) {
                System.out.println(i);
                Thread.sleep(2000);
            }
        }catch(Exception e) {}
    }
}

public class Slip1Q1 {
    public static void main(String[] args) {
        DisplayAtoZ obj = new DisplayAtoZ();
        obj.start();
    }
}