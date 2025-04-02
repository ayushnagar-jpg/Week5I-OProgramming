package com.advance.report_from_database;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CsvReportGeneratorTest {

    private static final String CSV_FILE_PATH = "C:\\Users\\DELL\\Desktop\\IOProgramming\\data_handling\\src\\main\\java\\com\\advance\\report_from_database\\employee_report.csv";
    private CsvReportGenerator generator;

    @BeforeEach
    public void setUp() {
        generator = new CsvReportGenerator();
    }

    @Test
    public void testGenerateCsvReport() throws IOException, CsvException {
        // Act: Generate the CSV report
        generator.generateCsvReport(CSV_FILE_PATH);

        // Assert: Check if the CSV file exists
        assertTrue(new java.io.File(CSV_FILE_PATH).exists(), "CSV file was not created");

        // Read and validate the CSV file content
        try (CSVReader reader = new CSVReader(new FileReader(CSV_FILE_PATH))) {
            List<String[]> records = reader.readAll();

            // Check header row
            assertArrayEquals(new String[]{"Employee ID", "Name", "Department", "Salary"}, records.get(0));

            // Check data rows
            assertArrayEquals(new String[]{"1", "John Doe", "Engineering", "50000"}, records.get(1));
            assertArrayEquals(new String[]{"2", "Jane Smith", "Marketing", "60000"}, records.get(2));
            assertArrayEquals(new String[]{"3", "Alice Brown", "Sales", "55000"}, records.get(3));
            assertArrayEquals(new String[]{"4", "Bob White", "HR", "45000"}, records.get(4));
        }
    }

    @Test
    public void testEmptyCsvFile() throws IOException {
        // Setup: Create an empty CSV file (no data)
        String emptyCsvFilePath = "empty_report.csv";
        CsvReportGenerator emptyGenerator = new CsvReportGenerator();

        // Act: Run the generator with no data, it should not create a file
        emptyGenerator.generateCsvReport(emptyCsvFilePath);

        // Assert: Check if the empty CSV file was not created
        java.io.File file = new java.io.File(emptyCsvFilePath);
        assertTrue(file.exists(), "Empty CSV file was created, but it shouldn't be.");
    }
}
