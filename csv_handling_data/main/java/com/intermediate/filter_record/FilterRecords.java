package com.intermediate.filter_record;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FilterRecords {
    public List<String> getFilteredRecord(String filePath) {
        String delimiter = ",";
        List<String> filteredRecords = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Reading the header
            if ((line = reader.readLine()) != null) {
                filteredRecords.add(line);  // Add header to the list
            }

            // Reading the remaining lines and filtering
            while ((line = reader.readLine()) != null) {
                String[] student = line.split(delimiter);
                try {
                    int marks = Integer.parseInt(student[2].trim());
                    if (marks >= 80) {
                        filteredRecords.add(String.join(", ", student));  // Add filtered record
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Error parsing marks for student: " + String.join(", ", student));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }

        return filteredRecords;
    }
}
