//store city names and their STD codes using collection
//add a new city and its code (No Duplicates)
//Remove a city from the collection
//Search a city name and display the code

import java.util.*;

public class Slip4Q2 {
    
    public static void main(String[] args) {

        Map<String,Integer> myMap = new TreeMap<>();
        Scanner sc = new Scanner(System.in);

        //add city
        System.out.print("Enter n : ");
        int n = sc.nextInt();

        for(int i=0; i<n; i++) {
            System.out.print("Enter City Name and its STD code : ");
            String city = sc.next();
            int code = sc.nextInt();
            myMap.put(city,code);
        }

        System.out.println(myMap);

        //remove city
        System.out.print("\nEnter city name to remove : ");
        String name = sc.next();
        if(myMap.containsKey(name))
            myMap.remove(name);
        else
            System.out.println("No city name found!");
        

        //search city
        System.out.print("\nEnter city name to display its STD code : ");
        String city = sc.next();
        if(myMap.containsKey(city))
            System.out.println(myMap.get(city));
        else
            System.out.println("No city name found!");

        sc.close();
    }
}