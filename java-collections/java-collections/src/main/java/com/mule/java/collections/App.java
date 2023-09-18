package com.mule.java.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {

        Room cambridge = new Room("Cambridge", "Premiere Room", 4, 175.00);
        Room manchester = new Room("Manchester", "Suite", 5, 250.00);
        Room oxford = new Room("Oxford", "Suite", 5, 225.0);
        Room victoria = new Room("Victoria", "Suite", 5, 225.00);

        Collection<Room> rooms = new ArrayList<>(Arrays.asList(cambridge, oxford, victoria, manchester));
        oxford.setPetFriendly(true);
        victoria.setPetFriendly(true);



        // ****** NEVER WORK WITH EXTERNAL OBJECTS INSIDE YOUR STREAM AND
        // ****** MODIFY OBJECTS INSIDE YOUR STREAM AT THE SAME TIME
        /*
        Collection<Room> petFriendlyRooms = new ArrayList<>();
        rooms.stream()
                .filter(Room::isPetFriendly)
                .forEach(room -> petFriendlyRooms.add(room));
        */

        // THIS IS THE CORRECT WAY
        Collection<Room> petFriendlyRooms = rooms.stream()
                .filter(Room::isPetFriendly)
                .collect(Collectors.toList());

        // THIS IS ONE ALTERNATIVE FOR PRINTING OUT
        petFriendlyRooms.stream()
                .forEach(r -> System.out.println(r.getName()));

        // THIS IS A BETTER ALTERNATIVE FOR PRINTING OUT
        petFriendlyRooms.stream()
                // map transform the element that flows out of the operation
                // after this, the stream will be only a list of names
                .map(r -> r.getName())
                // System.out::println is a method reference
                .forEach(System.out::println);


        double total = petFriendlyRooms.stream()
                .mapToDouble(Room::getRate)
                .sum();

        System.out.println(total);

    }
}
