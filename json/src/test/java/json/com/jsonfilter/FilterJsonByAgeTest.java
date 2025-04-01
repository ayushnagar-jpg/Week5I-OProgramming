package json.com.jsonfilter;
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
        // Load JSON from input stream
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("filter.json");
        assertNotNull(inputStream, "File not found: data.json");

        // Deserialize JSON array into List<Person>
        List<Person> people = objectMapper.readValue(inputStream, new TypeReference<List<Person>>() {});

        // Filter people where age > 25
        List<Person> filteredPeople = people.stream()
                .filter(person -> person.getAge() > 25)
                .collect(Collectors.toList());

        // Assert the filtering works correctly
        assertEquals(2, filteredPeople.size());
        assertEquals("Bob", filteredPeople.get(0).getName());
        assertEquals("Charlie", filteredPeople.get(1).getName());
    }
}

