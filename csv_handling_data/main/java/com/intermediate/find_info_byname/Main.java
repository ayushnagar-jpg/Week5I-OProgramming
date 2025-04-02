package com.intermediate.find_info_byname;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create an instance of EmployeeSearch
        EmployeeSearch es = new EmployeeSearch();

        // Path to the CSV file
        String filePath ="C:\\Users\\DELL\\Desktop\\IOProgramming\\data_handling\\src\\main\\java\\com\\intermediate\\find_info_byname\\emp.csv";
        
        // Input employee name to search
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the employee name to search: ");
        String name = scanner.nextLine();
        
        // Search for the employee
        List<String> result = es.searchEmployeeByName(filePath, name);
        
        // Print the result
        if (!result.isEmpty()) {
            System.out.println("Employee Found:");
            System.out.println("Department: " + result.get(0));
            System.out.println("Salary: " + result.get(1));
        } else {
            System.out.println("Employee not found.");
        }
        
        scanner.close();
    }
}
