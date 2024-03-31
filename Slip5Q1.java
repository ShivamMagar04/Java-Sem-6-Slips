//create hash table that maintain mobile number and student name
//display detais using Enumeration interface

import java.util.*;

public class Slip5Q1 {
    
    public static void main(String[] args) {

        Hashtable<String,Long> myTable = new Hashtable<>();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n : ");
        int n = sc.nextInt();

        for(int i=0; i<n; i++) {
            System.out.print("Enter Student Name : ");
            String name = sc.next();
            System.out.print("Enter mobile number : ");
            long num = sc.nextLong();
            myTable.put(name,num);
        }

        Enumeration<String> itr = myTable.keys();
        System.out.println("Name\tMobile Number");

        while (itr.hasMoreElements()) {
            
            String name = itr.nextElement();
            Long mob = myTable.get(name);
            System.out.println(name + "\t" + mob);
        }

        sc.close();
    }
}