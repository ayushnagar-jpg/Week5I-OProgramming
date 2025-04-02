package com.basic.read_count;

import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadCountRows {
	public int countRows(String filePath) {
		List<String>lines = new ArrayList();
		try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
			String line;
			while((line = br.readLine())!=null) {
				lines.add(line);
			}
			return lines.size()-1;
		}catch(IOException e) {
			e.printStackTrace();
			fail("No data found to read");
		}
		return -1;
	}
}
