package com.bl.censusAnalyser;

import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

public class ReadOperations {

    public void readData(String fileName) throws StateCensusAnalyserException, FileNotFoundException {
        File file = new File(fileName);

        Scanner scanner = null;
        try {
        if (!file.exists()){
            throw new StateCensusAnalyserException("The file does not exist");
        }
            scanner = new Scanner(file);
        while (scanner.hasNext()){
            System.out.println(scanner.next());
        }
        } catch (StateCensusAnalyserException e) {
            System.out.println(e.getMessage());
        }
    }

    public int readDataCount(final String filePath) throws StateCensusAnalyserException {
        AtomicBoolean firstLine = new AtomicBoolean(true);
        AtomicInteger count = new AtomicInteger();
        try {
            Files.lines(Paths.get(filePath))
                    .forEach(lines -> {
                        if (lines.startsWith("State")) {
                            firstLine.set(false);
                        } else {
                            lines.split("\n");
                            count.getAndIncrement();
                            System.out.println(lines);
                        }

                    });
            System.out.println("\nCount : " + count);

        } catch (IOException e) {
            throw new StateCensusAnalyserException("Enter Correct File Name");
        }
        int countOfRecords = count.intValue();
        return countOfRecords;
    }

    public boolean readDelimeter(String filePath, String delimeterInput) throws StateCensusAnalyserException {
        boolean flag = true;

        File file = new File(filePath);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            scanner.useDelimiter(delimeterInput);

            Pattern result = scanner.delimiter();
        if (result.pattern().equals(",")){
            flag = true;
        }
        else {
            flag = false;
            throw new StateCensusAnalyserException("Enter Correct Delimeter in CSV File");
        }
        } catch ( Exception e) {
            System.out.println(e.getMessage());
        }

        return flag;
    }

    public boolean checkHeader(String filePath, List<String> stringName) throws StateCensusAnalyserException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        //Reading header
        String line = reader.readLine();
        String[] header = line.split(",");
        boolean flag = true;
        for (int i = 0; i < header.length && i < stringName.size(); i++) {
            if(stringName.get(i).equals(header[i]))
                flag = true;
            else {
                flag = false;
                throw new StateCensusAnalyserException("Please enter the correct header!");
            }
        }
        return flag;
    }
}
