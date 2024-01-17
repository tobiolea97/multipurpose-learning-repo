import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FunctionalChallenges {

    //    Filtrar y mapear una lista de nombres
//    Objetivo: Dada una lista de nombres, filtra aquellos que tienen más de 5 letras
//    y conviértelos a mayúsculas.
    public static void filterAndMap() {
        List<String> names = Arrays.asList("Juan", "Pedro", "Ana", "Alejandro", "Lucía", "Manuel");
        List<String> processedNames = names.stream()
                .filter((name) -> name.length() < 5)
                .map(name -> name.toUpperCase())
                .collect(Collectors.toList());

        System.out.println(processedNames);
    }

    //    Reducir una lista de números para calcular su suma
//    Objetivo: Dada una lista de números, usa reduce() para sumar todos los elementos.
    public static void reduce() {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);
        Integer result = numeros.stream()
                .reduce(0, (x, y) -> x + y);
        System.out.println(result);
    }

    //    Agrupar empleados por departamento
    //    Objetivo: Dada una lista de empleados, agrúpalos por departamento utilizando groupingBy().
    enum Club {
        RIVER, BOCA, RACING, INDEPENDIENTE
    }

    static class Employee {
        private String name;
        private Club club;

        public Employee(String name, Club club) {
            this.name = name;
            this.club = club;
        }

        public Club getClub() {
            return club;
        }
    }

    public static void groupingBy() {
        List<Employee> employees = Arrays.asList(
                new Employee("Tobias", Club.RIVER),
                new Employee("Rodri", Club.INDEPENDIENTE),
                new Employee("Santi", Club.RIVER),
                new Employee("Alo", Club.BOCA)
        );

        Map<Club, List<Employee>> groupedEmployees = employees.stream()
                .collect(
                        Collectors
                                .groupingBy(employee -> employee.getClub())
                );

        groupedEmployees
                .entrySet()
                .stream()
                .forEach((entry) -> {
                    System.out.println(entry.getKey());
                    entry.getValue()
                            .stream()
                            .map((element) -> element.name)
                            .forEach(System.out::println);
                });
    }

    public static void main(String[] args) {
//        filterAndMap();
//        reduce();
//        groupingBy();
    }
}
