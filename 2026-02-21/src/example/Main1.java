package example;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class Main1 {

    public static void main(String[] args) {
        System.out.println(calculate(10, 20, new MultiplexMathOperation()));

        MathOperation division = new MathOperation() {
            @Override
            public long apply(long a, long b) {
                if(b == 0) {
                    throw new IllegalArgumentException("/ by zero");
                }
                return a / b;
            }
        };
        System.out.println(calculate(30, 15, division));

        MathOperation plus = (a, b) -> a + b;

        System.out.println(calculate(5, 7, plus));

        TreeSet<Scanner> set =
                new TreeSet<>((s1, s2) -> {
                    return s2.hashCode() - s1.toString().length();
                });
        set.clear();
    }

    public static long calculate(long a, long b, MathOperation operation) {
        return operation.apply(a, b);
    }
}
