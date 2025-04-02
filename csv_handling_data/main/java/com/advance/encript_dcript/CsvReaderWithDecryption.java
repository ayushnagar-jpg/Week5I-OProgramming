package com.advance.encript_dcript;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

public class CsvReaderWithDecryption {

    public void readCsv(String filePath) throws CsvValidationException {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] record;
            while ((record = reader.readNext()) != null) {
                // Decrypt sensitive fields (Email, Salary)
                String decryptedEmail = BasicEncryptionUtil.decrypt(record[2]);
                String decryptedSalary = BasicEncryptionUtil.decrypt(record[3]);

                // Display the decrypted data
                System.out.println("Employee ID: " + record[0]);
                System.out.println("Name: " + record[1]);
                System.out.println("Email: " + decryptedEmail);
                System.out.println("Salary: " + decryptedSalary);
                System.out.println("----------------------------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

