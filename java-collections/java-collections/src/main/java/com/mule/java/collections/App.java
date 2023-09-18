package com.mule.java.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Room cambridge = new Room("Cambridge", "Premiere Room", 4, 175.00);
        Room manchester = new Room("Manchester", "Suite", 5, 250.00);
        Room oxford = new Room("Oxford", "Suite", 5, 225.0);
        Room victoria = new Room("Victoria", "Suite", 5, 225.00);

        Collection<Room> rooms = new ArrayList<>(Arrays.asList(cambridge, oxford, victoria, manchester));
        oxford.setPetFriendly(true);
        victoria.setPetFriendly(true);

        // this will throw a ConcurrentModificationException
        /*
        for(Room room : rooms) {
            if(room.isPetFriendly()) {
                rooms.remove(room);
            }
        }
        */

        // this is one approach we could take if we want to remove elements from a collection
        /*
        Collection<Room> removeRooms = new ArrayList<>();
        for(Room room : rooms) {
            if(room.isPetFriendly()) {
                removeRooms.add(room);
            }
        }
        rooms.removeAll(removeRooms);
        */

        // this is another approach
        Iterator<Room> iterator = rooms.iterator();
        Collection<Room> removeRooms = new ArrayList<>();
        while (iterator.hasNext()) {
            Room room = iterator.next();
            if(room.isPetFriendly()) {
                iterator.remove();
            }
        }

        rooms.stream()
                .forEach(r -> System.out.println(r.getName()));

    }
}
