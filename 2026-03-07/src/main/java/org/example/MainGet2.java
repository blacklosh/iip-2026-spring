package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MainGet2 {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

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

        List<UserEntity> users = mapper.readValue(result, new TypeReference<>() {});

        System.out.println(users);
        System.out.println(solve2(users));
        solve3(users);
        System.out.println(solve4(users));
    }

    public static String solve2(List<UserEntity> users) {
        return users.stream()
                .map(UserEntity::getFavoriteSubject)
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Нет");
    }

    public static void solve3(List<UserEntity> users) {
        String string = users.stream()
                .map(UserEntity::getFavoriteDayOfWeek)
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .toString();
        System.out.println(string);

    }

    public static boolean solve4(List<UserEntity> users) {
         return users.stream()
                .filter(u -> u.getFavoriteSeason().equals("Summer") || u.getFavoriteSeason().equals("Spring"))
                .count() > users.size() / 2;
    }
}