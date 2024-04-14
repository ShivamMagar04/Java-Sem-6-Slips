/*define three threads for printing text on o/p screen for n times
 * pass n paramenter to thread constructor
 * first thread print 'COVID19' 10 times
 * second thread prints 'LOCKDOWN2020' 20 times
 * third thread prints 'VACCINATED2021' 30 times
 */

class MultipleThreds extends Thread {

    int n;
    String txt;

    public MultipleThreds(int n, String txt) {
        this.n = n;
        this.txt = txt;
    }

    public void run() {

        try {
                for(int i=0; i<n; i++) {
                    System.out.println(txt);
                    Thread.sleep(1000);
                }
        }catch(Exception e) {}
    }
}

public class Slip8Q1 {
    public static void main(String[] args) {
        MultipleThreds t1 = new MultipleThreds(10,"COVID19");
        MultipleThreds t2 = new MultipleThreds(20,"LOCKDOWN2020");
        MultipleThreds t3 = new MultipleThreds(30,"VACCINATED2021");
        
        try{
            t1.start();
            t1.join();
            t2.start();
            t2.join();
            t3.start();
            t3.join();
        }catch(Exception e) {}
    }
}