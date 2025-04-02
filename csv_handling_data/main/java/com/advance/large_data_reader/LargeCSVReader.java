package com.advance.large_data_reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LargeCSVReader {

    public void readCSVInChunks(String filePath, int chunkSize) {
        int recordCount = 0;
        int chunkCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            
            // Reading header (optional)
            if ((line = br.readLine()) != null) {
                System.out.println("Header: " + line);
            }

            while ((line = br.readLine()) != null) {
                recordCount++;
                
                
                // When chunk size is reached, print the count and reset
                if (recordCount % chunkSize == 0) {
                    chunkCount++;
                    System.out.println("Processed " + (chunkCount * chunkSize) + " records...");
                }
            }

            // Print remaining records count if not a perfect multiple of chunk size
            if (recordCount % chunkSize != 0) {
                System.out.println("Processed " + recordCount + " records in total.");
            }

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        LargeCSVReader reader = new LargeCSVReader();
        String filePath = "C:\\Users\\DELL\\Desktop\\IOProgramming\\data_handling\\src\\main\\java\\com\\advance\\large_data_reader\\largeDataFile.csv";
        
        // Read in chunks of 100 lines
        reader.readCSVInChunks(filePath, 100);
    }
}
