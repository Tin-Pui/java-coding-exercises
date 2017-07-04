package com.aquaq.tinpui.exercises;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by tchan on 04/07/17.
 */
public class TotalNumbers {

    public static int totalNum(final String fileName){
        BufferedReader bufferedReader;
        String stringLine;
        File readInFile;

        int total = 0;

        try{
            readInFile = new File(fileName);
            bufferedReader = new BufferedReader(new FileReader(readInFile));

            stringLine = bufferedReader.readLine();
            while(stringLine != null) {
                Integer intValue = 0;
                try {
                    intValue = Integer.parseInt(stringLine);
                } catch (NumberFormatException formatExc){
                    System.out.println("Not an integer.");
                }

                total += intValue;
                stringLine = bufferedReader.readLine();
            }

            bufferedReader.close();
        } catch (IOException e1){
            System.out.println("Couldn't read file.");
        }

        return total;
    }

}
