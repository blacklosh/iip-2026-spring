package org.example.cmd;

import org.example.cmd.CurrentNdsCounter;
import org.example.cmd.TaxCalculator;

public class Main {
    public static void main(String[] args) {
        CurrentNdsCounter cnc = new CurrentNdsCounter();
        TaxCalculator taxCalculator = new TaxCalculator(cnc);

        System.out.println(taxCalculator.calculateTax(1000));
        System.out.println(taxCalculator.calculateTax(1515));
    }
}