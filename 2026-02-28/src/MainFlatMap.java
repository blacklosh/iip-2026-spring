import java.util.List;

public class MainFlatMap {

    static class Book {
        public List<String> words;
    }

    public static void main(String[] args) {
        // Stream<Stream<Object>> -> Stream<Object>
        Book book1 = new Book();
        book1.words = List.of("hello", "world", "car", "java");

        Book book2 = new Book();
        book2.words = List.of("bird", "haven", "java");

        List<Book> books = List.of(book1, book2);

        List<String> distinctWords = books.stream()
                .map(b -> b.words)
                .map(w -> w.stream())
                .flatMap(a -> a)
                .distinct()
                .toList();

        List<String> distinctWords2 = books.stream()
                .flatMap(b -> b.words.stream())
                .distinct()
                .toList();

        System.out.println(distinctWords);
    }
}
