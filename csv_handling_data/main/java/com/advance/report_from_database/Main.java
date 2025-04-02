package com.advance.report_from_database;

import java.io.IOException;

public class Main {

	  public static void main(String[] args) throws IOException {
	        // Path to store the CSV file
	    String csvFilePath = "C:\\Users\\DELL\\Desktop\\IOProgramming\\data_handling\\src\\main\\java\\com\\advance\\report_from_database\\employee_report.csv";
	        
	        // Create an instance of CsvReportGenerator
	    CsvReportGenerator generator = new CsvReportGenerator();
        generator.generateCsvReport(csvFilePath);
	    }
	}

