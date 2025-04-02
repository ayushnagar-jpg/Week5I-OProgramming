package json.com.mergetwojson.test;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MergeJsonFilesTest {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testJsonMerge() throws Exception {
        // Mock JSON data instead of reading files
        String json1 = "{ \"name\": \"Alice\", \"email\": \"alice@example.com\" }";
        String json2 = "{ \"age\": 25, \"city\": \"New York\" }";

        // Convert strings to JsonNode
        JsonNode jsonNode1 = objectMapper.readTree(json1);
        JsonNode jsonNode2 = objectMapper.readTree(json2);

        // Perform merging
        ObjectNode mergedJson = objectMapper.createObjectNode();
        mergedJson.setAll((ObjectNode) jsonNode1);
        mergedJson.setAll((ObjectNode) jsonNode2);

        // Expected JSON output
        String expectedJson = "{ \"name\": \"Alice\", \"email\": \"alice@example.com\", \"age\": 25, \"city\": \"New York\" }";
        JsonNode expectedJsonNode = objectMapper.readTree(expectedJson);

        // Assertion: Verify merged JSON matches expected JSON
        assertEquals(expectedJsonNode, mergedJson, "Merged JSON does not match expected output!");
    }
}
