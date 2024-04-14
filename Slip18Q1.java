//use multithreading to display all vowels from a given string
//each vowel should be displayed after every 3 seconds

import java.util.*;

public class Slip18Q1 extends Thread {

    String str;

    public Slip18Q1(String str) {
        this.str = str;
    }

    public void run() {

        try{
            
            for(int i=0; i<str.length(); i++) {
                if(str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i'
                || str.charAt(i) == 'o' || str.charAt(i) == 'u') {
                    System.out.println(str.charAt(i));
                    Thread.sleep(3000);
                }
            }
        }catch(Exception e) {}
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string (lowercase): ");
        String str = sc.next();

        Slip18Q1 obj = new Slip18Q1(str);
        obj.start();

        sc.close();
    }
}