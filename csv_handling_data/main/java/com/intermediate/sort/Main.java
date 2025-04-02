package com.intermediate.sort;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EmployeeSorter sorter = new EmployeeSorter();
        String filePath = "C:\\Users\\DELL\\Desktop\\IOProgramming\\data_handling\\src\\main\\java\\com\\intermediate\\sort\\employees.csv";
        List<String> topEmployees = sorter.getTopPaidEmployees(filePath);

        System.out.println("Top 5 Highest-Paid Employees:");
        for (String employee : topEmployees) {
            System.out.println(employee);
        }
    }
}
