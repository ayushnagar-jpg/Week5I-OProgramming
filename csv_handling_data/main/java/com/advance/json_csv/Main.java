package com.advance.json_csv;

public class Main {
    public static void main(String[] args) throws Exception {
        JsonCsvConverter converter = new JsonCsvConverter();
        
        // File paths
        String jsonFilePath = "C:\\Users\\DELL\\Desktop\\IOProgramming\\data_handling\\src\\main\\java\\com\\advance\\json_csv\\students.json";
        String csvFilePath = "C:\\Users\\DELL\\Desktop\\IOProgramming\\data_handling\\src\\main\\java\\com\\advance\\json_csv\\students.csv";
        String backToJsonFilePath = "C:\\Users\\DELL\\Desktop\\IOProgramming\\data_handling\\src\\main\\java\\com\\advance\\json_csv\\students_back.json";

        // Convert JSON to CSV
        converter.jsonToCsv(jsonFilePath, csvFilePath);

        // Convert CSV to JSON
        converter.csvToJson(csvFilePath, backToJsonFilePath);
    }
}

