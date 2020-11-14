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
}
