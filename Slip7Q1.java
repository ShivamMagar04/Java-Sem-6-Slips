/*implement a multithead application that has three threads.
 * First thread generates random number after every one second
 * if the number is event second thread computes square of that number and print
 * if number is odd third thread computes the cube of number and print
 */

import java.util.Random;

class MultiThreads implements Runnable {
    int stop = 1;
    public void run() {
        Random rand = new Random();

        while (stop <= 10) {
            int num = rand.nextInt(100);
            System.out.println("\nGenerated number is : " + num);
            Thread thread = null;
            if(num % 2 == 0) 
                thread = new Thread(new Choice(num), "thread2");
            else 
                thread = new Thread(new Choice(num), "thread3");
            thread.start();

            try{
                Thread.sleep(3000);
            }catch(Exception e) {}

            stop++;
        }
    }

}

class Choice implements Runnable {

    int num;

    public Choice(int num) {
        this.num = num;
    }

    public void run() {
        
        if(num % 2 == 0) {
            int sq = num * num;
            System.out.println("Square of " + num + " is : " + sq);
        } else {
            int cube = num * num * num;
            System.out.println("Cube of " + num + " is : " + cube);
        }
    }
}

public class Slip7Q1 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MultiThreads(), "thread1");
        t1.start();
    }
}