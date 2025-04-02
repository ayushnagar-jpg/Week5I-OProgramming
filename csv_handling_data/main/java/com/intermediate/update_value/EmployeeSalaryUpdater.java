package com.intermediate.update_value;

import java.io.*;
import java.util.*;

public class EmployeeSalaryUpdater {

    public void updateSalary(String oldPath, String newPath) {
        String delimiter = ",";
        List<String[]> updatedRecords = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(oldPath))) {
            String line;

            // Reading the header and adding to the list
            if ((line = reader.readLine()) != null) {
                updatedRecords.add(line.split(delimiter));
            }

            // Reading and updating records
            while ((line = reader.readLine()) != null) {
                String[] employee = line.split(delimiter);

                // Check if the department is "IT"
                if (employee[2].trim().equalsIgnoreCase("IT")) {
                    try {
                        // Update salary by 10%
                        double salary = Double.parseDouble(employee[3].trim());
                        salary = salary * 1.10; // Increase by 10%
                        employee[3] = String.valueOf(Math.round(salary * 100.0) / 100.0); // Rounding to 2 decimal places
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid salary format for employee: " + employee[1]);
                    }
                }
                updatedRecords.add(employee);
            }

            // Writing the updated records to the new file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(newPath))) {
                for (String[] record : updatedRecords) {
                    writer.write(String.join(",", record));
                    writer.newLine();
                }
                System.out.println("Salary update successful. Updated file saved at: " + newPath);
            }

        } catch (IOException e) {
            System.err.println("Error processing file: " + e.getMessage());
        }
    }
}

