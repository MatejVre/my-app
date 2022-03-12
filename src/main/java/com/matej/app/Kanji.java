package com.matej.app;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Scanner;

import static com.matej.app.Reading.read;

public class Kanji {
    public static String link = "https://kanjiapi.dev/v1/kanji/";

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        FileWriter n5 = new FileWriter("C:\\Users\\matvr\\Desktop\\GIT-repository\\my-app\\src\\main\\java\\com\\matej\\app\\N5.txt");
        FileWriter n4 = new FileWriter("C:\\Users\\matvr\\Desktop\\GIT-repository\\my-app\\src\\main\\java\\com\\matej\\app\\N4.txt");
        FileWriter n3 = new FileWriter("C:\\Users\\matvr\\Desktop\\GIT-repository\\my-app\\src\\main\\java\\com\\matej\\app\\N3.txt");
        FileWriter n2 = new FileWriter("C:\\Users\\matvr\\Desktop\\GIT-repository\\my-app\\src\\main\\java\\com\\matej\\app\\N2.txt");
        FileWriter n1 = new FileWriter("C:\\Users\\matvr\\Desktop\\GIT-repository\\my-app\\src\\main\\java\\com\\matej\\app\\N1.txt");
        ArrayList<String> array = read("C:\\Users\\matvr\\Desktop\\GIT-repository\\my-app\\src\\main\\java\\com\\matej\\app\\words.txt");


        HttpClient client = HttpClient.newHttpClient();
        for (String s : array) {
            HttpRequest request = HttpRequest.newBuilder()
                    .header("Content-Type", "application/json")
                    .uri(URI.create("https://jisho.org/api/v1/search/words?keyword= something to ruin the ling" + s))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(response.body().toString());
            String level = jsonNode.get("data").get(0).get("jlpt").get(0).asText();
            System.out.println(level);
            switch(level){
                case "jlpt-n5":
                    n5.write(s);
                case "jlpt-n4":
                    n4.write(s);
                case "jlpt-n3":
                    n3.write(s);
                case "jlpt-n2":
                    n2.write(s);
                case "jlpt-n1":
                    n1.write(s);
            }
            Thread.sleep(200);
        }
        n5.close();
        n4.close();
        n3.close();
        n2.close();
        n1.close();
    }

}