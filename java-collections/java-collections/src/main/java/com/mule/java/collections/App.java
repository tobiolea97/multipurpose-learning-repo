package com.mule.java.collections;

import java.util.*;
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

        Room piccadilly = new Room("Piccadilly", "Guest Room", 3, 125.00);
        Room oxford = new Room("Oxford", "Suite", 5, 225.0);
        Room oxfordDuplicate = new Room("Oxford", "Suite", 5, 225.0);
        Room victoria = new Room("Victoria", "Suite", 5, 225.00);

        Set<Room> otherRooms = Set.of(piccadilly,oxford);
        //otherRooms.add(victoria); // this breaks the code because Set.of() creates an unchangable object

        //Set<Room> rooms = new LinkedHashSet<>(); // LinkedHashSet keeps the order of insertion
        Set<Room> rooms = new HashSet<>(); // HashSet doesn't keep the order of insertion
        rooms.add(piccadilly);
        rooms.add(oxford);
        rooms.add(oxford);
        rooms.add(oxfordDuplicate);


        Set<Room> moreRooms = Set.copyOf(rooms);

        moreRooms.stream()
                .map(r -> r.getName())
                .forEach(System.out::println);



    }
}
