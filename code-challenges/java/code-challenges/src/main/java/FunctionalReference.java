import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FunctionalReference {

    static class Person {
        public final String name;
        public final Integer age;

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }
    }

    static class Employee {
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

    public static void usingMapAndFilter() {
        Person[] peopleArr = {
                new Person("Brandon", 23),
                new Person("Hank", 43),
                new Person("Jenna", 33),
                new Person("Veronica", 56),
                new Person("Jack", 27),
        };
        List<Person> people = new ArrayList<>(Arrays.asList(peopleArr));

        List<String> peopleNames = people
                .stream()
                .map((person) -> person.name)   // from here on, the stream will only carry person names
                .filter((name) -> name.contains("n"))
                .collect(Collectors.toList());
        System.out.println(peopleNames);
    }

    public static void usingReduce() {
        Employee[] employeesArr = {
                new Employee("John", 34, "developer", 80000f),
                new Employee("Hannah", 24, "developer", 95000f),
                new Employee("Bart", 50, "sales executive", 100000f),
                new Employee("Sophie", 49, "construction worker", 40000f),
                new Employee("Darren", 38, "writer", 50000f),
                new Employee("Nancy", 29, "developer", 75000f),
        };
        List<Employee> employees = new ArrayList<>(Arrays.asList(employeesArr));

        Float sumOfSalaries = employees
                .stream()
                .map((employee) -> employee.salary)
                .reduce(0f, (acc, x) -> acc + x);

        System.out.println(sumOfSalaries);
    }

    public static void usingGroupingBy() {
        Employee[] employeesArr = {
                new Employee("John", 34, "developer", 80000f),
                new Employee("Hannah", 24, "developer", 95000f),
                new Employee("Bart", 50, "sales executive", 100000f),
                new Employee("Sophie", 49, "construction worker", 40000f),
                new Employee("Darren", 38, "writer", 50000f),
                new Employee("Nancy", 29, "developer", 75000f),
        };
        List<Employee> employees = new ArrayList<>(Arrays.asList(employeesArr));
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

    public static void usingFunctionsAsVariables() {
        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> listOfIntegers = new ArrayList<>(Arrays.asList(intArray));

        Function<Integer, Integer> timesTwo = (x) -> x * 2;

        List<Integer> doubled = listOfIntegers
                .stream()
                .map(timesTwo)
                .collect(Collectors.toList());

        System.out.println(doubled);
    }

    public static void usingPredicate() {
        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> listOfIntegers = new ArrayList<>(Arrays.asList(intArray));

        Predicate<Integer> isEven = (x) -> x % 2 == 0;

        List<Integer> evens = listOfIntegers
                .stream()
                .filter(isEven)
                .collect(Collectors.toList());

        System.out.println(evens);
    }

    public static void usingComparator() {
        List<String> nombres = Arrays.asList("Juan", "Pedro", "Ana", "María");

        Comparator<String> comparadorInverso = (nombre1, nombre2) -> nombre2.compareTo(nombre1);

        List<String> nombresOrdenados = nombres.stream()
                .sorted(comparadorInverso)
                .collect(Collectors.toList());

        System.out.println(nombresOrdenados);
    }

    public static void main(String[] args) {
//        usingMapAndFilter();
//        usingReduce();
//        usingGroupingBy();
//        usingFunctionsAsVariables();
//        usingPredicate();
        usingComparator();
    }
}
