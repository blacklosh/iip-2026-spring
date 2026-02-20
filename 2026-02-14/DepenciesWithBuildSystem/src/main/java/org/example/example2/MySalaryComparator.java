package org.example.example2;

import java.util.Comparator;

import static org.example.example2.Salary.USD_TO_RUB;

public class MySalaryComparator implements Comparator<Salary> {

    @Override
    public int compare(Salary salary1, Salary salary2) {
        if(salary1.equals(salary2)) return 0;

        double firstSalaryInRubles;
        if(salary1.getCurrency() == Salary.Currency.RUB) {
            firstSalaryInRubles = salary1.getAmount();
        } else {
            firstSalaryInRubles = salary1.getAmount() * USD_TO_RUB;
        }

        double secondSalaryInRubles;
        if(salary2.getCurrency() == Salary.Currency.RUB) {
            secondSalaryInRubles = salary2.getAmount();
        } else {
            secondSalaryInRubles = salary2.getAmount() * USD_TO_RUB;
        }

        return (int) (firstSalaryInRubles - secondSalaryInRubles);
    }
}
