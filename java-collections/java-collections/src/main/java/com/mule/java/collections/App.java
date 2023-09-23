package com.mule.java.collections;

import java.security.KeyStore;
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

        Room piccadilly = new Room("Piccadilly", "Guest Room", 3, 125.00);
        Room oxford = new Room("Oxford", "Suite", 5, 225.0);

        Guest john = new Guest("John", "Doe", false);
        Guest maria = new Guest("Maria", "Doe", true);

        Map<Room, Guest> assignments = new HashMap<>();
        assignments.put(oxford, maria);
        assignments.put(piccadilly, john);

        Set<Map.Entry<Room, Guest>> collectionView = assignments.entrySet();

        for (Map.Entry<Room,Guest> entry:
             assignments.entrySet()) {
            Room r = entry.getKey();
            Guest g = entry.getValue();
            System.out.format("%s : %s%n",r.getName(), g.getFirstName());
        }



    }

}
