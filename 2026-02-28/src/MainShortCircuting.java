import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainShortCircuting {
    public static void main(String[] args) {
        /*Optional<String> optionalString = Stream.of(123, 15, 5, 8, 0)
                .map(String::valueOf)
                .filter(e -> e.length() < 2)
                .peek(System.out::println)
                .findAny();
        // Short-circuit

        if(optionalString.isPresent()) {
            System.out.println("Ура! Нашлось " + optionalString.get());
        } else {
            System.out.println("Ничего не нашлось");
        }*/

        long count = Stream.of(123, 15, 5, 8, 0)
                .map(String::valueOf)
                //.filter(e -> e.length() < 2)
                .peek(System.out::println)
                .count();
        System.out.println("Count = " + count);
    }
}