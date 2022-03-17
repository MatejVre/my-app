package com.matej.app;

import com.matej.app.App;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import static com.matej.app.KanjiApp.checkGuess;

public class GUIForm{
    public JTextField textField;
    public JLabel kanji;
    public JLabel correctMessage;
    public JLabel meanings;
    public JPanel panel;
    public JLabel username;
    public JLabel correctGuesses;
    public JLabel wrongGuesses;
    public JLabel percentage;
    public static Graphics g;


    public GUIForm(String color) throws IOException {
        switch (color){
            case "gray":
                panel.setBackground(new Color(71, 71 , 71));
                kanji.setForeground(new Color(255,255,255));
                username.setForeground(new Color(255,255,255));
                correctGuesses.setForeground(new Color(255,255,255));
                wrongGuesses.setForeground(new Color(255,255,255));
                percentage.setForeground(new Color(255,255,255));
                meanings.setForeground(new Color(255,255,255));
                break;
            case "purple":
                panel.setBackground(new Color(116, 82 , 162));
                kanji.setForeground(new Color(255,255,255));
                username.setForeground(new Color(255,255,255));
                correctGuesses.setForeground(new Color(255,255,255));
                wrongGuesses.setForeground(new Color(255,255,255));
                percentage.setForeground(new Color(255,255,255));
                meanings.setForeground(new Color(255,255,255));
                break;
            case "red":
                panel.setBackground(new Color(137, 79 , 98));
                break;
            case "blue":
                panel.setBackground(new Color(21, 52 , 80));
                kanji.setForeground(new Color(255,255,255));
                username.setForeground(new Color(255,255,255));
                correctGuesses.setForeground(new Color(255,255,255));
                wrongGuesses.setForeground(new Color(255,255,255));
                percentage.setForeground(new Color(255,255,255));
                meanings.setForeground(new Color(255,255,255));
                break;
            case "green":
                panel.setBackground(new Color(137,181,181));
                break;
            case "yellow":
                panel.setBackground(new Color(250,250, 150));
                break;
            case "brown":
                panel.setBackground(new Color(126,46, 31));
                kanji.setForeground(new Color(255,255,255));
                username.setForeground(new Color(255,255,255));
                correctGuesses.setForeground(new Color(255,255,255));
                wrongGuesses.setForeground(new Color(255,255,255));
                percentage.setForeground(new Color(255,255,255));
                meanings.setForeground(new Color(255,255,255));
        }

        //meanings.setForeground(new Color(255,255,255));
        kanji.setFont(new Font("Serif", Font.PLAIN, 70));
        correctMessage.setFont(new Font("Serif", Font.PLAIN, 35));
        meanings.setFont(new Font("Serif", Font.PLAIN, 35));
        username.setFont(new Font("Serif", Font.PLAIN, 18));
        correctGuesses.setFont(new Font("Serif", Font.PLAIN, 18));
        wrongGuesses.setFont(new Font("Serif", Font.PLAIN, 18));
        percentage.setFont(new Font("Serif", Font.PLAIN, 18));



    }





}
