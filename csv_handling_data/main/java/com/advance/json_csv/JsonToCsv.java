package com.advance.json_csv;


import com.opencsv.CSVWriter;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

import java.io.*;
import java.util.*;

public class JsonToCsv {

    public void convert(String jsonFilePath, String csvFilePath) throws Exception {
        try (BufferedReader reader = new BufferedReader(new FileReader(jsonFilePath));
             CSVWriter writer = new CSVWriter(new FileWriter(csvFilePath))) {

            // Read the entire JSON file into a string
            StringBuilder jsonBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonBuilder.append(line);
            }

            // Try parsing the JSON array from the collected string
            JSONArray jsonArray;
            try {
                jsonArray = new JSONArray(jsonBuilder.toString());
            } catch (JSONException e) {
                // If parsing fails, throw an exception with a meaningful message
                throw new JSONException("Invalid JSON format in file: " + jsonFilePath, e);
            }

            List<String[]> csvData = new ArrayList<>();

            // Extract headers from the first object in the array
            if (jsonArray.length() > 0) {
                JSONObject firstObject = jsonArray.getJSONObject(0);
                Set<String> keys = firstObject.keySet();
                csvData.add(keys.toArray(new String[0]));

                // Extract rows from each JSON object
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String[] row = keys.stream().map(key -> jsonObject.optString(key)).toArray(String[]::new);
                    csvData.add(row);
                }

                // Write the data to the CSV file
                writer.writeAll(csvData);
                System.out.println("Successfully converted JSON to CSV.");
            } else {
                System.out.println("The JSON array is empty.");
            }

        } catch (IOException | JSONException e) {
            // Log the exception
        	System.err.println("Error during conversion: " + e.getMessage());
            throw e;
        }
    }
}
