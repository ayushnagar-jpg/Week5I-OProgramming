package com.advance.encript_dcript;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;

public class CsvWriterWithEncryption {

    public void writeCsv(String filePath) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            // Writing headers to the CSV file
            String[] headers = {"Employee ID", "Name", "Email", "Salary"};
            writer.writeNext(headers);

            // Sample employee data
            String[] employee1 = {"1", "John Doe", BasicEncryptionUtil.encrypt("john.doe@example.com"), BasicEncryptionUtil.encrypt("50000")};
            String[] employee2 = {"2", "Jane Smith", BasicEncryptionUtil.encrypt("jane.smith@example.com"), BasicEncryptionUtil.encrypt("60000")};

            // Writing the employee data to the CSV
            writer.writeNext(employee1);
            writer.writeNext(employee2);

            System.out.println("CSV file with encrypted data created successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
