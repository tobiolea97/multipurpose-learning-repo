package streams;

import java.util.Arrays;

public class Streams {

    public static void main(String[] args) {
        // method reference
        String[] messages = {"Hello", "world", "!"};
        Arrays.stream(messages).forEach(System.out::println);
    }

}
