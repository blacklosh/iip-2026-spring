package org.example.example2;

import java.util.Set;
import java.util.TreeSet;

public class Main2 {

    public static void main(String[] args) {
        // Comparable - характеристика объекта, его способность сравнить себя с другим объектом (того же типа)
        // Comparator - отдельный объект, который умеет сравнивать определённые (но другие) объекты

        Salary salary1 = new Salary(200_000, Salary.Currency.RUB);
        Salary salary2 = new Salary(3_000, Salary.Currency.USD);

        System.out.println(salary1);
        System.out.println(salary2);

        MySalaryComparator mySalaryComparator = new MySalaryComparator();

        int result = mySalaryComparator.compare(salary1, salary2);

        if(result < 0) {
            System.out.println(salary1 + " < " + salary2);
        } else if (result > 0){
            System.out.println(salary1 + " > " + salary2);
        } else {
            System.out.println(salary1 + " == " + salary2);
        }

        Set<Salary> mySet = new TreeSet<>(mySalaryComparator);
        mySet.add(salary1);
        mySet.add(salary2);

        System.out.println(mySet);
    }
}
