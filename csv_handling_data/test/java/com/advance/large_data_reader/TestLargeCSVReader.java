package com.advance.large_data_reader;


import static org.junit.Assert.assertTrue;
import org.junit.Test;
import java.io.File;

public class TestLargeCSVReader {

    private final String filePath = "C:\\Users\\DELL\\Desktop\\IOProgramming\\data_handling\\src\\main\\java\\com\\advance\\large_data_reader\\largeDataFile.csv";
    private final LargeCSVReader reader = new LargeCSVReader();

    @Test
    public void testFileExists() {
        File file = new File(filePath);
        assertTrue("CSV file should exist", file.exists());
    }

    @Test
    public void testReadCSVInChunks() {
        try {
            reader.readCSVInChunks(filePath, 100);
            assertTrue("File should be read without errors", true);
        } catch (Exception e) {
            assertTrue("Exception should not occur: " + e.getMessage(), false);
        }
    }
}
