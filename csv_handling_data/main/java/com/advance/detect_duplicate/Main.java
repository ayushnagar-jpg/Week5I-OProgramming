package com.advance.detect_duplicate;

import java.util.Set;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DuplicateFinder df = new DuplicateFinder();
		String filePath = "C:\\Users\\DELL\\Desktop\\IOProgramming\\data_handling\\src\\main\\java\\com\\advance\\detect_duplicate\\file.csv";
		Set<String> li = df.getDuplicate(filePath);
		for(String records: li) {
			System.out.println(records);
		}
	}

}
