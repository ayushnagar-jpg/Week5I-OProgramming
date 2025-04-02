package json.com.csvtojson;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CsvToJsonConverter {
    public static void main(String[] args) {
        try {
            // CSV file path
            File csvFile = new File("src/main/resources/data.csv");

            // Initialize CsvMapper
            CsvMapper csvMapper = new CsvMapper();
            CsvSchema csvSchema = CsvSchema.emptySchema().withHeader(); // Read CSV header

            // Read CSV as List of Maps
            MappingIterator<Map<String, String>> iterator = csvMapper.readerFor(Map.class)
                    .with(csvSchema)
                    .readValues(csvFile);

            List<Map<String, String>> data = iterator.readAll();

            // Convert to JSON
            ObjectMapper jsonMapper = new ObjectMapper();
            String json = jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);

            // Print JSON output
            System.out.println("Converted JSON:\n" + json);

            // Save JSON to a file
            jsonMapper.writeValue(new File("src/main/resources/output.json"), data);
            System.out.println("JSON saved to: src/main/resources/output.json");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
