package com.blz.iplleagueanalysis;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class IPLLeagueAnalyser {
	static List<CSVMostRuns> csvRuns;
	static List<CSVMostWickets> csvWickets;

	public int loadMostRunsCSV(String csvFilePath) {
		try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));){
			CsvToBean<CSVMostRuns> csvToBean = new CsvToBeanBuilder(reader).withType(CSVMostRuns.class)
					.withIgnoreLeadingWhiteSpace(true).build();
			csvRuns = csvToBean.parse();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return csvRuns.size();
	}

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

	public double getTopBattingAverage(String csvFilePath) {
		loadMostRunsCSV(csvFilePath);
		CSVMostRuns topAverage = csvRuns.stream()
	            .max(Comparator.comparing(CSVMostRuns::getAverage))
	            .get();
		return topAverage.getAverage();
	}

}
