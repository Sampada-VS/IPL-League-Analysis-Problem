package com.blz.iplleagueanalysis;

import com.opencsv.bean.CsvBindByName;

public class CSVMostRuns {
	@CsvBindByName(column="POS")
	private int position;
	
	@CsvBindByName(column="PLAYER")
	private String playerName;
	
	@CsvBindByName(column="Mat")
	private int numOfMatches;

	@CsvBindByName(column="Inns")
	private int numOfInnings;
	
	@CsvBindByName(column="NO")
	private int no;
	
	@CsvBindByName(column="Runs")
	private int runs;
	
	@CsvBindByName(column="HS")
	private String hs;
	
	@CsvBindByName(column="Avg")
	private double average;
	
	@CsvBindByName(column="BF")
	private int bf;
	
	@CsvBindByName(column="SR")
	private float strikeRate;
	
	@CsvBindByName(column="100")
	private int totalcenturies;
	
	@CsvBindByName(column="50")
	private int totalHalfCenturies;

	@CsvBindByName(column="4s")
	private int total4s;
	
	@CsvBindByName(column="6s")
	private int total6s;
}
//POS,PLAYER,Mat,Inns,NO,Runs,HS,Avg,BF,SR,100,50,4s,6s