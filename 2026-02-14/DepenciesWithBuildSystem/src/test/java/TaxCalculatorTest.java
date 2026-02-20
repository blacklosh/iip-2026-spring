import org.example.cmd.CurrentNdsCounter;
import org.example.cmd.TaxCalculator;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TaxCalculatorTest {

    private static TaxCalculator taxCalculator;

    @BeforeAll
    static void beforeAll() {
        CurrentNdsCounter currentNdsCounter = Mockito.mock(CurrentNdsCounter.class);
        Mockito.when(currentNdsCounter.getCurrentNds()).thenReturn(0.13);
        taxCalculator = new TaxCalculator(currentNdsCounter);
    }

    @BeforeEach
    void beforeEach() {

    }

    @AfterAll
    static void afterAll() {

    }

    @AfterEach
    void afterEach() {

    }

    @Test
    void testOn1000Rubles() {
        long input = 1000;
        long expected = 130;

        long output = taxCalculator.calculateTax(input);

        assertEquals(expected, output);
    }

    @Test
    void testOnNegativeNumber() {
        long input = -1000;

        assertThrows(IllegalArgumentException.class, () -> taxCalculator.calculateTax(input));
    }

}
