package org.example.lombok;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MainLombok {

    public static void main(String[] args) throws JsonProcessingException {
        CarEntity car = new CarEntity("red", "tesla", "X000XX16");

        ObjectMapper objectMapper = new ObjectMapper();
        String serialized = objectMapper.writeValueAsString(car);
        System.out.println(serialized);

        String another = "{\"color\":\"yellow\",\"model\":\"vesta\",\"number\":\"X111XX16\"}";
        CarEntity car2 = objectMapper.readValue(another, CarEntity.class);
        System.out.println(car2);
    }
}
