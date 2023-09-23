package com.mule.java.collections;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {

        //RoomWithBadKey piccadilly = new RoomWithBadKey("Piccadilly", "Guest Room", 3, 125.00);
        //RoomWithBadKey oxford = new RoomWithBadKey("Oxford", "Suite", 5, 225.0);
        Room piccadilly = new Room("Piccadilly", "Guest Room", 3, 125.00);
        Room oxford = new Room("Oxford", "Suite", 5, 225.0);
        Guest john = new Guest("John", "Doe", false);
        Guest maria = new Guest("Maria", "Doe", true);

        //Map<RoomWithBadKey,Guest> assignments = new HashMap<>();
        Map<Room,Guest> assignments = new HashMap<>();
        assignments.put(oxford,maria);
        assignments.put(piccadilly,john);

        Guest guest = assignments.put(piccadilly, assignments.remove(oxford));
        assignments.putIfAbsent(oxford, guest);

        System.out.println("Oxford: " + assignments.get(new Room("Oxford","Suite",5,225.0)));
        System.out.println("Picadilly: " + assignments.get(piccadilly));


    }

}
