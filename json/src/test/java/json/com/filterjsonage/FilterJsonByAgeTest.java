package json.com.filterjsonage;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class FilterJsonByAgeTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void testFilterJsonByAge() throws Exception {
        // Load JSON from InputStream
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("users.json");

        assertNotNull(inputStream, "JSON file not found");

        List<Person> users = objectMapper.readValue(inputStream, new TypeReference<List<Person>>() {});

        // Filter users older than 25
        List<Person> filteredUsers = users.stream()
                .filter(user -> user.getAge() > 25)
                .collect(Collectors.toList());

        // Verify correct number of filtered users
        assertEquals(2, filteredUsers.size());

        // Verify names
        assertEquals("Bob", filteredUsers.get(0).getName());
        assertEquals("Charlie", filteredUsers.get(1).getName());
    }
}
