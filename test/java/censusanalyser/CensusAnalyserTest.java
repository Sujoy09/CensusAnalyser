package censusanalyser;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CensusAnalyserTest {
  
    private static final String INDIA_CENSUS_CSV_FILE_PATH = "C:\\Users\\roysu\\eclipse-workspace\\CensusAnalyser\\src\\test\\resources\\IndiaStateCensusData.csv";
    private static final String WRONG_CSV_FILE_PATH = "C:\\Users\\roysu\\eclipse-workspace\\CensusAnalyser\\src\\main\\resources\\IndiaStateCensusData.csv";
    private static final String INDIA_STATE_CSV_FILE_PATH = "C:\\Users\\roysu\\eclipse-workspace\\CensusAnalyser\\src\\test\\resources\\IndiaStateCode.csv";

    @Test
    public void givenIndianCensusCSVFileReturnsCorrectRecords() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH);
            Assert.assertEquals(29,numOfRecords);
        } catch (CensusAnalyserException e) { }
    }

    @Test
    public void givenIndiaCensusData_WithWrongFile_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(WRONG_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM,e.type);
        }
    }

    @Test
    public void givenIndiaStateCSV_ShouldReturnExactCount() throws CensusAnalyserException {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            int numOfStateCode = censusAnalyser.loadIndianStateCode(INDIA_STATE_CSV_FILE_PATH);
            Assert.assertEquals(37, numOfStateCode);
        } catch (CensusAnalyserException e) {}
    }
}
