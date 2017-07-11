package com.aquaq.tinpui.exercises;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by tchan on 04/07/17.
 */
public class TotalNumbers {

    public static int totalNum(final String fileName) {
        BufferedReader bufferedReader;
        String stringLine;
        File readInFile;

        int total = 0;

        try {
            readInFile = new File(fileName);
            bufferedReader = new BufferedReader(new FileReader(readInFile));

            stringLine = bufferedReader.readLine();
            while (stringLine != null) {
                total += getIntFromString(stringLine);
                stringLine = bufferedReader.readLine();
            }

            bufferedReader.close();
        } catch (IOException e1) {
            System.out.println("Couldn't read file.");
        }

        return total;
    }

    public static int totalNum(final String[] stringArray) {
        int total = 0;
        for (String stringLine : stringArray) {
            total += getIntFromString(stringLine);
        }
        return total;
    }

    private static Integer getIntFromString(String string) {
        Integer intValue = 0;
        if (string.matches("[0-9]+")) {
            intValue = Integer.parseInt(string);
        }
        return intValue;
    }

}
