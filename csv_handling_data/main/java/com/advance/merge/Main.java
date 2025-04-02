package com.advance.merge;

public class Main {
    public static void main(String[] args) {
        CSVFileMerger merger = new CSVFileMerger();
        String file1Path = "C:\\Users\\DELL\\Desktop\\IOProgramming\\data_handling\\src\\main\\java\\com\\advance\\merge\\csv1.csv";
        String file2Path = "C:\\Users\\DELL\\Desktop\\IOProgramming\\data_handling\\src\\main\\java\\com\\advance\\merge\\csv2.csv";
        String outputFilePath = "C:\\Users\\DELL\\Desktop\\IOProgramming\\data_handling\\src\\main\\java\\com\\advance\\merge\\allDetails.csv";

        merger.mergeCSVFiles(file1Path, file2Path, outputFilePath);
    }
}
