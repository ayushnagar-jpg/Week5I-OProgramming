package com.intermediate.sort;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Test;

public class TestEmployeeSorter {

    private final String filePath = "C:\\Users\\DELL\\Desktop\\IOProgramming\\data_handling\\src\\main\\java\\com\\intermediate\\sort\\employees.csv";
    private final EmployeeSorter sorter = new EmployeeSorter();

    @Test
    public void testGetTopPaidEmployees() {
        List<String> topEmployees = sorter.getTopPaidEmployees(filePath);

        // Check if the list contains 5 records
        assertEquals(5, topEmployees.size());

        // Verify the sorted order and content
        assertTrue(topEmployees.get(0).contains("Bob, Engineering, 80000"));
        assertTrue(topEmployees.get(1).contains("Mark, IT, 77000"));
        assertTrue(topEmployees.get(2).contains("John, IT, 75000"));
        assertTrue(topEmployees.get(3).contains("Steve, Engineering, 72000"));
        assertTrue(topEmployees.get(4).contains("Paul, IT, 66000"));
    }

    @Test
    public void testEmptyFile() {
        String emptyFilePath = "C:\\Users\\DELL\\Desktop\\IOProgramming\\data_handling\\src\\main\\java\\com\\intermediate\\sort\\empty.csv";
        List<String> topEmployees = sorter.getTopPaidEmployees(emptyFilePath);

        // The result should be an empty list
        assertTrue(topEmployees.isEmpty());
    }

    @Test
    public void testInvalidFile() {
        String invalidFilePath = "C:\\Users\\DELL\\Desktop\\IOProgramming\\data_handling\\src\\main\\java\\com\\intermediate\\sort\\nonexistent.csv";
        List<String> topEmployees = sorter.getTopPaidEmployees(invalidFilePath);

        // The result should be an empty list since the file does not exist
        assertTrue(topEmployees.isEmpty());
    }

    @Test
    public void testLessThanFiveEmployees() {
        String smallFilePath = "C:\\Users\\DELL\\Desktop\\IOProgramming\\data_handling\\src\\main\\java\\com\\intermediate\\sort\\small.csv";
        List<String> topEmployees = sorter.getTopPaidEmployees(smallFilePath);

        // Check if the list size is less than or equal to 5
        assertTrue(topEmployees.size() <= 5);
    }
}
