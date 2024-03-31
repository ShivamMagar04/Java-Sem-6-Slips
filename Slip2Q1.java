//accept names of your friends store it in hashset and display it in accending order

import java.util.*;

public class Slip2Q1 {

    public static void main(String[] args) {

        Set<String> mySet = new HashSet<>();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n : ");
        int n = sc.nextInt();

        System.out.print("Enter " + n + " friends names : ");

        for(int i=0; i<n; i++)
            mySet.add(sc.next());

        Set<String> newSet = new TreeSet<>();
        
        newSet.addAll(mySet);

        System.out.println(newSet);

        sc.close();
    }
}