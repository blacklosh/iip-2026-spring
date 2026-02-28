import java.util.IntSummaryStatistics;
import java.util.OptionalDouble;
import java.util.stream.Stream;

public class MainNumbericStreams {

    public static void main(String[] args) {

        // IntStream

        OptionalDouble od = Stream.of(123, 15, 5, 8, 0)
                .mapToInt(e -> e)
                .filter(e -> e < 0)
                .average();


        if(od.isPresent()) {
            System.out.println("Ура! Среднее нашлось: " + od.getAsDouble());
        } else {
            System.out.println("среднего не нашлось...");
        }

        IntSummaryStatistics summaryStatistics = Stream.of(123, 15, 5, 8, 0)
                .mapToInt(e -> e)
                .summaryStatistics();

        System.out.println(summaryStatistics);

    }
}
