package com.intermediate.filter_record;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create an instance of FilterRecords
        FilterRecords fr = new FilterRecords();
        
        String filePath = "C:\\Users\\DELL\\Desktop\\IOProgramming\\data_handling\\src\\main\\java\\com\\intermediate\\filter_record\\student.csv";
        
        
        List<String> filteredRecords = fr.getFilteredRecord(filePath);
        
        // Print the filtered records
        System.out.println("Filtered Students (Marks >= 80):");
        for (String record : filteredRecords) {
            System.out.println(record);
        }
    }
}
