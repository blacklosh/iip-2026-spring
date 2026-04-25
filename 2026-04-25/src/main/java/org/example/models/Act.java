package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.framework.DefaultValue;

@Data
@AllArgsConstructor
public class Act {

    private String title;

    @DefaultValue("mycompany@gmail.ru")
    private String author;

    public Act(String title) {
        this.title = title;
    }
}
