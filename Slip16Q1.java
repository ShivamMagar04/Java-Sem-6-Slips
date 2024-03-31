//add colors in tree set and display in ascending order

import java.util.*;

public class Slip16Q1 {
    
    public static void main(String[] args) {

        Set<String> mySet = new TreeSet<>();
        
        mySet.add("RED");
        mySet.add("BLUE");
        mySet.add("PINK");
        mySet.add("WHITE");
        mySet.add("BLACK");

        for(String str : mySet)
            System.out.print(str + " ");
    }
}