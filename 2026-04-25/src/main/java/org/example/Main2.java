package org.example;

import org.example.framework.DocumentsFramework;
import org.example.models.Act;
import org.example.models.Letter;
import org.example.models.Statement;

import java.time.LocalDate;
import java.util.function.Supplier;

public class Main2 {
    public static void main(String[] args) {
        DocumentsFramework framework = new DocumentsFramework();

        Letter letter = framework.generate(Letter.class,
                "marsel@mail.ru");
        System.out.println(letter);
    }
}