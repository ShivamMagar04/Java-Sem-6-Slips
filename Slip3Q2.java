//ceate linked list of string and : add element at end, delete first element,
//display elements in reverse order

import java.util.*;

public class Slip3Q2 {
    
    public static void main(String[] args) {

        LinkedList<String> myList = new LinkedList<>();

        myList.add("One");
        myList.add("Two");
        myList.add("Three");
        System.out.println("Linked List : ");
        System.out.println(myList);

        //add at first index
        myList.addFirst("First");
        System.err.println("After adding element at first index : ");
        System.out.println(myList);

        //delete first index element
        myList.removeFirst();
        System.out.println("After removing first element : ");
        System.err.println(myList);

        //display elements in reverse order
        Collections.reverse(myList);
        System.out.println("Linked list in reversed order : ");
        for(String str : myList)
            System.out.print(str + " ");
    }
}