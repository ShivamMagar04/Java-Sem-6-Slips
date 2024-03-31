//accept n integers store it in collection and display in ascending order

import java.util.*;

public class Slip17Q1 {
    
    public static void main(String[] args) {

        Set<Integer> mySet = new TreeSet<>();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n : ");
        int n = sc.nextInt();

        System.out.print("Enter " + n + " integers : ");
        for(int i=0; i<n; i++) 
            mySet.add(sc.nextInt());

        for(int num : mySet)
            System.out.print(num + " ");

        sc.close();
    }
}