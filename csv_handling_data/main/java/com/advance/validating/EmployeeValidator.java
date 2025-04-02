package com.advance.validating;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class EmployeeValidator {

    // Email validation regex
    private static final String EMAIL_REGEX = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    // Phone number validation regex (10 digits)
    private static final String PHONE_REGEX = "^\\d{10}$";
    private static final Pattern PHONE_PATTERN = Pattern.compile(PHONE_REGEX);

    public List<String> validateEmployeeData(String filePath) {
        List<String> invalidRows = new ArrayList<>();
        String delimiter = ",";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int rowNumber = 0;

            // Reading the header
            if ((line = reader.readLine()) != null) {
                rowNumber++;
            }

            while ((line = reader.readLine()) != null) {
                rowNumber++;
                String[] employee = line.split(delimiter);

                if (employee.length < 4) {
                    invalidRows.add("Row " + rowNumber + ": Incomplete data");
                    continue;
                }

                String email = employee[2].trim();
                String phone = employee[3].trim();

                // Validate email
                if (!EMAIL_PATTERN.matcher(email).matches()) {
                    invalidRows.add("Row " + rowNumber + ": Invalid email - " + email);
                }

                // Validate phone number
                if (!PHONE_PATTERN.matcher(phone).matches()) {
                    invalidRows.add("Row " + rowNumber + ": Invalid phone number - " + phone);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        return invalidRows;
    }
}

