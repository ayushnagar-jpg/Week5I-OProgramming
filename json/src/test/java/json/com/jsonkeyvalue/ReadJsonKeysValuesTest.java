package json.com.jsonkeyvalue;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ReadJsonKeysValuesTest {

    private ObjectMapper objectMapper;
    private JsonNode jsonNode;
    private Map<String, String> keyValueMap;

    @BeforeEach
    void setUp() throws IOException {
        objectMapper = new ObjectMapper();

        // Load JSON from the resources folder
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("keyvalue.json");
        assertNotNull(inputStream, "JSON file not found");

        jsonNode = objectMapper.readTree(inputStream);
        keyValueMap = new LinkedHashMap<>();
        extractJson(jsonNode, "", keyValueMap);
    }

    private void extractJson(JsonNode node, String keyPrefix, Map<String, String> map) {
        if (node.isObject()) {
            // Iterate through object fields
            node.fields().forEachRemaining(entry -> extractJson(entry.getValue(), keyPrefix + entry.getKey() + ".", map));
        } else if (node.isArray()) {
            // Handle JSON arrays properly
            for (int i = 0; i < node.size(); i++) {
                extractJson(node.get(i), keyPrefix + i + ".", map);
            }
        } else {
            // Store key-value pairs (remove trailing dot)
            map.put(keyPrefix.endsWith(".") ? keyPrefix.substring(0, keyPrefix.length() - 1) : keyPrefix, node.asText());
        }
    }

    @Test
    void testKeyValueExtraction() {
        assertEquals("Alice", keyValueMap.get("name"));
        assertEquals("25", keyValueMap.get("age"));
        assertEquals("alice@example.com", keyValueMap.get("email"));
        assertEquals("New York", keyValueMap.get("address.city"));
        assertEquals("10001", keyValueMap.get("address.zip"));

        // ✅ Fix: Array elements are now correctly stored
        assertEquals("Reading", keyValueMap.get("hobbies.0"));
        assertEquals("Swimming", keyValueMap.get("hobbies.1"));
        assertEquals("Traveling", keyValueMap.get("hobbies.2"));
    }
}
