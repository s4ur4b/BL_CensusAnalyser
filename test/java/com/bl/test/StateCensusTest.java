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
        String fileName = "StateCensusData";
        Assert.assertEquals(6,read.readDataCount(filePath,fileName));
    }

//    @Test
//    public void givenStateCensusCSVFile_ifIncorrect_returnsCustomException() {
//        // Provided an incorrect file path( here the file xyz.csv doesn't exists)
//        String filePath ="src/main/java/com/bl/censusAnalyser/xyz.csv";
//        String fileName = "xyz";
//        try {
//            Assert.assertEquals(6,read.readDataCount(filePath,fileName));
//        } catch (StateCensusAnalyserException e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//    @Test
//    public void givenStateCensusCSVFile_ifFileTypeIncorrect_returnsCustomException(){
//        String filePath = "src/main/java/com/bl/censusAnalyser/StateCensusData";
//        String fileName = "StateCensusData";
//        try {
//            Assert.assertEquals(6,read.readDataCount(filePath,fileName));
//        } catch (StateCensusAnalyserException e) {
//            System.out.println(e.getMessage());
//        }
//    }
}
