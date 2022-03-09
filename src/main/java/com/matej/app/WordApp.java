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

public class WordApp extends App
{


    public static void main( String[] args ) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        //System.out.println("Enter a word");
        //String word = scanner.nextLine();
        toWordsArray("C:\\Users\\matvr\\Desktop\\GIT-repository\\my-app\\src\\main\\java\\com\\matej\\app\\words.txt");

        while(!exit){
            int number = rand.nextInt(wordsArr.size());
            correctMeanings = getResults(wordsArr.get(number));
            System.out.println("Word: " + wordsArr.get(number));
            System.out.print("Guess: ");
            String input = scanner.nextLine();
            if(input == "exit"){
                exit = true;
            }
            else {
                checkGuess(input, correctMeanings);
            }
        }






        }


    public static void toWordsArray(String inputFile) throws FileNotFoundException {
        File file = new File(inputFile);
        Scanner scan = new Scanner(file);
        while(scan.hasNextLine()){
            wordsArr.add(scan.nextLine());
        }
    }


    public static int checkGuess(String input, ArrayList<String> answers){
        for(String s : answers){
            if(input.compareTo(s) == 0){
                System.out.println("Correct!");
                System.out.print("Correct solutions are: ");
                System.out.println(answers);
                System.out.print("Reading: ");
                System.out.println(reading);
                return 1;
            }
        }
        System.out.println("Incorrect!");
        System.out.print("Correct solutions are: ");
        System.out.println(answers);
        System.out.print("Reading: ");
        System.out.println(reading);
        return -1;
    }
}
