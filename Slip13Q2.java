//display lifecycle of thread and name of thread should be hardcoded

public class Slip13Q2 extends Thread {

    String tName;
    
    public Slip13Q2(String tname) {
        this.tName = tname;
    }

    public void run() {
        System.out.println("Thread " + tName + " is created.");

        int sleepTime = (int) (Math.random() * 5000);

        try{
            Thread.sleep(sleepTime);
            System.out.println("Thread " + tName + " sleeped for " + sleepTime + " ms");
        } catch (Exception e) {}

        System.out.println("Thread " + tName + " terminated");
    }
    public static void main(String[] args) {

        Slip13Q2 t1 = new Slip13Q2("Thread-1");
        Slip13Q2 t2 = new Slip13Q2("Thread-2");
        Slip13Q2 t3 = new Slip13Q2("Thread-3");
        t1.start();
        t2.start();
        t3.start();
    }
}