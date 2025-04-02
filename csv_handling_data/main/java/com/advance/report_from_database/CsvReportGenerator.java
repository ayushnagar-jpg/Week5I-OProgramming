package com.advance.report_from_database;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvReportGenerator {

    public void generateCsvReport(String filePath) throws IOException {
        // Simulating data from a database or source
        List<String[]> data = getEmployeeData();

        // If no data exists, do not write a CSV file
        if (data.isEmpty()) {
            System.out.println("No data available, skipping CSV file creation.");
            return;
        }

        // Creating the CSV file and writing data
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            // Write header
            writer.writeNext(new String[]{"Employee ID", "Name", "Department", "Salary"});

            // Write data
            writer.writeAll(data);
            System.out.println("CSV file created successfully.");
        }
    }

    private List<String[]> getEmployeeData() {
        // Simulate data, or fetch data from your database
        return List.of(
            new String[]{"1", "John Doe", "Engineering", "50000"},
            new String[]{"2", "Jane Smith", "Marketing", "60000"},
            new String[]{"3", "Alice Brown", "Sales", "55000"},
            new String[]{"4", "Bob White", "HR", "45000"}
        );
    }
}
