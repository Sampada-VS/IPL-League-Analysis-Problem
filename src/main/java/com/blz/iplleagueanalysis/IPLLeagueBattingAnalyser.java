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

public class IPLLeagueBattingAnalyser {
	static List<CSVMostRuns> csvRuns;
	
	public int loadMostRunsCSV(String csvFilePath) {
		try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));) {
			CsvToBean<CSVMostRuns> csvToBean = new CsvToBeanBuilder(reader).withType(CSVMostRuns.class)
					.withIgnoreLeadingWhiteSpace(true).build();
			csvRuns = csvToBean.parse();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return csvRuns.size();
	}

	public double getTopBattingAverage(String csvFilePath) {
		loadMostRunsCSV(csvFilePath);
		CSVMostRuns topAverage = csvRuns.stream().max(Comparator.comparing(CSVMostRuns::getAverage)).get();
		return topAverage.getAverage();
	}

	public String getTopStrikingRate(String csvFilePath) {
		loadMostRunsCSV(csvFilePath);
		CSVMostRuns topStrikeRate = csvRuns.stream().max(Comparator.comparing(CSVMostRuns::getStrikeRate)).get();
		return topStrikeRate.getStrikeRate() + "," + topStrikeRate.getName();
	}

	public String getCricketerWhoHitmax6s(String csvFilePath) {
		loadMostRunsCSV(csvFilePath);
		CSVMostRuns max6s = csvRuns.stream().max(Comparator.comparing(CSVMostRuns::get6s)).get();
		return max6s.get6s() + "," + max6s.getName();
	}

	public String getCricketerWhoHitmax4s(String csvFilePath) {
		loadMostRunsCSV(csvFilePath);
		CSVMostRuns max4s = csvRuns.stream().max(Comparator.comparing(CSVMostRuns::get4s)).get();
		return max4s.get4s() + "," + max4s.getName();
	}

	public String getCricketerWhoHasBestStrikingRate(String csvFilePath) {
		loadMostRunsCSV(csvFilePath);
		CSVMostRuns bestStrikeRate = csvRuns.stream().max(Comparator.comparing(CSVMostRuns::getStrikeRate)).get();
		return bestStrikeRate.getStrikeRate() + "," + bestStrikeRate.get6s() + "," + bestStrikeRate.get4s();
	}

	public String getCricketerWhoHasBestAverage(String csvFilePath) {
		loadMostRunsCSV(csvFilePath);
		CSVMostRuns bestAverage = csvRuns.stream().max(Comparator.comparing(CSVMostRuns::getAverage)).get();
		return bestAverage.getName() + "," + bestAverage.getAverage() + "," + bestAverage.getStrikeRate();
	}

	public String getCricketerWhoHitMaxRuns(String csvFilePath) {
		loadMostRunsCSV(csvFilePath);
		CSVMostRuns maxRuns = csvRuns.stream().max(Comparator.comparing(CSVMostRuns::getRuns)).get();
		return maxRuns.getName() + "," + maxRuns.getRuns() + "," + maxRuns.getAverage();
	}

	public List<CSVMostRuns> getMax100s(String csvFilePath) {
		loadMostRunsCSV(csvFilePath);
		List<CSVMostRuns> maximum100sList = csvRuns.stream()
				.sorted(Comparator.comparingInt(CSVMostRuns::get100s).reversed()).collect(Collectors.toList());
		return maximum100sList;
	}

}
