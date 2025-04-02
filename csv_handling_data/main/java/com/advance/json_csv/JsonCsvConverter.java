package com.advance.json_csv;


public class JsonCsvConverter {
    private JsonToCsv jsonToCsv = new JsonToCsv();
    private CsvToJson csvToJson = new CsvToJson();

    public void jsonToCsv(String jsonFilePath, String csvFilePath) throws Exception {
        jsonToCsv.convert(jsonFilePath, csvFilePath);
    }

    public void csvToJson(String csvFilePath, String jsonFilePath) {
        csvToJson.convert(csvFilePath, jsonFilePath);
    }
}

