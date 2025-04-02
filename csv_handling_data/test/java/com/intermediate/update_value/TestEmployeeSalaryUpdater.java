package com.intermediate.update_value;

import static org.junit.Assert.*;
import java.io.*;
import java.util.*;
import org.junit.Test;

public class TestEmployeeSalaryUpdater {

    private final String oldPath = "C:\\Users\\DELL\\Desktop\\IOProgramming\\data_handling\\src\\main\\java\\com\\intermediate\\update_value\\old.csv";
    private final String newPath = "C:\\Users\\DELL\\Desktop\\IOProgramming\\data_handling\\src\\main\\java\\com\\intermediate\\update_value\\new.csv";
    private final EmployeeSalaryUpdater updater = new EmployeeSalaryUpdater();

    @Test
    public void testSalaryUpdate() {
        // Perform the salary update
        updater.updateSalary(oldPath, newPath);

        // Read the updated file and verify the changes
        try (BufferedReader reader = new BufferedReader(new FileReader(newPath))) {
            String line;

            // Reading and verifying the header
            line = reader.readLine();
            assertEquals("ID,Name,Department,Salary", line);

            // Verify the updated records
            List<String> updatedData = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                updatedData.add(line);
            }

            // Expected updated salaries for IT department employees (10% increase)
            assertTrue(updatedData.contains("1,John,IT,55000.0"));
            assertTrue(updatedData.contains("3,Paul,IT,66000.0"));
            assertTrue(updatedData.contains("5,Mark,IT,77000.0"));

            // Other department employees should remain unchanged
            assertTrue(updatedData.contains("2,Sara,HR,48000"));
            assertTrue(updatedData.contains("4,Jane,Marketing,55000"));

        } catch (IOException e) {
            fail("Error reading the updated file: " + e.getMessage());
        }
    }
}

