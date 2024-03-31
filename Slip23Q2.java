//accept n student name from command line store it in collection and display
//using Iterator and ListIterator

import java.util.*;

public class Slip23Q2 {

    public static void main(String[] args) {

        LinkedList<String> myList = new LinkedList<>();
        
        for(String arg : args) 
            myList.add(arg);
           

        ListIterator<String> itr = myList.listIterator();

        while (itr.hasNext()) 
            System.out.println(itr.next());
    }
}