package com.aquaq.tinpui.exercises;

import java.io.*;
import java.util.*;

public class RecreateFiles {

    public static void createNewFile(final String[] stringArray, final String writeFileName) {
        File newFile;
        BufferedWriter bufferedWriter;

        try {
            newFile = new File(writeFileName);
            bufferedWriter = new BufferedWriter(new FileWriter(newFile));

            String stringLine;
            boolean firstLine = true;
            for (int index = 0; index < stringArray.length; index++) {
                stringLine = stringArray[index];
                if (processLineForNewFile(stringLine, bufferedWriter, firstLine)) {
                    firstLine = false;
                }
            }
        } catch (IOException e1) {
            System.out.println("An error occurred.");
        }
    }

    private static boolean processLineForNewFile(final String stringLine, BufferedWriter bufferedWriter, final boolean firstLine) throws IOException {
        if (stringLine.length() != 0) {
            char firstChar = stringLine.charAt(0);
            String stringToEnter = stringLine + " " + (int) firstChar;

            System.out.println(stringToEnter);
            if (!firstLine) {
                bufferedWriter.newLine();
            }
            bufferedWriter.write(stringToEnter);
            bufferedWriter.flush();
            return true;
        } else {
            return false;
        }
    }

    public static void createReorderedFile(final String[] stringArray, final String writeFileName) {
        File writeToFile;
        BufferedWriter bufferedWriter;

        String readLine;
        Integer lineNumber = 0;
        Map<Integer, String> stringToLineMap = new HashMap<>();

        try {
            writeToFile = new File(writeFileName);
            bufferedWriter = new BufferedWriter(new FileWriter(writeToFile));

            for (int index = 0; index < stringArray.length; index++) {
                readLine = stringArray[index];
                lineNumber++;
                stringToLineMap.put(lineNumber, readLine);
            }

            List<String> stringList = new ArrayList<>(Arrays.asList(stringArray));

            processStringListForReorderedFile(stringList, stringToLineMap, bufferedWriter);

            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Error occurred.");
        }
    }

    private static void processStringListForReorderedFile(List<String> stringList, Map<Integer, String> stringToLineMap, BufferedWriter bufferedWriter) throws IOException {
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
    }

    public static void createRemoveEmptyLinesFile(final String[] stringArray, final String writeFileName) {
        File writeToFile;
        BufferedWriter bufferedWriter;

        try {
            writeToFile = new File(writeFileName);
            bufferedWriter = new BufferedWriter(new FileWriter(writeToFile));

            boolean firstLine = true;
            for (int index = 0; index < stringArray.length; index++) {
                String stringLine = stringArray[index];
                if (processStringForRemoveEmptyLinesFile(stringLine, bufferedWriter, firstLine)) {
                    firstLine = false;
                }
            }

            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Error occurred.");
        }
    }

    private static boolean processStringForRemoveEmptyLinesFile(final String stringLine, BufferedWriter bufferedWriter, boolean firstLine) throws IOException {
        if (!stringLine.isEmpty()) {
            if (!firstLine) {
                bufferedWriter.newLine();
            }
            bufferedWriter.write(stringLine);
            bufferedWriter.flush();
            return true;
        } else {
            return false;
        }
    }

}