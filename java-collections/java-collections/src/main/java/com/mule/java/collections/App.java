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

        //Queue<Guest> checkinQueue = new ArrayDeque<>();
        //Guest guest = checkinQueue.remove(); // this throws a NoSuchElement exception
        //Guest guest = checkinQueue.poll(); // this works
        //System.out.println(guest);

        Queue<Guest> checkinQueue = new ArrayDeque<>();
        checkinQueue.offer(john);
        checkinQueue.offer(bob);
        checkinQueue.offer(sonia);
        checkinQueue.offer(siri);
        print(checkinQueue);

        Guest guest = checkinQueue.poll(); // poll retrieves and removes the element at the head of the queue
        //Guest guest = checkinQueue.remove(); // equivalent that throws an exception
        print(checkinQueue);
        System.out.println(guest);

        Guest guest1 = checkinQueue.peek(); // peek only retrieves the element at the head of the queue
        //Guest guest1 = checkinQueue.element(); // equivalent that throws exception
        print(checkinQueue);
        System.out.println(guest);

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
