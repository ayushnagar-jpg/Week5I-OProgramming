package com.basic.read_write;

import java.util.List;

public class CSVReader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentCSVReader reader = new StudentCSVReader();
		String filePath = "C:\\Users\\DELL\\Desktop\\IOProgramming\\data_handling\\src\\main\\java\\com\\basic\\read_write\\student.csv";
		List<String> records = reader.readCSV(filePath);

        for (String record : records) {
            String[] details = record.split(",");
            System.out.println("ID: " + details[0] + ", Name: " + details[1] 
                    + ", Age: " + details[2] + ", Marks: " + details[3]);
        }
	}

}
