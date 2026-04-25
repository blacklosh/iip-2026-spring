package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.framework.DefaultValue;
import org.example.framework.PostConstruct;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Letter {

    @DefaultValue("mycompany@mail.ru")
    private String from;

    private String to;

    @DefaultValue("Бюджетный вопрос")
    private String content;

    @DefaultValue("2026-01-01")
    private LocalDate date;

    @PostConstruct
    public void postConstructionProcess() {
        System.out.println("Письмо: Я кладусь в конверт");
    }

    public Letter(String to, LocalDate date) {
        this.to = to;
        this.date = date;
    }

    public Letter(String to) {
        this.to = to;
    }
}
