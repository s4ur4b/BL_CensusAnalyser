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

    public void readData(String fileName){
        File file = new File(fileName);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scanner.hasNext()){
            System.out.println(scanner.next());
        }
    }

    public int readDataCount(final String fileName){
        final AtomicInteger count = new AtomicInteger();
        final AtomicBoolean firstLine = new AtomicBoolean(true);
        File files = new File(fileName);

        try {
            Files.lines(Paths.get(fileName)).forEach(lines -> {
                if (lines.startsWith("State")){
                    firstLine.set(false);}
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
