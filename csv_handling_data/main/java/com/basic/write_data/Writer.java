package com.basic.write_data;

import java.io.FileWriter;
import java.io.IOException;

public class Writer {
	public void writeEmployeeData(String filePath) {
        // Employee data to be written to the file
        String[] employees = {
            "101,John,IT,55000",
            "102,Alice,HR,60000",
            "103,Bob,Finance,58000",
            "104,Emma,Marketing,62000",
            "105,David,Operations,50000"
        };

        try (FileWriter writer = new FileWriter(filePath)) {
            // Write the header
            writer.write("ID,Name,Department,Salary\n");

            // Write employee records
            for (String employee : employees) {
                writer.write(employee + "\n");
            }

            System.out.println("Employee data written to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
