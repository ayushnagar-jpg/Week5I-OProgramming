package json.com.jsonstructure;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

public class JsonValidator {
    public static void main(String[] args) {
        // Example JSON string
        String jsonString = "{\"name\": \"Ayush\", \"age\": 22, \"email\": \"ayushnagar633@gmail.com\"}";

        // Create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Validate by deserializing JSON into User class
            User user = objectMapper.readValue(jsonString, User.class);
            System.out.println("Valid JSON! Mapped User: " + user.getName() + ", " + user.getAge() + ", " + user.getEmail());
        } catch (JsonProcessingException e) {
            // If JSON is invalid or structure mismatched
            System.out.println("Invalid JSON structure: " + e.getMessage());
        }
    }
}
