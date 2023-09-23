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
        Guest maria = new Guest("Maria", "Doe", false);
        Guest sonia = new Guest("Sonia", "Doe", true);
        Guest siri = new Guest("Siri", "Doe", true);

        List<Guest> checkinList = new ArrayList<>(100); // 100 inicial capacity
        checkinList.add(john);
        checkinList.add(maria);
        print(checkinList);

        checkinList.add(0,siri);
        checkinList.get(2).setLoyaltyProgramMember(true);

        checkinList.addAll(1, List.of(maria, siri));  // insert the list of the second parameter in the index of the first parameter
                                                            // following elements are moved to the right

        checkinList.remove(checkinList.size() - 1);

        System.out.println("John is: " + checkinList.indexOf(john));

    }

    public static void print(List<Guest> list) {

        System.out.format("%n--List Contents--%n");

        for (int x = 0; x < list.size(); x++) {
            Guest guest = list.get(x);
            System.out.format("%x: %s %n", x, guest.toString());
        }

    }
}
