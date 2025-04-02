package com.advance.json_csv;


import java.io.*;

import org.json.JSONArray;
import org.json.JSONObject;

public class CsvToJson {

    public void convert(String csvFilePath, String jsonFilePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath));
             FileWriter fileWriter = new FileWriter(jsonFilePath)) {

            String line = reader.readLine();
            String[] headers = line.split(",");
            //make jsonArray to store json object
            JSONArray jsonArray = new JSONArray();
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                //creating json obj
                JSONObject jsonObject = new JSONObject();
                for (int i = 0; i < headers.length; i++) {
                    jsonObject.put(headers[i].trim(), values[i].trim());
                }
                jsonArray.put(jsonObject);
            }

            // Write JSON array to file
            fileWriter.write(jsonArray.toString(4));
            System.out.println("Successfully converted CSV to JSON.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

