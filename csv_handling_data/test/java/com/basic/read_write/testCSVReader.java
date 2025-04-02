package com.basic.read_write;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

public class testCSVReader {
	 @Test
	    public void testReadCSV() {
	        StudentCSVReader reader = new StudentCSVReader();
	        String filePath = "C:\\Users\\DELL\\Desktop\\IOProgramming\\data_handling\\src\\main\\java\\com\\basic\\read_write\\student.csv";

	        List<String> records = reader.readCSV(filePath);

	        // Check if the list is not empty
	        assertNotNull(records);
	        assertEquals(4, records.size()-1);

	        // Check the content of the first record
	        assertEquals("101,John,20,85", records.get(1));
	        assertEquals("102,Alice,19,90", records.get(2));
	    }
}
