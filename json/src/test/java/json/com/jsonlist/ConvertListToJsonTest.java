package json.com.jsonlist;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ConvertListToJsonTest {
    
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void testConvertListToJsonArray() throws Exception {
        List<Person> people = Arrays.asList(
            new Person("Alice", 25, "alice@example.com"),
            new Person("Bob", 30, "bob@example.com")
        );

        String jsonArray = objectMapper.writeValueAsString(people);

        // Check if JSON starts with "[" and ends with "]"
        assertTrue(jsonArray.startsWith("["));
        assertTrue(jsonArray.endsWith("]"));

        // Check if the JSON contains expected data
        assertTrue(jsonArray.contains("\"name\":\"Alice\""));
        assertTrue(jsonArray.contains("\"email\":\"bob@example.com\""));
    }
}
