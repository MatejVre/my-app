package com.matej.app;

import javax.swing.*;
import java.awt.*;

import static javax.swing.SwingConstants.CENTER;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class GUI {
    private static final int SIZE = 750;
    private static JFrame frame = new JFrame();
    private static JPanel panel = new JPanel();
    private static GridBagLayout layout = new GridBagLayout();
    private static JTextField textField = new JTextField();
    private static JLabel label = new JLabel();

    public static void main(String[] args){
        setup();
        getLabel();
    }

    public static void setup(){
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridwidth = 3;
        constraints.gridheight = 3;
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.ipadx = 150;
        constraints.ipady = 15;
        constraints.anchor = GridBagConstraints.CENTER;

        textField.setSize(60, 20);
        frame.setSize(SIZE, SIZE);
        panel.setSize(SIZE, SIZE);
        frame.add(panel, constraints);
        frame.setLayout(layout);
        panel.setLayout(layout);
        panel.add(textField);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void getLabel(){
        GridBagConstraints constraints = new GridBagConstraints();
        label.setText("亜");
        label.setFont(new Font("Serif", Font.PLAIN, 65));
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.BOTH;
        panel.add(label, constraints);

    }
}
