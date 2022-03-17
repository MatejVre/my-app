package com.matej.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Options extends Run{
    JPanel optionsPanel;
    private JRadioButton grey;
    private JRadioButton red;
    private JRadioButton blue;
    private JRadioButton purple;
    private JRadioButton yellow;
    private JRadioButton brown;
    private JRadioButton green;
    private JButton confirmButton;

    private JComboBox comboBox1;



    public Options(){
        comboBox1.addItem("N5");
        comboBox1.addItem("N4");
        comboBox1.addItem("N3");
        comboBox1.addItem("N2");
        comboBox1.addItem("N1");
        grey.setText("GREY");
        purple.setText("PURPLE");
        green.setText("GREEN");
        red.setText("RED");
        blue.setText("BLUE");
        yellow.setText("YELLOW");
        brown.setText("BROWN");
        confirmButton.setText("Confirm");
        comboBox1.setSelectedIndex(0);
        grey.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                color = "grey";
            }
        });
        purple.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                color = "purple";
            }
        });
        red.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                color = "red";
            }
        });
        blue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                color = "blue";
            }
        });
        green.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                color = "green";
            }
        });
        yellow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                color = "yellow";
            }
        });
        brown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                color = "brown";
            }
        });
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                optionsDone = true;
            }
        });
        optionsPanel.setPreferredSize(new Dimension(1200,900));

        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox source = (JComboBox) e.getSource();
                JLPT = (String) comboBox1.getSelectedItem();
            }
        });

    }


}
