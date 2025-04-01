package json.com.jsonstructure.test;
import com.fasterxml.jackson.databind.ObjectMapper;
import json.com.jsonstructure.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JsonValidatorTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void testValidJson() {
        String validJson = "{\"name\": \"Alice\", \"age\": 25, \"email\": \"alice@example.com\"}";

        assertDoesNotThrow(() -> {
            User user = objectMapper.readValue(validJson, User.class);
            assertNotNull(user);
            assertEquals("Alice", user.getName());
            assertEquals(25, user.getAge());
            assertEquals("alice@example.com", user.getEmail());
        });
    }

   
    @Test
    void testMalformedJson() {
        String malformedJson = "{\"name\": \"Alice\", \"age\": 25, \"email\": \"alice@example.com\""; // Missing closing brace

        assertThrows(JsonProcessingException.class, () -> objectMapper.readValue(malformedJson, User.class));
    }
    @Test
    void testInvalidJson_MissingField() throws Exception {
        String invalidJson = "{\"name\": \"Alice\", \"age\": 25}";

        User user = objectMapper.readValue(invalidJson, User.class);

        assertNull(user.getEmail(), "Email should be null when missing");
    }

}
