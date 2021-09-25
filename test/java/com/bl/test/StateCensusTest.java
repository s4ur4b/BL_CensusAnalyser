package com.bl.test;

import com.bl.censusAnalyser.ReadOperations;
import com.bl.censusAnalyser.StateCensusAnalyserException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class StateCensusTest {
    ReadOperations read = new ReadOperations();

    //Happy Test Case
    @Test
    public void givenStateCensusCSVFile_ensureNumberOfRecordsMatch() throws StateCensusAnalyserException {
        String filePath = "src/main/java/com/bl/censusAnalyser/StateCensusData.csv";
        Assert.assertEquals(6,read.readDataCount(filePath));
    }

    //Test Case 2 : Given the State Census CSV File if incorrect Returns a custom Exception
    //              This is a Sad Test Case to verify if the exception is raised.
    @Test
    public void givenStateCensusCSVFile_ifIncorrect_returnsCustomException() {
        // Provided an incorrect file path( here the file xyz.csv doesn't exists)
        String filePath ="src/main/java/com/bl/censusAnalyser/xyz.csv";
        try {
            Assert.assertEquals(6,read.readDataCount(filePath));
        } catch (StateCensusAnalyserException e) {
            System.out.println(e.getMessage());
        }
    }

//    Test Case 3 : Given the State Census CSV File when correct but type incorrect Returns a custom Exception
//                 This is a Sad Test Case to verify if the type is incorrect then exception is raised.
    @Test
    public void givenStateCensusCSVFile_ifFileTypeIncorrect_returnsCustomException(){
        String filePath = "src/main/java/com/bl/censusAnalyser/StateCensusData";
        try {
            Assert.assertEquals(6,read.readDataCount(filePath));
        } catch (StateCensusAnalyserException e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * Test Case 4 : Given the State Census CSV File when correct but delimiter incorrect
     *               Returns a custom Exception
     *              This is a Sad Test Case to verify if the file
     *              delimiter is incorrect then exception is raised.
     */
    @Test
    public void givenStateCensusCSVFile_ifDelimeterIncorrect_returnsCustomException(){
        String filePath = "src/main/java/com/bl/censusAnalyser/StateCensusData.csv";
        String delimeter ="";
        try {
          boolean result =   read.readDelimeter(filePath,delimeter);
          Assert.assertEquals(true,result);
        } catch (StateCensusAnalyserException e) {
            System.out.println(e.getMessage());;
        }
    }
}
