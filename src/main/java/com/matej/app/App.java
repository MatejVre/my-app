package com.matej.app;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static String link = "https://jisho.org/api/v1/search/words?keyword=";
    public static char kanjiArr[];
    public static ArrayList<String> wordsArr = new ArrayList<>();
    public static Random rand = new Random();
    public static ArrayList<String> correctMeanings;
    public static String reading;



    public static ArrayList<String> getResults(String kanji) throws IOException, InterruptedException {
        ArrayList<String> results = new ArrayList<>();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .header("Content-Type", "application/json")
                .uri(URI.create(link + kanji))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(response.body().toString());
        ArrayNode arrayNode = (ArrayNode) jsonNode.get("data").get(0).get("senses").get(0).get("english_definitions");
        reading = jsonNode.get("data").get(0).get("japanese").get(0).get("reading").asText();
        Iterator<JsonNode> it = arrayNode.elements();
        while(it.hasNext()){
            results.add(it.next().asText());
        }
        return results;
    }
}
