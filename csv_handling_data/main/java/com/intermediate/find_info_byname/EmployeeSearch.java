package com.intermediate.find_info_byname;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeSearch {
    public List<String> searchEmployeeByName(String filePath, String name) {
        String delimiter = ",";
        List<String> result = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Skip the header
            reader.readLine();

            // Read each line and search for the name
            while ((line = reader.readLine()) != null) {
                String[] employee = line.split(delimiter);

                if (employee[1].trim().equalsIgnoreCase(name)) {
                    result.add(employee[2]); 
                    result.add(employee[3]);  
                    return result;  
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }

        return result;  
    }
}
