package streams;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Streams {

    public static void main(String[] args) {
        // method reference
        System.out.println("###Using a method reference on a stream");
        String[] messages = {"Hello", "world", "!"};
        Arrays.stream(messages).forEach(System.out::println);

        // use map and collect
        System.out.println("\n###Using map and collect");
        Integer[] intArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        List<Integer> listOfIntegers = new ArrayList<>(Arrays.asList(intArray));
        Function<Integer, Integer> timesTwo = (x) -> x * 2;
        List<Integer> doubled = listOfIntegers
                .stream()
                .map(timesTwo)                  // map aplica a cada elemento del stream la función timesTwo
                .collect(Collectors.toList());  // collect convierte el stream en una lista

        System.out.println(doubled);

        // using a predicate as a filter
        System.out.println("\n###Using a predicate as a filter");
        Integer[] intArray2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        List<Integer> listOfIntegers2 = new ArrayList<>(Arrays.asList(intArray2));

        Predicate<Integer> isEven = (x) -> x % 2 == 0;

        List<Integer> evens = listOfIntegers
                .stream()
                .filter(isEven)
                .collect(Collectors.toList());

        System.out.println(evens);

        // using a test creator
        System.out.println("\n###Using a test creator");
        String[] wordsArr = { "hello", "functional", "programming", "is", "cool" };
        List<String> words = new ArrayList<>(Arrays.asList(wordsArr));

        Function<Integer, Predicate<String>> createLengthTest = (minLength) -> (str) -> str.length() > minLength;
        Function<String, Predicate<String>> containsString = (searchStr) -> (str) -> str.contains(searchStr);

        Predicate<String> containsL = containsString.apply("l");
        Predicate<String> isLongerThan5 = createLengthTest.apply(5);

        List<String> longWords = words
                .stream()
                .filter(containsL)
                .filter(isLongerThan5)
                .collect(Collectors.toList());

        System.out.println(longWords);

        // using reduce
        System.out.println("\n###Using reduce");
        Integer[] intArray3 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        List<Integer> listOfIntegers3 = new ArrayList<>(Arrays.asList(intArray));

        BinaryOperator<Integer> getSum = (acc, x) -> {
            Integer result = acc + x;
            System.out.println("acc: " + acc + ", x: " + x + ", result: " + result);
            return result;
        };

        Integer sum = listOfIntegers3
                .stream()
                .reduce(0, getSum);
        System.out.println(sum);

        // using reduce for operating with strings
        System.out.println("\n###Using reduce for operating with strings");
        List<String> listOfStrings = Arrays.asList("Hello", " ", "world", "!", " Welcome", " to", " Java");

        BinaryOperator<String> concatenate = (acc, s) -> {
            String result = acc + s;
            //System.out.println("acc: \"" + acc + "\", s: \"" + s + "\", result: \"" + result + "\"");
            return result;
        };

        String combinedString = listOfStrings
                .stream()
                .reduce("", concatenate);

        System.out.println("Combined String: " + combinedString);

        // collect by using partitioningBy
        System.out.println("\n###Collect by using partitioningBy");
        String[] wordsArr2 = {"hello", "apple", "functional", "programming", "is", "cool"};
        List<String> words2 = new ArrayList<>(Arrays.asList(wordsArr2));

        // partitioningBy divide la lista en dos grupos de acuerdo a un criterio booleano
        Map<Boolean, List<String>> wordLengthMap = words2
                .stream()
                .collect(Collectors.partitioningBy(
                    (word) -> word.length() > 5
                ));
        System.out.println(wordLengthMap);

        // combine filter, map and reduce
        System.out.println("\n###Combine filter, map and reduce");
        Employee[] employeesArr = {
                new Employee("John", 34, "developer", 80000f),
                new Employee("Hannah", 24, "developer", 95000f),
                new Employee("Bart", 50, "sales executive", 100000f),
                new Employee("Sophie", 49, "construction worker", 40000f),
                new Employee("Darren", 38, "writer", 50000f),
                new Employee("Nancy", 29, "developer", 75000f),
        };
        List<Employee> employees = new ArrayList<>(Arrays.asList(employeesArr));

        Float totalDeveloperSalaries = employees
                .stream()
                .filter((employee) -> employee.jobTitle == "developer")
                .map((developer) -> developer.salary)
                .reduce(0f, (acc, x) -> acc + x);

        Long numberOfDevelopers = employees
                .stream()
                .filter((employee) -> employee.jobTitle == "developer")
                .collect(Collectors.counting());

        Float averageDeveloperSalary = totalDeveloperSalaries / numberOfDevelopers;
        System.out.println(averageDeveloperSalary);

        // using parallel streams
        System.out.println("\n###Using parallel streams");
        String[] wordsArr4 = {"hello", "apple", "functional", "programming", "is", "cool"};
        List<String> words4 = new ArrayList<>(Arrays.asList(wordsArr));

        // parallelStream() divide la lista en varios subgrupos que se procesan en paralelo
        List<String> processedWords = words4
                .parallelStream()
                .map((word) -> {
                    System.out.println("Uppercasing " + word);
                    return word.toUpperCase();
                })
                .map((word) -> {
                    System.out.println("Adding exclamation point to " + word);
                    return word + "!";
                })
                .collect(Collectors.toList());

        System.out.println(processedWords);

        // using groupingBy, entrySet and Collectors.toMap
        Set<Map.Entry<String, List<Employee>>> entryset = employees
                .stream()
                .collect(Collectors.groupingBy(
                        (employee) -> employee.jobTitle
                ))
                .entrySet();

        Map<String, Float> averageSalariesMap = employees
                .stream()
                .collect(Collectors.groupingBy(
                        (employee) -> employee.jobTitle
                ))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        (entry) -> entry.getKey(),
                        (entry) -> entry.getValue()
                                .stream()
                                .map((employee) -> employee.salary)
                                .reduce(0f, (acc, x) -> acc + x) / entry.getValue().size()
                ));

        System.out.println(averageSalariesMap);
    }

    protected static class Employee {
        public final String name;
        public final Integer age;
        public final String jobTitle;
        public final Float salary;

        public Employee(String name, Integer age, String jobTitle, Float salary) {
            this.name = name;
            this.age = age;
            this.jobTitle = jobTitle;
            this.salary = salary;
        }
    }

}
