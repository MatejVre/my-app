package com.matej.app;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Scanner;

import static com.matej.app.Reading.read;

/**
 * Hello world!
 *
 */
public class App 
{
    public static String link = "https://jisho.org/api/v1/search/words?keyword=";

    public static void main( String[] args ) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        //System.out.println("Enter a word");
        //String word = scanner.nextLine();
        ArrayList<String> array = read("C:\\Users\\matvr\\Desktop\\GIT-repository\\my-app\\src\\main\\java\\com\\matej\\app\\words.txt");
        String word;

        HttpClient client = HttpClient.newHttpClient();
        for(String s : array) {
            HttpRequest request = HttpRequest.newBuilder()
                    .header("Content-Type", "application/json")
                    .uri(URI.create(link + s))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(response.body().toString());

            System.out.println(jsonNode.get("data").get(0).get("slug") + " - " + jsonNode.get("data").get(0).get("japanese").get(0).get("reading") + " - " +
                    jsonNode.get("data").get(0).get("senses").get(0).get("parts_of_speech").get(0));

        }
    }
}
