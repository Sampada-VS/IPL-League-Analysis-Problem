package com.blz.iplleagueanalysis;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class IPLLeagueBowlingAnalyser {
	static List<CSVMostWickets> csvWickets;

	public int loadMostWicketsCSV(String csvFilePath) {
		try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));) {
			CsvToBean<CSVMostWickets> csvToBean = new CsvToBeanBuilder(reader).withType(CSVMostWickets.class)
					.withIgnoreLeadingWhiteSpace(true).build();
			csvWickets = csvToBean.parse();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return csvWickets.size();
	}

	public List<CSVMostWickets> getTopBowlingAverage(String csvFilePath) {
		loadMostWicketsCSV(csvFilePath);
		List<CSVMostWickets> bowlingAvgList = csvWickets.stream()
				.sorted(Comparator.comparingDouble(CSVMostWickets::getBowlingAverage).reversed())
				.collect(Collectors.toList());
		return bowlingAvgList;
	}

	public List<CSVMostWickets> getTopStrikingRate(String csvFilePath) {
		loadMostWicketsCSV(csvFilePath);
		List<CSVMostWickets> strikingRateList = csvWickets.stream()
				.sorted(Comparator.comparingDouble(CSVMostWickets::getStrikeRate).reversed())
				.collect(Collectors.toList());
		return strikingRateList;
	}

	public List<CSVMostWickets> getTBestEconomy(String csvFilePath) {
		loadMostWicketsCSV(csvFilePath);
		List<CSVMostWickets> bestEconomyList = csvWickets.stream()
				.sorted(Comparator.comparingDouble(CSVMostWickets::getEconomy)).collect(Collectors.toList());
		return bestEconomyList;
	}

	public List<CSVMostWickets> getmaxWickets(String csvFilePath) {
		loadMostWicketsCSV(csvFilePath);
		List<CSVMostWickets> numOfWicketsReverseList = csvWickets.stream()
				.sorted(Comparator.comparingDouble(CSVMostWickets::getWickets).reversed()).collect(Collectors.toList());
		return numOfWicketsReverseList;
	}
}
