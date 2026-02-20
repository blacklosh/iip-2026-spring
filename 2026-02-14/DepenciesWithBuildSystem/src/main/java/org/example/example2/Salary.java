package org.example.example2;

import java.util.Objects;

public class Salary /*implements Comparable<Salary>*/ {

    public enum Currency {
        RUB,
        USD
    }

    public static final int USD_TO_RUB = 77;

    private final double amount;

    private final Currency currency;

    public Salary(double amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Salary salary = (Salary) o;
        return Double.compare(amount, salary.amount) == 0 && currency == salary.currency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, currency);
    }

    @Override
    public String toString() {
        return "Salary{" + amount + " " + currency + '}';
    }

    /*@Override
    public int compareTo(Salary o) {
        Salary salary1 = this;
        Salary salary2 = o;

        if(salary1.equals(salary2)) return 0;

        double firstSalaryInRubles;
        if(salary1.getCurrency() == Currency.RUB) {
            firstSalaryInRubles = salary1.getAmount();
        } else {
            firstSalaryInRubles = salary1.getAmount() * USD_TO_RUB;
        }

        double secondSalaryInRubles;
        if(salary2.getCurrency() == Currency.RUB) {
            secondSalaryInRubles = salary2.getAmount();
        } else {
            secondSalaryInRubles = salary2.getAmount() * USD_TO_RUB;
        }

        return (int) (firstSalaryInRubles - secondSalaryInRubles);
    }*/
}
