package com.blz.iplleagueanalysis;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class IPLLeagueAnalyser {
	public int loadMostRunsCSV(String csvFilePath) {
		int numberOfEntries=0;
		try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));) {
			CsvToBean<CSVMostRuns> csvToBean = new CsvToBeanBuilder(reader).withType(CSVMostRuns.class)
					.withIgnoreLeadingWhiteSpace(true).build();
			Iterator <CSVMostRuns> csvRunsIterator=csvToBean.iterator();
			while(csvRunsIterator.hasNext()) {
				numberOfEntries++;
				CSVMostRuns csvMostRuns = csvRunsIterator.next();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return numberOfEntries;
	}

	public int loadMostWicketsCSV(String csvFilePath) {
		int numberOfEntries=0;
		try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));) {
			CsvToBean<CSVMostWickets> csvToBean = new CsvToBeanBuilder(reader).withType(CSVMostWickets.class)
					.withIgnoreLeadingWhiteSpace(true).build();
			Iterator <CSVMostWickets> csvWicketsIterator=csvToBean.iterator();
			while(csvWicketsIterator.hasNext()) {
				numberOfEntries++;
				CSVMostWickets csvMostWickets = csvWicketsIterator.next();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return numberOfEntries;
	}

}
