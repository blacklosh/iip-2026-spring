import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of(123, 15, 5, 8, 0)
                .map(String::valueOf)
                .peek(System.out::println)
                .filter(e -> e.length() < 2)
                .peek(System.out::println);

        String string = stream.collect(Collectors.joining(", "));
        System.out.println(string);

        // FORBIDDEN
        //stream.forEach(e -> System.out.println("Кукареку"));
    }
}