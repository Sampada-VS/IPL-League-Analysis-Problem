package com.blz.iplleagueanalysis;

import com.opencsv.bean.CsvBindByName;

public class CSVMostWickets {
	@CsvBindByName(column="POS")
	private int position;
	
	@CsvBindByName(column="PLAYER")
	private String player;
	
	@CsvBindByName(column="Mat")
	private int numOfMatches;
	
	@CsvBindByName(column="Inns")
	private int numOfInnings;
	
	@CsvBindByName(column="Ov")
	private double overs;
	
	@CsvBindByName(column="Runs")
	private int runs;
	
	@CsvBindByName(column="Wkts")
	private int wickets;
	
	@CsvBindByName(column="BBI")
	private int bbi;
	
	@CsvBindByName(column="Avg")
	private double average;
	
	@CsvBindByName(column="Econ")
	private double economy;
	
	@CsvBindByName(column="SR")
	private double strikeRate;
	
	@CsvBindByName(column="4w")
	private int fourW;
	
	@CsvBindByName(column="5w")
	private int fiveW;
}
