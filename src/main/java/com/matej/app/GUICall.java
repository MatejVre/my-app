package com.matej.app;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;



public class GUICall extends Run{
    public static String link = "https://kanjiapi.dev/v1/kanji/";
    private static boolean inputted;
    private static Random random = new Random();
    private static String currentKanji;
    static GUIForm form;
    private static User user = new User("Matej");


    public static void main(String[] args) throws IOException, InterruptedException {
        run();
    }

    public GUICall() throws IOException, InterruptedException {
        form = new GUIForm(color);
        form.panel.setPreferredSize(new Dimension(1200,900));

    }

    public static void setup() throws IOException {

        KanjiApp.toKanjiArray(PATH_TO_FILES + JLPT + ".txt");
        frame.setVisible(true);
        form.textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                    checkGuess(form.textField.getText(), correctMeanings);
                    inputted = true;
                }
            }
        });
        resetText();

    }

    public static void resetText(){
        form.kanji.setText("");
        form.correctMessage.setText(" ");
        form.meanings.setText(" ");
        form.textField.setText("");
    }

    public static void getLabelWithResult() throws IOException, InterruptedException {
        inputted = false;
        int index = random.nextInt(kanjiArr.length);
        String text = String.valueOf(kanjiArr[index]);
        currentKanji = text;
        form.kanji.setText(text);
        form.panel.repaint();
        correctMeanings = getResultsKanji(text);
        //System.out.println(correctMeanings);
    }

    public static int checkGuess(String input, ArrayList<String> answers){
        String results = answers.toString();
        for(String s : answers){
            if(s.contains(input)){
                user.update(1);
                form.correctMessage.setForeground(Color.green);
                form.correctMessage.setText("Correct!");
                form.meanings.setText(results);
                return 1;
            }
        }
        user.update(-1);
        form.correctMessage.setForeground(Color.red);
        form.correctMessage.setText("Incorrect!");
        form.meanings.setText(results);
        return -1;
    }

    public static void setUser(){
        form.username.setText("Username: " + user.getName());
        form.correctGuesses.setText("Correct guesses: " + user.getNumberOfCorrectGuesses());
        form.wrongGuesses.setText("Wrong guesses: " + user.getNumberOfWrongGuesses());
        form.percentage.setText("Guess percentage: " + user.getCorrectGuessPercentage());
    }
    public static void run() throws IOException, InterruptedException {
        setup();
        setUser();
        while(true) {
            getLabelWithResult();
            while(!inputted){
                Thread.sleep(200);
            }
            Thread.sleep(1500);
            setUser();
            resetText();
        }
    }
    public static ArrayList<String> getResultsKanji(String text) throws IOException, InterruptedException {
        ArrayList<String> results = new ArrayList<>();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .header("Content-Type", "application/json")
                .uri(URI.create(link + text))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(response.body().toString());
        ArrayNode arrayNode = (ArrayNode) jsonNode.get("meanings");

        Iterator<JsonNode> it = arrayNode.elements();
        while(it.hasNext()){
            results.add(it.next().asText());
        }
        return results;
    }


}
