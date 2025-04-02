package com.advance.csv_to_object;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\DELL\\Desktop\\IOProgramming\\data_handling\\src\\main\\java\\com\\advance\\csv_to_object\\students.csv";
        StudentCSVReader reader = new StudentCSVReader();
        List<Student> students = reader.readStudentsFromCSV(filePath);

        // Print the Student objects
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
