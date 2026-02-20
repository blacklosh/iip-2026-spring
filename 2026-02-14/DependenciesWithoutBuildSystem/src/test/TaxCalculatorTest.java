package test;

import cmd.CurrentNdsCounter;
import cmd.TaxCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaxCalculatorTest {

    private final TaxCalculator taxCalculator = new TaxCalculator(
            new CurrentNdsCounter()
    );

    @Test
    void testOn1000Rubles() {
        long input = 1000;
        long expected = 130;

        long output = taxCalculator.calculateTax(input);

        assertEquals(expected, output);
    }

}
