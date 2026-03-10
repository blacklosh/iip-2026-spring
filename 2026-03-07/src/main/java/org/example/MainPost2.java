package org.example;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainPost2 {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://185.221.160.131/api/v1/transactions");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/json");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
        bw.write("""
                {
                       "userIdFrom": 27,
                       "userIdTo": 15,
                       "amount": 100
                }
                """);
        bw.close();
        connection.connect();
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String result = "";
        while (br.ready()) {
            result += br.readLine() + "\n";
        }
        br.close();
        System.out.println("RESPONSE: " + result);
    }
}