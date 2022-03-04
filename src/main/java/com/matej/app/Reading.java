package com.matej.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reading {

    public static void main(String args[]) {
        read("C:\\Users\\matvr\\Desktop\\GIT-repository\\my-app\\src\\main\\java\\com\\matej\\app\\words.txt");

    }

    public static ArrayList<String> read(String filename) {
        ArrayList<String> list = new ArrayList<String>();
        try {
            File file = new File(filename);
            Scanner reader = new Scanner(file);
            while(reader.hasNext()){
                String data = reader.nextLine();
                list.add(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occured!");
            e.printStackTrace();
        }
        return list;
    }

    public static void addToFiles(){

    }
}