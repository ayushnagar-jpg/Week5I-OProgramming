package json.com.filterjsonage;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

public class FilterJsonByAge {
    public static void main(String[] args) {
        try {
            // Read JSON file as InputStream
        	InputStream inputStream = FilterJsonByAge.class.getClassLoader().getResourceAsStream("users.json");


            if (inputStream == null) {
                System.out.println("File not found!");
                return;
            }

            // Create ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // Read JSON array into List of Person objects
            List<Person> people = objectMapper.readValue(inputStream, new TypeReference<List<Person>>() {});

            // Filter users older than 25
            List<Person> filteredPeople = people.stream()
                    .filter(person -> person.getAge() > 25)
                    .collect(Collectors.toList());

            // Print filtered users
            filteredPeople.forEach(person -> 
                System.out.println(person.getName() + " - " + person.getAge() + " - " + person.getEmail()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
