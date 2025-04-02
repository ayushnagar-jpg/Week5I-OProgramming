package com.basic.read_count;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

public class CountRows {
	@Test
	public void testCountRows() {
		ReadCountRows rcr = new ReadCountRows();
		String filePath = "C:\\Users\\DELL\\Desktop\\IOProgramming\\data_handling\\src\\main\\java\\com\\basic\\read_write\\student.csv";
		 
		int line = rcr.countRows(filePath);
		
		assertEquals(4,line);
		
	}
}
