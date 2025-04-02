package com.intermediate.filter_record;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import java.util.List;
import org.junit.Test;

public class TestFilterRecord {

    @Test
    public void testRecord() {
        // Create an instance of FilterRecords
        FilterRecords fr = new FilterRecords();
        
        // Path to your CSV file
        String filePath = "C:\\Users\\DELL\\Desktop\\IOProgramming\\data_handling\\src\\main\\java\\com\\intermediate\\filter_record\\student.csv";
        
        // Get the filtered records
        List<String> data = fr.getFilteredRecord(filePath); 
      
        assertEquals(3, data.size()-1);
        
        // Check the header
        assertEquals("ID,Name,marks", data.get(0));
        
        // Check filtered data
        assertEquals("1, Ashu, 90", data.get(1));
        assertEquals("2, Ayush, 80", data.get(2));
        

       
    }
}
