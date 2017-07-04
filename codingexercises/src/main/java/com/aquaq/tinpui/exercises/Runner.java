package com.aquaq.tinpui.exercises;

/**
 * Created by Tin-Pui.Chan on 13/06/2017.
 */
public class Runner {

    public static void main(String[] args){
        String fileName = "src/main/resources/num.txt";
        System.out.println(TotalNumbers.totalNum(fileName));
        RecreateFiles.createNewFile(fileName, "num2.txt");
        RecreateFiles.createReorderedFile(fileName, "num3.txt");
        RecreateFiles.createRemoveEmptyLinesFile(fileName, "num4.txt");
    }

}