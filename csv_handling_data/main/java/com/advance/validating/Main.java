package com.advance.validating;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EmployeeValidator validator = new EmployeeValidator();
        String filePath = "C:\\Users\\DELL\\Desktop\\IOProgramming\\data_handling\\src\\main\\java\\com\\advance\\validating\\file.csv";

        List<String> invalidRows = validator.validateEmployeeData(filePath);

        if (invalidRows.isEmpty()) {
            System.out.println("All employee records are valid.");
        } else {
            System.out.println("Invalid Employee Records:");
            for (String error : invalidRows) {
                System.out.println(error);
            }
        }
    }
}

