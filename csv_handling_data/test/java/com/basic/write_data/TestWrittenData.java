package com.basic.write_data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestWrittenData {
	@Test
	public void testWrittenData() {
		Writer writer = new Writer();
		String filePath = "C:\\Users\\DELL\\Desktop\\IOProgramming\\data_handling\\src\\main\\java\\com\\basic\\write_data\\data.csv";
		List<String> lines = new ArrayList<String>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
			String line;
			while((line = br.readLine())!=null) {
				lines.add(line);
			}
		}catch(IOException e) {
			e.printStackTrace();
			fail("error reading file");
		}
		
		assertEquals(6,lines.size());
		
		assertEquals("ID,Name,Department,Salary", lines.get(0));
		
	}
}
