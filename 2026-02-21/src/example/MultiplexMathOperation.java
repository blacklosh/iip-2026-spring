package example;

public class MultiplexMathOperation implements MathOperation {

    @Override
    public long apply(long a, long b) {
        return a * b;
    }
}
