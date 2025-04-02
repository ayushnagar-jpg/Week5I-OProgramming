package com.intermediate.update_value;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 EmployeeSalaryUpdater updater = new EmployeeSalaryUpdater();
	     String inputFilePath = "C:\\Users\\DELL\\Desktop\\IOProgramming\\data_handling\\src\\main\\java\\com\\intermediate\\update_value\\old.csv";
	     String outputFilePath = "C:\\Users\\DELL\\Desktop\\IOProgramming\\data_handling\\src\\main\\java\\com\\intermediate\\update_value\\new.csv";

	     updater.updateSalary(inputFilePath, outputFilePath);
	}

}
