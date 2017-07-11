package com.aquaq.tinpui.exercises;

import java.io.IOException;

public class Runner {

    public static void main(String[] args){
        String fileName = "num.txt";
        String filePath = Thread.currentThread().getContextClassLoader().getResource(fileName).getPath();
        System.out.println(filePath);
        try {
            String[] stringArray = TextFileToStringArray.getStringArray(filePath);
            System.out.println(TotalNumbers.totalNum(stringArray));
            RecreateFiles.createNewFile(stringArray, "target/num2.txt");
            RecreateFiles.createReorderedFile(stringArray, "target/num3.txt");
            RecreateFiles.createRemoveEmptyLinesFile(stringArray, "target/num4.txt");
        } catch (IOException exception) {
            System.out.println("Failed to read from file: " + filePath);
        }
    }

}