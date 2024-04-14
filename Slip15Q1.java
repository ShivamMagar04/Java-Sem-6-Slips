//display name and priority of a thread

class PriorityDemo extends Thread {

    public void run() {
        System.out.println("Current thread name is : " + Thread.currentThread().getName() +
         "\nCurrent thread priority is : " + Thread.currentThread().getPriority());
    }
}

public class Slip15Q1 {
    public static void main(String[] args) {
        PriorityDemo t1 = new PriorityDemo();
        PriorityDemo t2 = new PriorityDemo();
        t1.setPriority(10);
        t2.setPriority(1);
        t1.start();
        t2.start();
    }
}