package com.basic.read_count;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReadCountRows rcr = new ReadCountRows();
		String filePath = "C:\\Users\\DELL\\Desktop\\IOProgramming\\data_handling\\src\\main\\java\\com\\basic\\read_write\\student.csv";
		int countRow = rcr.countRows(filePath);
		System.out.println("Number of rows in file : "+ countRow);
	}

}
