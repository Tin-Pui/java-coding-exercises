package com.aquaq.tinpui.exercises;

import java.io.*;
import java.util.*;

public class RecreateFiles {

    /**
     * This method creates a new file using an existing text file, removes all empty lines and adds the ASCII character
     * code for the first character of each line at the end of the line.
     *
     * @param readFileName
     * @param writeFileName
     */
    public static void createNewFile(final String readFileName, final String writeFileName) {
        BufferedReader bufferedReader;
        String stringLine;
        File readInFile;

        File newFile;
        BufferedWriter bufferedWriter;
        try {
            readInFile = new File(readFileName);
            bufferedReader = new BufferedReader(new FileReader(readInFile));

            newFile = new File(writeFileName);
            bufferedWriter = new BufferedWriter(new FileWriter(newFile));

            stringLine = bufferedReader.readLine();

            boolean firstLine = true;
            while (stringLine != null) {
                if (processLineForNewFile(stringLine, bufferedWriter, firstLine)) {
                    firstLine = false;
                }
                stringLine = bufferedReader.readLine();
            }

            bufferedReader.close();
            bufferedWriter.close();
        } catch (IOException e1) {
            System.out.println("An error occurred.");
        }
    }

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

    private static boolean processLineForNewFile(final String stringLine, BufferedWriter bufferedWriter, boolean firstLine) throws IOException {
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
            readFromFile = new File(readFileName);
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

            processStringListForReorderedFile(stringList, stringToLineMap, bufferedWriter);

            bufferedReader.close();
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Error occurred.");
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

    public static void createRemoveEmptyLinesFile(final String readFileName, final String writeFileName) {
        File readFromFile;
        BufferedReader bufferedReader;

        File writeToFile;
        BufferedWriter bufferedWriter;

        String stringLine;

        try {
            readFromFile = new File(readFileName);
            bufferedReader = new BufferedReader(new FileReader(readFromFile));

            writeToFile = new File(writeFileName);
            bufferedWriter = new BufferedWriter(new FileWriter(writeToFile));

            stringLine = bufferedReader.readLine();
            boolean firstLine = true;
            while (stringLine != null) {
                if (processStringForRemoveEmptyLinesFile(stringLine, bufferedWriter, firstLine)) {
                    firstLine = false;
                }
                stringLine = bufferedReader.readLine();
            }

            bufferedReader.close();
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Error occurred.");
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