package com.intermediate.sort;

import java.io.*;
import java.util.*;

public class EmployeeSorter {

    public List<String> getTopPaidEmployees(String filePath) {
        List<String[]> employeeList = new ArrayList<>();
        String delimiter = ",";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Read the header
            if ((line = reader.readLine()) != null) {
                System.out.println("Header: " + line);
                employeeList.add(line.split(delimiter)); 
            }

            // Read the remaining lines
            while ((line = reader.readLine()) != null) {
                
                String[] employee = line.split(delimiter);
                employeeList.add(employee);
            }

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return Collections.emptyList();
        }

        // Check if there are any employees to sort (excluding the header)
        if (employeeList.size() <= 1) {
            System.out.println("No employee data found to sort.");
            return Collections.emptyList();
        }

        // Sort the list based on the Salary column (index 3) in descending order
        Collections.sort(employeeList.subList(1, employeeList.size()), (a, b) -> {
            try {
                double salary1 = Double.parseDouble(a[3].trim());
                double salary2 = Double.parseDouble(b[3].trim());
                return Double.compare(salary2, salary1);  // Descending order
            } catch (NumberFormatException e) {
                System.err.println("Error parsing salary: " + e.getMessage());
                return 0;
            }
        });

        // Prepare the top 5 highest-paid employees
        List<String> topEmployees = new ArrayList<>();
        int count = Math.min(5, employeeList.size() - 1);  // Limit to 5
        for (int i = 1; i <= count; i++) {
            topEmployees.add(String.join(", ", employeeList.get(i)));
        }

        return topEmployees;
    }
}
