package com.matej.app;

public class User {

    private String name;

    private int numberOfCorrectGuesses;

    private int numberOfWrongGuesses;

    private int numberOfGuesses;

    private float correctGuessPercentage;

    public User(String name){
        this.name = name;
        numberOfCorrectGuesses = 0;
        numberOfWrongGuesses = 0;
        correctGuessPercentage = 0;
    }

    public void update(int guess){
        numberOfGuesses ++;
        if(guess == 1){
            numberOfCorrectGuesses ++;
        }
        else if(guess == -1){
            numberOfWrongGuesses ++;
        }
        correctGuessPercentage = (float)numberOfCorrectGuesses/numberOfGuesses;
    }

    public void setNumberOfCorrectGuesses(int num){
        numberOfCorrectGuesses = num;
    }

    public void setNumberOfWrongGuesses(int num){
        numberOfWrongGuesses = num;
    }

    public float getCorrectGuessPercentage(){
        return correctGuessPercentage;
    }

    public int getNumberOfCorrectGuesses() {
        return numberOfCorrectGuesses;
    }

    public int getNumberOfWrongGuesses() {
        return numberOfWrongGuesses;
    }

    public String getName() {
        return name;
    }
}