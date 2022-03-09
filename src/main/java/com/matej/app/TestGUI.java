/*
package com.matej.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestGUI extends App {
    public static final int width = 1980;
    public static final int height = 1200;
    public static final int kanjiSize = 150;
    public static boolean exit = false;
    public static JFrame f = new JFrame("KanjiGuesser");//creating instance of JFrame

    public static JLabel l = new JLabel();
    public static JLabel correctMessage = new JLabel();
    public static JTextField t = new JTextField();



    public static void main(String[] args) throws IOException, InterruptedException {
        f.add(l);
        f.add(t);
        f.add(correctMessage);
        f.setSize(width, height);//500 width and 500 height
        f.setLayout(null);//using no layout managers
        f.setVisible(true);//making the frame visible
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        l.setFont(new Font("Serif", Font.PLAIN, 65));
        l.setBounds(width / 2 - 65, height / 10, kanjiSize, kanjiSize);
        t.setBounds(width / 2 - 175, height / 5, 300, 30);
        JOptionPane.showMessageDialog(f,"Welcome to KanjiGuesser!");

        t.addActionListener(listener);

        run();
    }

    public static void run() throws IOException, InterruptedException {
            t.setText("");
            correctMessage.setBounds(width / 2 - 100, height / 2, 100, 30);
            //This takes care of taking a random character and displaying it. Bound to N4 kanji for now.
            arr = toArray("C:\\Users\\matvr\\Desktop\\GIT-repository\\my-app\\src\\main\\java\\com\\matej\\app\\N4.txt");
            int number = rand.nextInt(arr.length);
            correctMeanings = getResults(arr[number]);
            l.setText(Character.toString(arr[number]));
    }

    public static ActionListener listener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if (checkGuess(t.getText(), correctMeanings) == 1) {
                correctMessage.setText("CORRECT!");
            } else if (checkGuess(t.getText(), correctMeanings) == -1) {
                correctMessage.setText("INCORRECT!");
            }
            f.repaint();
            exit = true;
        }
    };
}*/
