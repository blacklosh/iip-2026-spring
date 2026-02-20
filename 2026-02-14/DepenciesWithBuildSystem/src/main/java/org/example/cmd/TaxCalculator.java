package org.example.cmd;

public class TaxCalculator {

    private final CurrentNdsCounter currentNdsCounter;

    public TaxCalculator(CurrentNdsCounter currentNdsCounter) {
        this.currentNdsCounter = currentNdsCounter;
    }


    public long calculateTax(long sum) {
        if(sum < 0) {
            throw new IllegalArgumentException("Sum should be non-negative!");
        }
        return (long) (sum * currentNdsCounter.getCurrentNds());
    }

}
