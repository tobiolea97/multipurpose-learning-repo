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

        Deque<String> messageStack = new ArrayDeque<>();
        messageStack.addFirst("Message 1");
        messageStack.push("Message 2");
        messageStack.push("Message 3");
        messageStack.push("Message 4");

        print(messageStack);

        System.out.println(messageStack.pop());
        System.out.println(messageStack.pop());
        print(messageStack);
        messageStack.push("Message 5");
        System.out.println(messageStack.peek());


        print(messageStack);


    }

    public static void print(Deque<String> deque) {

        System.out.format("%n--Deque Contents--%n");

        int x = 0;
        for(String msg : deque) {
            System.out.format("%x: %s %s %n", x++, msg, x == 1 ? "(Top)":"");
        }

        System.out.println("");

    }

}
