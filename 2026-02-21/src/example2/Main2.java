package example2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Main2 {

    public static void main(String[] args) {
        List<People> peoples = new ArrayList<>();

        peoples.add(new People("Islam", 18, true));
        peoples.add(new People("Timerlan", 17, true));
        peoples.add(new People("Eugene", 17, true));
        peoples.add(new People("Islam", 18, true));
        peoples.add(new People("Eugene", 19, true));
        peoples.add(new People("Ellina", 18, false));
        peoples.add(new People("Adelia", 17, false));

        List<String> fittingNames = new ArrayList<>();

        for(int i = 0; i < peoples.size(); i++) {
            People p = peoples.get(i);
            if(p.isMale() && p.getAge() >= 18) {
                fittingNames.add(p.getName());
            }
        }

        fittingNames.sort(
                (p1, p2) -> p1.compareTo(p2)
        );

        System.out.println(fittingNames);

        //Stream<People> stream = peoples.stream();
        //stream = stream.filter(p -> p.getAge() >= 18);
        //stream = stream.filter(p -> p.isMale());
        //Stream<String> stream2 = stream.map(p -> p.getName());
        //stream2 = stream2.sorted((p1, p2) -> p1.compareTo(p2));
        //List<String> fittingNames2 = stream2.toList();

        List<String> fittingNames2 = peoples.stream()
                .filter(p -> p.getAge() >= 18)
                .filter(People::isMale)
                .map(People::getName)
                .distinct()
                .sorted()
                .toList();

        System.out.println(fittingNames2);

        Optional<String> optionalName = peoples.stream()
                .filter(p -> p.getAge() >= 180)
                .filter(People::isMale)
                .map(People::getName)
                .findFirst();

        System.out.println(optionalName);

        boolean hasName = peoples.stream()
                .filter(p -> p.getAge() >= 18)
                .noneMatch(People::isMale);

        System.out.println(hasName);
    }
}
