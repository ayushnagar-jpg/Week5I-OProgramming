package com.advance.validating;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Test;

public class TestEmployeeValidator {

    private final String filePath = "C:\\Users\\DELL\\Desktop\\IOProgramming\\data_handling\\src\\main\\java\\com\\advance\\validating\\file.csv";
    private final EmployeeValidator validator = new EmployeeValidator();

    @Test
    public void testValidData() {
        List<String> result = validator.validateEmployeeData(filePath);
        // Assuming no invalid data in the file
        assertFalse(result.isEmpty());
    }

    @Test
    public void testInvalidEmailAndPhone() {
        List<String> result = validator.validateEmployeeData(filePath);

        // Check that invalid records are present
        assertTrue("Invalid records should be present", !result.isEmpty());

        // Check the specific error messages with correct format
        assertEquals("Row 4: Invalid email - alice@domain", result.get(0));
        assertEquals("Row 4: Invalid phone number - 12345678", result.get(1));
        assertEquals("Row 5: Invalid phone number - abc1234567", result.get(2));
        assertEquals("Row 6: Invalid phone number - 123456789012", result.get(3));
        assertEquals("Row 7: Invalid email - david@", result.get(4));
        assertEquals("Row 9: Invalid email - paul@company", result.get(5));
        assertEquals("Row 9: Invalid phone number - 12345678a0", result.get(6));
    }


    @Test
    public void testFileNotFound() {
        List<String> result = validator.validateEmployeeData("non_existent_file.csv");
        // Since the file doesn't exist, it should return an empty list.
        assertTrue("No data should be returned for a non-existent file", result.isEmpty());
    }
}
