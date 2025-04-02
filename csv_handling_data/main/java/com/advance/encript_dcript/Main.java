package com.advance.encript_dcript;

import com.opencsv.exceptions.CsvValidationException;

public class Main {

    public static void main(String[] args) throws CsvValidationException {
        String csvFilePath = "C:\\Users\\DELL\\Desktop\\IOProgramming\\data_handling\\src\\main\\java\\com\\advance\\encript_dcript\\employee_data.csv"; 

        // Create instances of writer and reader
        CsvWriterWithEncryption writer = new CsvWriterWithEncryption();
        CsvReaderWithDecryption reader = new CsvReaderWithDecryption();

        // Write data to CSV with encryption
        writer.writeCsv(csvFilePath);

        // Read and decrypt data from the CSV file
        reader.readCsv(csvFilePath);
    }
}
