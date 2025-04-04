package json.com.json_report_database;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

public class JsonReportGeneratorTest {

    @Test
    public void testManualDatabaseToJsonConversion() {
        List<Map<String, Object>> employeeList = new ArrayList<>();

        Map<String, Object> employee1 = new HashMap<>();
        employee1.put("id", 1);
        employee1.put("name", "Alice");
        employee1.put("age", 30);
        employee1.put("department", "HR");

        Map<String, Object> employee2 = new HashMap<>();
        employee2.put("id", 2);
        employee2.put("name", "Bob");
        employee2.put("age", 25);
        employee2.put("department", "Finance");

        Map<String, Object> employee3 = new HashMap<>();
        employee3.put("id", 3);
        employee3.put("name", "Charlie");
        employee3.put("age", 35);
        employee3.put("department", "IT");

        // Adding the records to the list
        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);

        try {
            // Convert the list of records to JSON
            ObjectMapper objectMapper = new ObjectMapper();
            String actualJson = objectMapper.writeValueAsString(employeeList);

            // Expected JSON output
            String expectedJson = """
            [
              {"id":1,"name":"Alice","age":30,"department":"HR"},
              {"id":2,"name":"Bob","age":25,"department":"Finance"},
              {"id":3,"name":"Charlie","age":35,"department":"IT"}
            ]
            """;

            // Parse both JSON strings as JSON nodes
            JsonNode expectedNode = objectMapper.readTree(expectedJson);
            JsonNode actualNode = objectMapper.readTree(actualJson);

            // Compare JSON nodes for equality, ignoring field order
            assertTrue(expectedNode.equals(actualNode));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
