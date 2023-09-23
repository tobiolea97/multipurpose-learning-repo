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

        Guest john = new Guest("John", "Doe", false);
        Guest bob = new Guest("Bob", "Doe", false);
        Guest sonia = new Guest("Sonia", "Doe", true); //loyalty program
        Guest siri = new Guest("Siri", "Doe", true); //loyalty program

        Comparator<Guest> programComp =
                Comparator.comparing(Guest::isLoyaltyProgramMember).reversed();

        Queue<Guest> checkinQueue = new PriorityQueue<>(programComp);
        checkinQueue.offer(john);
        checkinQueue.offer(bob);
        checkinQueue.offer(sonia);
        checkinQueue.offer(siri);
        print(checkinQueue);

    }

    public static void print(Queue<Guest> queue) {

        System.out.format("%n--Queue Contents--%n");

        int x = 0;
        for(Guest guest : queue) {
            System.out.format("%x: %s %s %n", x++, guest.toString(), x == 1 ? "(Head)":"");
        }

        System.out.println("");

    }
}
