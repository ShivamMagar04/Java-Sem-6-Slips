//linked list
//add element at first position
//delete last element
//display size of link list

import java.util.*;

public class Slip29Q2 {
    
    public static void main(String[] args) {

        LinkedList<Integer> myList = new LinkedList<>();
        Scanner sc = new Scanner(System.in);

        myList.add(1);
        myList.add(2);
        myList.add(3);

        System.out.println(myList);

        //add element at first position
        System.out.print("\nEnter element to add at first position : ");
        myList.addFirst(sc.nextInt());
        System.out.println(myList);

        //delete last element
        myList.removeLast();
        System.out.println("\nAfter deleting last element : ");
        System.out.println(myList);

        //display size 
        System.out.println("\nSize of linked list : " + myList.size());

        sc.close();
    }
}