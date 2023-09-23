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

        List<Integer> numbers = Arrays.asList(500, 1500, 2500, 1000, 3000, 2000);

        NavigableSet<Integer> numberTree = new TreeSet<>(numbers);

        numberTree
                //.descendingSet()
                .headSet(1750)
                .tailSet(750)
                .subSet(1499,1501)
                .stream()
                .forEach(System.out::println);

    }
}
