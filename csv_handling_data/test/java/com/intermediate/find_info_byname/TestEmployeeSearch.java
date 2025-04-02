package com.intermediate.find_info_byname;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Test;

public class TestEmployeeSearch {

    private final String filePath = "C:\\Users\\DELL\\Desktop\\IOProgramming\\data_handling\\src\\main\\java\\com\\intermediate\\find_info_byname\\emp.csv";
    private final EmployeeSearch es = new EmployeeSearch();

    @Test
    public void testSearchEmployeeJohn() {
        List<String> result = es.searchEmployeeByName(filePath, "John");
        assertEquals(2, result.size());
        assertEquals("Department: Engineering", "Department: " + result.get(0));
        assertEquals("Salary: 75000", "Salary: " + result.get(1));
    }

    @Test
    public void testSearchEmployeeBob() {
        List<String> result = es.searchEmployeeByName(filePath, "Bob");
        assertEquals(2, result.size());
        assertEquals("Department: Engineering", "Department: " + result.get(0));
        assertEquals("Salary: 80000", "Salary: " + result.get(1));
    }

    @Test
    public void testSearchEmployeeCharlie() {
        List<String> result = es.searchEmployeeByName(filePath, "Charlie");
        assertEquals(2, result.size());
        assertEquals("Department: Sales", "Department: " + result.get(0));
        assertEquals("Salary: 55000", "Salary: " + result.get(1));
    }

    @Test
    public void testSearchEmployeeCaseInsensitive() {
        List<String> result = es.searchEmployeeByName(filePath, "jane");
        assertEquals(2, result.size());
        assertEquals("Department: Marketing", "Department: " + result.get(0));
        assertEquals("Salary: 65000", "Salary: " + result.get(1));
    }

    @Test
    public void testSearchEmployeeNotFound() {
        List<String> result = es.searchEmployeeByName(filePath, "David");
        assertEquals(0, result.size());
        assertFalse(result.contains("Employee not found"));
    }
}
