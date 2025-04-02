package com.advance.merge;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.io.File;
import java.nio.file.Files;
import java.util.List;
import org.junit.Test;

public class TestCSVMerger {

    private final String filePath1 = "C:\\Users\\DELL\\Desktop\\IOProgramming\\data_handling\\src\\main\\java\\com\\advance\\merge\\csv1.csv";
    private final String filePath2 = "C:\\Users\\DELL\\Desktop\\IOProgramming\\data_handling\\src\\main\\java\\com\\advance\\merge\\csv2.csv";
    private final String outputFilePath = "C:\\Users\\DELL\\Desktop\\IOProgramming\\data_handling\\src\\main\\java\\com\\advance\\merge\\allDetails.csv";
    private final CSVFileMerger merger = new CSVFileMerger();

    @Test
    public void testCSVMerge() throws Exception {
        // Merge the files
        merger.mergeCSVFiles(filePath1, filePath2, outputFilePath);

        // Check if the merged file exists
        File mergedFile = new File(outputFilePath);
        assertTrue("Merged file should exist", mergedFile.exists());

        // Read the merged file
        List<String> lines = Files.readAllLines(mergedFile.toPath());

        // Check the header
        assertEquals("ID,Name,Age,Marks,Grade", lines.get(0));

        // Check merged data (sample data to verify)
        assertEquals("1,John,20,85,A", lines.get(1));
        assertEquals("2,Sara,22,78,B", lines.get(2));
        assertEquals("3,Mark,21,90,A", lines.get(3));
        assertEquals("4,Alice,23,65,C", lines.get(4));
        assertEquals("5,Bob,20,88,B", lines.get(5));

        // Clean up (delete the merged file after testing)
        mergedFile.delete();
    }

    @Test
    public void testNonExistentFile() {
        String nonExistentPath1 = "nonexistent1.csv";
        String nonExistentPath2 = "nonexistent2.csv";
        String outputPath = "output.csv";

        try {
            merger.mergeCSVFiles(nonExistentPath1, nonExistentPath2, outputPath);
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("Error reading file"));
        }
    }

    
}

