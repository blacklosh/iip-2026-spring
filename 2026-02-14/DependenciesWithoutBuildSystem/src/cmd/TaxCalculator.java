package cmd;

public class TaxCalculator {

    private final CurrentNdsCounter currentNdsCounter;

    public TaxCalculator(CurrentNdsCounter currentNdsCounter) {
        this.currentNdsCounter = currentNdsCounter;
    }


    public long calculateTax(long sum) {
        return (long) (sum * currentNdsCounter.getCurrentNds());
    }

}
