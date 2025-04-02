package com.advance.csv_to_object;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentCSVReader {

    public List<Student> readStudentsFromCSV(String filePath) {
        List<Student> students = new ArrayList<>();
        String delimiter = ",";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Reading the header line
            if ((line = reader.readLine()) != null) {
                // Skipping header
            }

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(delimiter);
                if (data.length == 4) {
                    try {
                        int id = Integer.parseInt(data[0].trim());
                        String name = data[1].trim();
                        int age = Integer.parseInt(data[2].trim());
                        String grade = data[3].trim();
                        Student student = new Student(id,name,age,grade);
                        students.add(student);
                    } catch (NumberFormatException e) {
                        System.err.println("Error parsing data: " + line);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        return students;
    }
}

