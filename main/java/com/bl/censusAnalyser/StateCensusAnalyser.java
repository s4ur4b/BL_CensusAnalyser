package com.bl.censusAnalyser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StateCensusAnalyser {
    public static void main(String[] args) throws FileNotFoundException {

        String fileName = "src/main/java/com/bl/censusAnalyser/StateCensusData.csv";

        ReadOperations read = new ReadOperations();
        read.readData(fileName);
        System.out.println("\nNumber of lines in CSV file : "+read.readDataCount(fileName));
    }
}
