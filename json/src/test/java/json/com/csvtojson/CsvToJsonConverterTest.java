package json.com.csvtojson;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class CsvToJsonConverterTest {
    private final CsvMapper csvMapper = new CsvMapper();
    private final ObjectMapper jsonMapper = new ObjectMapper();

    @Test
    public void testCsvToJsonConversion() throws IOException {
        // Mock CSV data (without reading from a file)
        String csvData = "name,email,age,city\n" +
                         "Alice,alice@example.com,25,New York\n" +
                         "Bob,bob@example.com,30,Los Angeles";

        // Define CSV Schema (header-based)
        CsvSchema csvSchema = CsvSchema.emptySchema().withHeader();

        // Convert CSV to List of Maps
        List<Object> data = csvMapper.readerFor(Map.class)
                .with(csvSchema)
                .readValues(csvData)
                .readAll();

        // Convert to JSON
        String json = jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);

        // Expected JSON output
        String expectedJson = "[{\"name\":\"Alice\",\"email\":\"alice@example.com\",\"age\":\"25\",\"city\":\"New York\"}," +
                              "{\"name\":\"Bob\",\"email\":\"bob@example.com\",\"age\":\"30\",\"city\":\"Los Angeles\"}]";

        // Convert expected JSON to JsonNode for comparison
        JsonNode expectedJsonNode = jsonMapper.readTree(expectedJson);
        JsonNode actualJsonNode = jsonMapper.readTree(json);

        // Assert that JSON output matches expected JSON
        assertEquals(expectedJsonNode, actualJsonNode);

        System.out.println("Test Passed: CSV successfully converted to JSON!");
    }
}

