package com.aquaq.tinpui.exercises;

import java.io.IOException;

/**
 * Created by Tin-Pui.Chan on 13/06/2017.
 */
public class Runner {

    public static void main(String[] args){
        String fileName = "src/main/resources/num.txt";

        try {
            String[] stringArray = TextFileToStringArray.getStringArray(fileName);
            System.out.println(TotalNumbers.totalNum(stringArray));
            RecreateFiles.createNewFile(fileName, "num2.txt");
            RecreateFiles.createReorderedFile(stringArray, "num3.txt");
            RecreateFiles.createRemoveEmptyLinesFile(stringArray, "num4.txt");
        } catch (IOException exception) {
            System.out.println("Failed to read from file.");
        }
    }

}