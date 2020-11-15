package com.blz.iplleagueanalysis;

import static org.junit.Assert.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class IPLLeagueBattingAnalyserTest {

	static IPLLeagueBattingAnalyser iPLLeagueBattingAnalyser;
	private static final String IPL_MOST_RUNS_CSV_FILE_PATH = "src/IPL2019FactsheetMostRuns.csv";

	@BeforeClass
	public static void createObj() {
		iPLLeagueBattingAnalyser = new IPLLeagueBattingAnalyser();
	}

	@AfterClass
	public static void nullObj() {
		iPLLeagueBattingAnalyser = null;
	}

	@Test
	public void givenIPLMostRunsCSVFile_ShouldReturnCorrectRecords() {
		int numOfRecords = iPLLeagueBattingAnalyser.loadMostRunsCSV(IPL_MOST_RUNS_CSV_FILE_PATH);
		assertEquals(100, numOfRecords);
	}

	@Test
	public void givenIPLMostRunsCSVFile_WhenTopBattingAverage_ShouldReturnCorrectRecord() {
		List<CSVMostRuns> topBattingAverage = iPLLeagueBattingAnalyser.getTopBattingAverage(IPL_MOST_RUNS_CSV_FILE_PATH);
		assertEquals(83.2, topBattingAverage.get(0).getAverage(), 0.0);
	}

	@Test
	public void givenIPLMostRunsCSVFile_WhenTopStrikingRate_ShouldReturnCorrectRecord() {
		String topStrikingRate = iPLLeagueBattingAnalyser.getTopStrikingRate(IPL_MOST_RUNS_CSV_FILE_PATH);
		assertEquals("333.33,Ishant Sharma", topStrikingRate);
	}

	@Test
	public void givenIPLMostRunsCSVFile_WhenMax6s_ShouldReturnCricketer() {
		String max6sHit = iPLLeagueBattingAnalyser.getCricketerWhoHitmax6s(IPL_MOST_RUNS_CSV_FILE_PATH);
		assertEquals("52,Andre Russell", max6sHit);
	}

	@Test
	public void givenIPLMostRunsCSVFile_WhenMax4s_ShouldReturnCricketer() {
		String max4sHit = iPLLeagueBattingAnalyser.getCricketerWhoHitmax4s(IPL_MOST_RUNS_CSV_FILE_PATH);
		assertEquals("64,Shikhar Dhawan", max4sHit);
	}

	@Test
	public void givenIPLMostRunsCSVFile_WhenBestStrikingRate_ShouldReturnCricketerWithHis6sAnd4s() {
		String bestStrikeRateCricketer = iPLLeagueBattingAnalyser
				.getCricketerWhoHasBestStrikingRate(IPL_MOST_RUNS_CSV_FILE_PATH);
		assertEquals("333.33,1,1", bestStrikeRateCricketer);
	}

	@Test
	public void givenIPLMostRunsCSVFile_WhenGreatAverage_ShouldReturnCricketerWithStrikeRate() {
		String bestAverageCricketer = iPLLeagueBattingAnalyser
				.getCricketerWhoHasBestAverage(IPL_MOST_RUNS_CSV_FILE_PATH);
		assertEquals("MS Dhoni,83.2,134.62", bestAverageCricketer);
	}

	@Test
	public void givenIPLMostRunsCSVFile_WhenMaxRuns_ShouldReturnCricketerWithBestAverage() {
		String maxRunsScorer = iPLLeagueBattingAnalyser.getCricketerWhoHitMaxRuns(IPL_MOST_RUNS_CSV_FILE_PATH);
		assertEquals("David Warner ,692,69.2", maxRunsScorer);
	}

	@Test
	public void givenIPLMostRunsCSVFile_WhenMost100s_ShouldReturnCricketerWithHighestBattingAverage() {
		List<CSVMostRuns> max100sList = iPLLeagueBattingAnalyser.getMax100s(IPL_MOST_RUNS_CSV_FILE_PATH);
		assertEquals("David Warner ,1,69.2", max100sList.get(0).getName() + "," + max100sList.get(0).get100s() + ","
				+ max100sList.get(0).getAverage());
	}
	
	@Test
	public void givenIPLMostRunsCSVFile_WhenHitZero100s_ShouldReturnCricketerWithHighestBattingAverage() {
		List<CSVMostRuns> topBattingAverage = iPLLeagueBattingAnalyser.getTopBattingAverage(IPL_MOST_RUNS_CSV_FILE_PATH);
		List<CSVMostRuns> topBattingAverageWithZero100s = topBattingAverage
				  .stream()
				  .filter(c -> c.get100s() == 0)
				  .collect(Collectors.toList());	
		assertEquals("MS Dhoni",topBattingAverageWithZero100s.get(0).getName());
	}
	@Test
	public void givenIPLMostRunsCSVFile_WhenHitZero50s_ShouldReturnCricketerWithHighestBattingAverage() {
		List<CSVMostRuns> topBattingAverage = iPLLeagueBattingAnalyser.getTopBattingAverage(IPL_MOST_RUNS_CSV_FILE_PATH);
		List<CSVMostRuns> topBattingAverageWithZero50s = topBattingAverage
				  .stream()
				  .filter(c -> c.get50s() == 0)
				  .collect(Collectors.toList());	
		assertEquals("Marcus Stoinis",topBattingAverageWithZero50s.get(0).getName());
	}

}
