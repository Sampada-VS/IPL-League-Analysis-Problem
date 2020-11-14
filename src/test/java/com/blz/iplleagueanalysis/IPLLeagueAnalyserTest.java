package com.blz.iplleagueanalysis;

import static org.junit.Assert.*;

import java.io.IOException;

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

	@Test
	public void givenIPLMostRunsCSVFile_WhenTopBattingAverage_ShouldReturnCorrectRecord() {
		double topBattingAverage = iPLLeagueAnalyser.getTopBattingAverage(IPL_MOST_RUNS_CSV_FILE_PATH);
		assertEquals(83.2, topBattingAverage, 0.0);
	}

	@Test
	public void givenIPLMostRunsCSVFile_WhenTopStrikingRate_ShouldReturnCorrectRecord() {
		String topStrikingRate = iPLLeagueAnalyser.getTopStrikingRate(IPL_MOST_RUNS_CSV_FILE_PATH);
		assertEquals("333.33,Ishant Sharma", topStrikingRate);
	}

	@Test
	public void givenIPLMostRunsCSVFile_WhenMax6s_ShouldReturnCricketer() {
		String max6sHit = iPLLeagueAnalyser.getCricketerWhoHitmax6s(IPL_MOST_RUNS_CSV_FILE_PATH);
		assertEquals("52,Andre Russell", max6sHit);
	}

	@Test
	public void givenIPLMostRunsCSVFile_WhenMax4s_ShouldReturnCricketer() {
		String max4sHit = iPLLeagueAnalyser.getCricketerWhoHitmax4s(IPL_MOST_RUNS_CSV_FILE_PATH);
		assertEquals("64,Shikhar Dhawan", max4sHit);
	}

	@Test
	public void givenIPLMostRunsCSVFile_WhenBestStrikingRate_ShouldReturnCricketerWithHis6sAnd4s() {
		String bestStrikeRateCricketer = iPLLeagueAnalyser
				.getCricketerWhoHasBestStrikingRate(IPL_MOST_RUNS_CSV_FILE_PATH);
		assertEquals("333.33,1,1", bestStrikeRateCricketer);
	}

	@Test
	public void givenIPLMostRunsCSVFile_WhenGreatAverage_ShouldReturnCricketerWithStrikeRate() {
		String bestAverageCricketer = iPLLeagueAnalyser.getCricketerWhoHasBestAverage(IPL_MOST_RUNS_CSV_FILE_PATH);
		assertEquals("MS Dhoni,83.2,134.62", bestAverageCricketer);
	}

}
