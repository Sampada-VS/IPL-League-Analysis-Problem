package com.blz.iplleagueanalysis;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


public class IPLLeagueAnalyserTest {

	static IPLLeagueAnalyser iPLLeagueAnalyser;
	private static final String IPL_MOST_RUNS_CSV_FILE_PATH = "src/IPL2019FactsheetMostRuns.csv";
	private static final String IPL_MOST_WICKETS_CSV_FILE_PATH = "src/IPL2019FactsheetMostRuns.csv";

	@BeforeClass
	public static void createObj() {
		iPLLeagueAnalyser = new IPLLeagueAnalyser();
	}

	@AfterClass
	public static void nullObj() {
		iPLLeagueAnalyser = null;
	}

	@Test
	public void givenIPLMostRunsCSVFile_ShouldReturnCorrectRecords() {
		int numOfRecords = iPLLeagueAnalyser.loadMostRunsCSV(IPL_MOST_RUNS_CSV_FILE_PATH);
		assertEquals(100, numOfRecords);
	}
	@Test
	public void givenIPLMostWicketsCSVFile_ShouldReturnCorrectRecords() {
		int numOfRecords = iPLLeagueAnalyser.loadMostWicketsCSV(IPL_MOST_WICKETS_CSV_FILE_PATH);
		assertEquals(100, numOfRecords);
	}

}
