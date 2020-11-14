package com.blz.iplleagueanalysis;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class IPLLeagueBowlingAnalyserTest {

	static IPLLeagueBowlingAnalyser iPLLeagueBowlingAnalyser;
	private static final String IPL_MOST_WICKETS_CSV_FILE_PATH = "src/IPL2019FactsheetMostWkts.csv";

	@BeforeClass
	public static void createObj() {
		iPLLeagueBowlingAnalyser = new IPLLeagueBowlingAnalyser();
	}

	@AfterClass
	public static void nullObj() {
		iPLLeagueBowlingAnalyser = null;
	}

	@Test
	public void givenIPLMostRunsCSVFile_ShouldReturnCorrectRecords() {
		int numOfRecords = iPLLeagueBowlingAnalyser.loadMostWicketsCSV(IPL_MOST_WICKETS_CSV_FILE_PATH);
		assertEquals(99, numOfRecords);
	}

	@Test
	public void givenIPLMostWicketsCSVFile_WhenTopBowlingAverage_ShouldReturnCorrectRecord() {
		List<CSVMostWickets> topBowlingAverageList = iPLLeagueBowlingAnalyser
				.getTopBowlingAverage(IPL_MOST_WICKETS_CSV_FILE_PATH);
		assertEquals(166, topBowlingAverageList.get(0).getBowlingAverage(), 0.0);
	}

	@Test
	public void givenIPLMostWicketsCSVFile_WhenTopStrikingRate_ShouldReturnCorrectRecord() {
		List<CSVMostWickets> topStrikingRateList = iPLLeagueBowlingAnalyser
				.getTopStrikingRate(IPL_MOST_WICKETS_CSV_FILE_PATH);
		assertEquals(120, topStrikingRateList.get(0).getStrikeRate(), 0.0);
	}

	@Test
	public void givenIPLMostWicketsCSVFile_WhenBestEconomy_ShouldReturnCorrectRecord() {
		List<CSVMostWickets> bestEconomy = iPLLeagueBowlingAnalyser.getTBestEconomy(IPL_MOST_WICKETS_CSV_FILE_PATH);
		assertEquals("4.8,Shivam Dube", bestEconomy.get(0).getEconomy() + "," + bestEconomy.get(0).getName());
	}

	@Test
	public void givenIPLMostWicketsCSVFile_WhenTopStrikingRate_ShouldReturnCricketerWith5wAnd4w() {
		List<CSVMostWickets> topStrikingRateList = iPLLeagueBowlingAnalyser
				.getTopStrikingRate(IPL_MOST_WICKETS_CSV_FILE_PATH);
		assertEquals("Krishnappa Gowtham,120.0,0,0",
				topStrikingRateList.get(0).getName() + "," + topStrikingRateList.get(0).getStrikeRate() + ","
						+ topStrikingRateList.get(0).get5w() + "," + topStrikingRateList.get(0).get4w());
	}

	@Test
	public void givenIPLMostWicketsCSVFile_WhenTopBowlingAverage_ShouldReturnCricketerWithstrikeRate() {
		List<CSVMostWickets> topBowlingAverageList = iPLLeagueBowlingAnalyser
				.getTopBowlingAverage(IPL_MOST_WICKETS_CSV_FILE_PATH);
		assertEquals("Krishnappa Gowtham,166.0,120.0",
				topBowlingAverageList.get(0).getName() + "," + topBowlingAverageList.get(0).getBowlingAverage() + ","
						+ topBowlingAverageList.get(0).getStrikeRate());
	}

	@Test
	public void givenIPLMostWicketsCSVFile_WhenMaxWickets_ShouldReturnCricketerWithBowlingAvg() {
		List<CSVMostWickets> maxWicketsList = iPLLeagueBowlingAnalyser.getmaxWickets(IPL_MOST_WICKETS_CSV_FILE_PATH);
		assertEquals("Imran Tahir,26", maxWicketsList.get(0).getName() + "," + maxWicketsList.get(0).getWickets());
	}
}
