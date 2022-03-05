package com.matej.app;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

import static com.matej.app.Reading.read;

/**
 * Hello world!
 *
 */
public class App 
{
    public static String link = "https://jisho.org/api/v1/search/words?keyword=";
    public static char arr[];
    public static Random rand = new Random();
    public static ArrayList<String> correctMeanings;

    public static void main( String[] args ) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        //System.out.println("Enter a word");
        //String word = scanner.nextLine();
        arr = toArray("C:\\Users\\matvr\\Desktop\\GIT-repository\\my-app\\src\\main\\java\\com\\matej\\app\\N4.txt");
        while(!exit){
            int number = rand.nextInt(arr.length);
            correctMeanings = getResults(arr[number]);
            System.out.println("Kanji: " + arr[number]);
            System.out.print("Guess: ");
            String input = scanner.nextLine();
            if(input == "exit"){
                exit = true;
            }
            else {
                checkGuess(input, correctMeanings);
            }
        }



        /*


        }
         */
    }

    public static char[] toArray(String inputFile) throws FileNotFoundException {
        File file = new File(inputFile);
        Scanner reader = new Scanner(file);
        arr = reader.nextLine().toCharArray();
        return arr;
    }

    public static ArrayList<String> getResults(char kanji) throws IOException, InterruptedException {
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
        Iterator<JsonNode> it = arrayNode.elements();
        while(it.hasNext()){
            results.add(it.next().asText());
        }
        return results;
    }

    public static int checkGuess(String input, ArrayList<String> answers){
        for(String s : answers){
            if(input.compareTo(s) == 0){
                //System.out.println("Correct!");
                //System.out.print("Correct solutions are: ");
                //System.out.println(answers);
                return 1;
            }
        }
        //System.out.println("Incorrect!");
        //System.out.print("Correct solutions are: ");
        //System.out.println(answers);
        return -1;
    }
}
