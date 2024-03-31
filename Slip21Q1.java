//accept n subject name store it in linked list and display using Iterator interface

import java.util.*;

public class Slip21Q1 {
    
    public static void main(String[] args) {

        List<String> myList = new LinkedList<>();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n : ");
        int n = sc.nextInt();

        for(int i=0; i<n; i++) {
            System.out.print("Enter Sub Name : ");
            myList.add(sc.next());
        }

        Iterator<String> itr = myList.iterator();

        while (itr.hasNext()) {
            
            System.out.print(itr.next() + " ");
        }

        sc.close();
    }
}