package com.bl.censusAnalyser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

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

    public int readDataCount(final String filePath, String fileNameInput) throws StateCensusAnalyserException {
        final AtomicInteger count = new AtomicInteger();
        final AtomicBoolean firstLine = new AtomicBoolean(true);

        try {
            File file = new File(filePath);
            String fileName = file.getName();
            String fileNameWithoutExtension = " ";
            int pos = fileName.lastIndexOf(".");
            if (pos > 0 && pos < (fileName.length() - 1)) {
                fileNameWithoutExtension = fileName.substring(0, pos);
            }

            if (!fileNameWithoutExtension.equals(fileNameInput)) {
                throw new StateCensusAnalyserException("Please enter a proper file name!");
            }

            if (!fileName.contains(".csv"))
                throw new StateCensusAnalyserException("Please enter a proper file type!");

            Files.lines(Paths.get(filePath)).forEach(lines -> {
                if (lines.startsWith("State"))
                    firstLine.set(false);
                else {
                    lines.split("\n");
                    count.getAndIncrement();
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
        return Integer.parseInt(String.valueOf(count));
    }
}
