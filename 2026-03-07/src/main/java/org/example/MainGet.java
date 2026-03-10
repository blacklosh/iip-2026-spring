package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainGet {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://185.221.160.131/api/v1/students");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String result = "";
        while (br.ready()) {
            result += br.readLine() + "\n";
        }
        br.close();
        System.out.println("RESPONSE: " + result);

        List<UserEntity> users = new ArrayList<>();
        result = result.replaceAll("\\[\\{]", "");
        result = result.replaceAll("}]", "");
        result = result.replaceAll("\n", "");
        String[] objects = result.split("},\\{");
        for(String str : objects) {
            UserEntity user = new UserEntity();
            String[] parts = str.split(",");
            for(String part : parts) {
                String correctedPart = part.replaceAll("\"", "");
                String[] elements = correctedPart.split(":");
                if("id".equals(elements[0])) {
                    user.setId(Long.parseLong(elements[1]));
                } else if("name".equals(elements[0])) {
                    user.setName(elements[1]);
                } else if("lastName".equals(elements[0])) {
                    user.setLastName(elements[1]);
                } else if("favoriteSubject".equals(elements[0])) {
                    user.setFavoriteSubject(elements[1]);
                } else if("favoriteDayOfWeek".equals(elements[0])) {
                    user.setFavoriteDayOfWeek(elements[1]);
                } else if("favoriteSeason".equals(elements[0])) {
                    user.setFavoriteSeason(elements[1]);
                } else if("favoriteArtist".equals(elements[0])) {
                    user.setFavoriteArtist(elements[1]);
                }
            }
            users.add(user);
        }

        System.out.println(users);
    }
}