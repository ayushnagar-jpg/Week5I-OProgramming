package com.basic.read_write;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentCSVReader {

    // Method to read CSV and return the data as a list of strings
    public List<String> readCSV(String filePath) {
        List<String> records = new ArrayList<>();
        String line;
        String delimiter = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                records.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }
}
