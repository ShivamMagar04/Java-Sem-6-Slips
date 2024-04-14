//display name of currently executing thread

public class Slip28Q2 extends Thread {

    public void run() {
        System.out.println("\nCurrently executing thread name is : " + Thread.currentThread().getName());
    }
    public static void main(String[] args) {
        Slip28Q2 t1 = new Slip28Q2();
        Slip28Q2 t2 = new Slip28Q2();
        Slip28Q2 t3 = new Slip28Q2();
        t1.start();
        t2.start();
        t3.start();
    }
}