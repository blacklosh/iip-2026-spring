package org.example.lombok;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CarEntity {
    private String color;
    private String model;
    private String number;
}
