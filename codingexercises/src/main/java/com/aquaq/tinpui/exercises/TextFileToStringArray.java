package com.aquaq.tinpui.exercises;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by tchan on 10/07/17.
 */
public class TextFileToStringArray {

    public static String[] getStringArray(String fileName) throws IOException {
        ArrayList<String> stringList = new ArrayList<>();

        BufferedReader bufferedReader;
        String stringLine;
        File readInFile;

        readInFile = new File(fileName);
        bufferedReader = new BufferedReader(new FileReader(readInFile));

        stringLine = bufferedReader.readLine();

        while (stringLine != null) {
            stringList.add(stringLine);
            stringLine = bufferedReader.readLine();
        }

        return stringList.toArray(new String[0]);
    }

}
