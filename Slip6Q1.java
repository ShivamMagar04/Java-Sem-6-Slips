//accept n integers store it in collections. display in sorted order
//no duplicates
//search element

import java.util.*;

public class Slip6Q1 {
    public static void main(String[] args) {

        Set<Integer> myTree = new TreeSet<>();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n : ");
        int n = sc.nextInt();

        System.out.print("Enter " + n + " integers : ");
        for(int i=0; i<n; i++) {

            myTree.add(sc.nextInt());
        }

        //display
        for(int num : myTree)
            System.out.print(num + " ");

        //search
        System.out.print("\nEnter element to search : ");
        if(myTree.contains(sc.nextInt()))
            System.out.println("Found!");
        else
            System.out.println("Not Found!");

        sc.close();
    }
}