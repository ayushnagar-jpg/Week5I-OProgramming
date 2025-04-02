package json.com.jsonlist;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.util.Arrays;
import java.util.List;

public class ConvertListToJson {
    public static void main(String[] args) {
        try {
            // Create a list of Person objects
            List<Person> people = Arrays.asList(
                new Person("Alice", 25, "alice@example.com"),
                new Person("Bob", 30, "bob@example.com"),
                new Person("Charlie", 28, "charlie@example.com")
            );

            // Convert list to JSON using ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT); // Pretty Print

            String jsonArray = objectMapper.writeValueAsString(people);

            // Print the JSON array
            System.out.println(jsonArray);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
