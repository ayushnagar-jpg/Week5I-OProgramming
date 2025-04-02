package com.advance.merge;


import java.io.*;
import java.util.*;

public class CSVFileMerger {

    public void mergeCSVFiles(String file1Path, String file2Path, String outputFilePath) {
        Map<String, String[]> dataMap = new HashMap<>();

        try (BufferedReader br1 = new BufferedReader(new FileReader(file1Path));
             BufferedReader br2 = new BufferedReader(new FileReader(file2Path));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            // Reading header of file1 and file2
            String header1 = br1.readLine();
            String header2 = br2.readLine();

            // Writing the merged header
            writer.write(header1 + "," + header2.substring(header2.indexOf(',') + 1));
            writer.newLine();

            // Reading file1 and storing data in a map
            String line;
            while ((line = br1.readLine()) != null) {
                String[] fields = line.split(",");
                dataMap.put(fields[0], fields);
            }

            // Reading file2 and merging data
            while ((line = br2.readLine()) != null) {
                String[] fields = line.split(",");
                String id = fields[0];

                if (dataMap.containsKey(id)) {
                    String[] data1 = dataMap.get(id);
                    String mergedData = String.join(",", data1) + "," + fields[1] + "," + fields[2];
                    writer.write(mergedData);
                    writer.newLine();
                }
            }

            System.out.println("Files merged successfully!");

        } catch (IOException e) {
            System.err.println("Error reading or writing file: " + e.getMessage());
        }
    }
}
