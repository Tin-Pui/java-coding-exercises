package com.aquaq.tinpui.exercises;

import java.io.*;
import java.util.*;

/**
 * Created by tchan on 04/07/17.
 */
public class RecreateFiles {

    /**
     * This method creates a new file using an existing text file, removes all empty lines and adds the ASCII character
     * code for the first character in each line at the end of the line.
     * @param fileName
     * @param newFileName
     */
    public static void createNewFile(final String fileName, final String newFileName){
        BufferedReader bufferedReader;
        String stringLine;
        File readInFile;

        File newFile;
        BufferedWriter bufferedWriter;
        try {
            readInFile = new File(fileName);
            bufferedReader = new BufferedReader(new FileReader(readInFile));

            newFile = new File(newFileName);
            bufferedWriter = new BufferedWriter(new FileWriter(newFile));

            stringLine = bufferedReader.readLine();
            char firstChar;

            int totalLines = 0;
            while (stringLine != null) {
                if(stringLine.length() != 0) {
                    firstChar = stringLine.charAt(0);
                    String stringToEnter = stringLine + " " + (int) firstChar;

                    System.out.println(stringToEnter);
                    if (totalLines > 0) {
                        bufferedWriter.newLine();
                    }
                    bufferedWriter.write(stringToEnter);
                    totalLines++;
                    bufferedWriter.flush();
                }
                stringLine = bufferedReader.readLine();
            }

            bufferedReader.close();
            bufferedWriter.close();
        } catch (IOException e1){
            System.out.println("An error occurred.");
        }
    }

    public static void createReorderedFile(final String readFileName, final String writeFileName) {
        File readFromFile;
        BufferedReader bufferedReader;

        File writeToFile;
        BufferedWriter bufferedWriter;

        String readLine;
        Integer lineNumber = 0;
        List<String> stringList = new ArrayList<>();
        Map<Integer, String> stringToLineMap = new HashMap<>();

        try {
            readFromFile  = new File(readFileName);
            bufferedReader = new BufferedReader(new FileReader(readFromFile));

            writeToFile = new File(writeFileName);
            bufferedWriter = new BufferedWriter(new FileWriter(writeToFile));

            readLine = bufferedReader.readLine();
            lineNumber++;
            while (readLine != null) {
                stringList.add(readLine);
                stringToLineMap.put(lineNumber, readLine);

                readLine = bufferedReader.readLine();
                lineNumber++;
            }

            Collections.sort(stringList);
            int totalLines = 0;
            while (!stringList.isEmpty()) {
                String currentString = stringList.get(0);
                Integer stringLineNumber = -1;
                for (Map.Entry<Integer, String> entry : stringToLineMap.entrySet()) {
                    if (Objects.equals(currentString, entry.getValue())) {
                        stringLineNumber = entry.getKey();
                        if (totalLines > 0) {
                            bufferedWriter.newLine();
                        }
                        bufferedWriter.write(stringLineNumber + "\t" + currentString);
                        totalLines++;
                        bufferedWriter.flush();
                        break;
                    }
                }
                stringList.remove(currentString);
                stringToLineMap.remove(stringLineNumber);
            }

            bufferedReader.close();
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Error occurred.");
        }
    }

    public static void createRemoveEmptyLinesFile(final String readFileName, final String writeFileName) {
        File readFromFile;
        BufferedReader bufferedReader;

        File writeToFile;
        BufferedWriter bufferedWriter;

        String readLine;

        try {
            readFromFile = new File(readFileName);
            bufferedReader = new BufferedReader(new FileReader(readFromFile));

            writeToFile = new File(writeFileName);
            bufferedWriter = new BufferedWriter(new FileWriter(writeToFile));

            readLine = bufferedReader.readLine();
            int totalLines = 0;
            while (readLine != null) {
                if (!readLine.isEmpty()) {
                    if (totalLines > 0) {
                        bufferedWriter.newLine();
                    }
                    bufferedWriter.write(readLine);
                    totalLines++;
                    bufferedWriter.flush();
                }
                readLine = bufferedReader.readLine();
            }

            bufferedReader.close();
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Error occurred.");
        }
    }

}
