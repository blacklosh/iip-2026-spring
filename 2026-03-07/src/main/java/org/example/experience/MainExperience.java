package org.example.experience;

import org.example.UserEntity;
import org.example.lombok.CarEntity;

public class MainExperience {

    public static void main(String[] args) {
        // NOT WORKING CODE, JUST EXAMPLE!
        MyHttpClient<CarEntity, UserEntity> myHttpClient = new MyHttpClientImpl<>();

        myHttpClient.setUrl("http://example.ru");
        myHttpClient.setMethod("POST");
        myHttpClient.setPayload(new CarEntity());

        UserEntity result = myHttpClient.connect();
    }
}
