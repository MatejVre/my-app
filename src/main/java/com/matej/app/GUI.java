package com.matej.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class GUI extends App{
    private static Random random = new Random();
    private static String filename = "N4.txt";
    private static final int SIZE = 750;
    private static JFrame frame = new JFrame();
    private static JPanel panel = new JPanel();
    private static JTextField textField = new JTextField();
    private static JLabel label = new JLabel();
    private static JLabel correctMessage = new JLabel();
    private static JLabel meanings = new JLabel();
    private static boolean inputted = false;
    private static JOptionPane optionPane = new JOptionPane();
    private static JRadioButton n5 = new JRadioButton("n5");
    private static JRadioButton n4 = new JRadioButton("n4");
    private static JRadioButton n3 = new JRadioButton("n3");
    private static JRadioButton n2 = new JRadioButton("n2");
    private static JRadioButton n1 = new JRadioButton("n1");
    private static String currentKanji;

    public static void main(String[] args) throws IOException, InterruptedException {
        setup();
        while(true) {
            getLabelWithResult();
            while(!inputted){
                Thread.sleep(200);
            }
            Thread.sleep(1500);
            resetPanel();
        }
    }

    public static void setup() throws FileNotFoundException {
        setBoundsAndSizes();
        //creating a radio button for the option pane

        n1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filename = "N1.txt";
            }
        });
        n2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filename = "N2.txt";
            }
        });
        n3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filename = "N3.txt";
            }
        });
        n4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filename = "N4.txt";
            }
        });
        n5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filename = "N5.txt";
            }
        });

        JPanel customPanel = new JPanel();
        customPanel.add(n5);
        customPanel.add(n4);
        customPanel.add(n3);
        customPanel.add(n2);
        //customPanel.add(n1);
        optionPane.showMessageDialog(null, customPanel, "Choose your desired level", JOptionPane.INFORMATION_MESSAGE);

        frame.setSize(SIZE, SIZE);
        panel.setSize(SIZE, SIZE);
        frame.add(panel);
        frame.setLayout(null);
        panel.setLayout(null);
        panel.add(textField);
        panel.add(correctMessage);
        panel.add(meanings);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        KanjiApp.toKanjiArray(PATH_TO_FILES + filename);
    }

    public static void getLabelWithResult() throws IOException, InterruptedException {
        inputted = false;
        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkGuess(textField.getText(), correctMeanings);
                panel.repaint();
                inputted = true;
            }
        });
        int index = random.nextInt(kanjiArr.length);
        String text = String.valueOf(kanjiArr[index]);
        currentKanji = text;
        label.setText(text);

        panel.add(label);
        panel.repaint();
        correctMeanings = getResults(text);
        System.out.println(correctMeanings);
    }

    public static int checkGuess(String input, ArrayList<String> answers){
        String results = answers.toString();
        for(String s : answers){
            if(s.contains(input)){
                correctMessage.setText("Correct!");
                //System.out.print("Correct solutions are: ");
                //System.out.println(answers);
                //System.out.print("Reading: ");
                //System.out.println(reading);
                meanings.setText(results);

                return 1;
            }
        }
        correctMessage.setText("Incorrect!");
        //System.out.print("Correct solutions are: ");
        //System.out.println(answers);
        //System.out.print("Reading: ");
        //System.out.println(reading);
        meanings.setText(results);
        return -1;
    }

    public static void resetPanel(){
        correctMessage.setText("");
        textField.setText("");
        meanings.setText("");
    }

    public static void setBoundsAndSizes(){
        textField.setBounds((SIZE - 150)/2, (SIZE-30)/3, 150, 30);
        correctMessage.setFont(new Font("Serif", Font.PLAIN, 35));
        correctMessage.setBounds((SIZE - 150)/2, (SIZE-65)/2, 150, 65);
        meanings.setFont(new Font("Serif", Font.PLAIN, 35));
        meanings.setBounds((SIZE - 500)/2, 500, 500, 65);
        label.setFont(new Font("Serif", Font.PLAIN, 65));
        label.setBounds((SIZE - 100)/2, (SIZE-70)/7, 400, 100);
    }
}
