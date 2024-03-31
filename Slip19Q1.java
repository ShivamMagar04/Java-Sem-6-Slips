//accept n integers and store in linked list and display only negative intgers

import java.util.*;

public class Slip19Q1 {
    
    public static void main(String[] args) {

        List<Integer> myList = new LinkedList<>();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n : ");
        int n = sc.nextInt();

        System.out.print("Enter " + n + " integers(including -ve and +ve) : ");
        for(int i=0; i<n; i++)
            myList.add(sc.nextInt());

        for(int num : myList) {
            if(num < 0)
                System.out.print(num + " ");
        }

        sc.close();
    }
}