import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainCollectors {

    static class Student {
        String group;
        String name;

        public Student(String group, String name) {
            this.group = group;
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student("11-503", "ABC");
        Student s2 = new Student("11-503", "DEF");
        Student s3 = new Student("11-503", "XYZ");
        Student s4 = new Student("11-504", "123");
        Student s5 = new Student("11-504", "456");

        List<Student> students = List.of(s1, s2, s3, s4, s5);
        Map<String, List<String>> rs = students.stream()
                .collect(Collectors.toMap(
                        student -> student.group,
                        student -> List.of(student.name),
                        (list1, list2) -> {
                            List<String> result = new ArrayList<>();
                            result.addAll(list1);
                            result.addAll(list2);
                            return result;
                        }
                ));

        System.out.println(rs);
    }
}
