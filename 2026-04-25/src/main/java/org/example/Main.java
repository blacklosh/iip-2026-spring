package org.example;

import org.example.framework.DocumentsFramework;
import org.example.models.Act;
import org.example.models.Letter;
import org.example.models.Statement;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        DocumentsFramework framework = new DocumentsFramework();

        Letter letter = framework.generate(Letter.class,
                "marsel@mail.ru",
                LocalDate.now());
        System.out.println(letter);

        Letter letter2 = framework.generate(Letter.class,
                "fedor@mail.ru",
                "marsel@mail.ru",
                "Состояние сети",
                LocalDate.now());
        System.out.println(letter2);

        Act act = framework.generate(Act.class, "Акт сверки");
        System.out.println(act);

        Statement statement = framework.generate(Statement.class,
                "Уход по собственному желанию",
                "Увольнение");
        System.out.println(statement);
    }
}