import java.util.stream.Stream;

public class MainSideEffects {

    static String a = "";

    public static void main(String[] args) {

        Stream.of(123, 15, 5, 8, 0)
                .map(String::valueOf)
                //.filter(e -> e.length() < Integer.parseInt(args[0]))
                .peek(e -> {
                    a = a + "abc";
                })
                .count();

        System.out.println(a);
    }
}
