package com.advance.detect_duplicate;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Test;

public class TestDuplicateData {
    @Test
    public void testingDuplicate() {
        
        DuplicateFinder df = new DuplicateFinder();

        // Path to the CSV file
        String filePath = "C:\\Users\\DELL\\Desktop\\IOProgramming\\data_handling\\src\\main\\java\\com\\advance\\detect_duplicate\\file.csv";

        // Get the duplicate records
        Set<String> duplicates = df.getDuplicate(filePath);

        // Check that duplicates are not empty if the file contains duplicate records
        assertFalse("Duplicate set should not be empty if duplicates exist", duplicates.isEmpty());

        // Check for specific duplicate records (based on sample data)
        assertTrue("Expected duplicate not found", duplicates.contains("2,Jane,21"));
        assertTrue("Expected duplicate not found", duplicates.contains("1,John,20"));
        assertTrue("Expected duplicate not found", duplicates.contains("3,Alice,22"));
    }
}
