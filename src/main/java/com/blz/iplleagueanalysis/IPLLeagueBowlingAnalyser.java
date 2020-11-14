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
}
