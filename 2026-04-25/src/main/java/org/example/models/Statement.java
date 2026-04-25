package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.framework.DefaultValue;

@Data
@AllArgsConstructor
public class Statement {

    private String reason;

    private String type;

    @DefaultValue("Физическое лицо")
    private String actor;

    public Statement(String reason, String type) {
        this.reason = reason;
        this.type = type;
    }
}
