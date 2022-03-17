package com.matej.app;


import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Run extends App{
    static JFrame frame;
    static GUICall call;
    public static String color = "grey";
    public static boolean optionsDone = false;
    public static String JLPT = "N3.txt";
    public static void main(String[] args) throws IOException, InterruptedException {
        frame = new JFrame();
        JPanel panel = new JPanel();
        Options options = new Options();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(options.optionsPanel);
        frame.pack();
        frame.setVisible(true);
        while(!optionsDone){
            Thread.sleep(200);
        }
        changePane();
    }

    public static void changePane() throws IOException, InterruptedException {
        call = new GUICall();
        frame.getContentPane().removeAll();
        frame.setContentPane(call.form.panel);
        frame.pack();
        frame.revalidate();
        frame.repaint();
        call.run();
    }


}
