import java.io.*;
import java.util.*;
import java.util.Map.Entry;

/**
 * Created by Tin-Pui.Chan on 13/06/2017.
 */
public class Runner {

    public static void main(String[] args){
        String fileName = "num.txt";
        System.out.println(totalNum(fileName));
        createNewFile(fileName, "num2.txt");
        createReorderedFile(fileName, "num3.txt");
        createRemoveEmptyLinesFile(fileName, "num4.txt");
    }

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
                for (Entry<Integer, String> entry : stringToLineMap.entrySet()) {
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