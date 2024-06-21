package functional.programming;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionalProgramming {

    protected class LoggerTools {
        public static String appendDateTime(String message) {
            return "Logger 1 says: " + message;
        }
    }

    @FunctionalInterface
    protected interface TriFunction<T, U, V, R> {
        R apply(T t, U u, V v);
    }

    protected class CustomMath {
        public static Function<Integer, Integer> createMultiplier(int factor) {
            return (Integer x) -> x * factor;
        }
    }

    public static void main(String[] args) {
        // assign a function to a variable by using a method reference
        System.out.println("###Assign a function to a variable by using a method reference");
        Function<String, String> logger = LoggerTools::appendDateTime;
        System.out.println(logger.apply("Hello world!"));

        // assign a function to a variable by using a lambda expression
        System.out.println("\n###Assign a function to a variable by using a lambda expression");
        Function<String, String> logger2 = (message) -> "Logger 2 says: " + message;
        System.out.println(logger2.apply("Hello world 2!"));

        // BiFunction
        System.out.println("\n###BiFunction");
        BiFunction<Integer, Integer, Integer> add = (x, y) -> x + y;
        System.out.println(add.apply(2, 3));

        // TriFunction
        System.out.println("\n###TriFunction");
        TriFunction<Integer, Integer, Integer, Integer> addThree = (x, y, z) -> x + y + z;
        System.out.println(addThree.apply(5, 3, 2));

        // Custom multiplier
        System.out.println("\n###Custom multiplier");
        Function<Integer, Integer> multiplyByFive = CustomMath.createMultiplier(5);
        System.out.println(multiplyByFive.apply(3));

        // Check that dividend is not zero
        System.out.println("\n###Check that dividend is not zero");
        BiFunction<Float, Float, Float> divide = (x, y) -> x / y;
        Function<BiFunction<Float, Float, Float>, BiFunction<Float, Float, Float>> secondArgIsntZeroCheck =
                (func) -> (x, y) -> {
                    if (y == 0f) {
                        System.out.println("Error: second argument is zero!");
                        return 0f;
                    }
                    return func.apply(x, y);
                };
        BiFunction<Float, Float, Float> divideSafe = secondArgIsntZeroCheck.apply(divide);
        System.out.println(divideSafe.apply(10f, 2f));


    }
}
