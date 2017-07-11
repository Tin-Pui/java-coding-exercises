# java-coding-exercises

The codingexercises directory contains solutions in Java to a few exercises.

## Table of Contents

1. [Exercises](#exercises)
2. [Solutions](#solutions)

## Exercises

### Part A

Read in the file num.txt and sum the values of all the lines which contain numeric data.

### Part B

Create a new file in your local home directory called num2.txt so that each row of the new file contains the original file, and a second character on each line representing the ascii character code of the existing line entry.

### Part C

If the file num.txt was orderd in terms of lexicorgraphy (i.e. alphabetically) create a new file num3.txt that has the origional line, and the position of the line in the ordered file.

### Part D

Remove any blank lines from the file and save the file as num4.txt in your local directory.

## Solutions

The solutions are implemented in Java with the main method in the Runner class. The num.txt file is read using a BufferedReader and a String array is generated (one String for each line) for use in the methods in the RecreateFiles class.

### Part A

Each String is parsed to an Integer, using a try catch to handle any NumberFormatExceptions.

### Part B

For each String, a new String is created with the ASCII code of the first character of the String added. The new String is used for writing into the new file.

### Part C

A Hashmap is used to keep track of the String associated with the line numbers in the original file. A list of Strings is sorted and each String in the list is used to match the Strings in the map to get their original line number. The String and its entry in the Hashmap is then removed afterwards so that each String is matched back to their unique original line number. This ensures similar Strings are not matched back to the same line number. The intended result is that the new file would have all the Strings arranged in lexicographical order and shows their line number from the original file.

### Part D

Lines of non-zero length are written in the new file.

**[Back to top](#table-of-contents)**
