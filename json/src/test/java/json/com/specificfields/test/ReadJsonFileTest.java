package json.com.specificfields.test;

import com.fasterxml.jackson.databind.ObjectMapper;

import json.com.specificfields.User;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReadJsonFileTest {

    @Test
    public void testReadJsonFile() throws IOException {
        // Create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        // Read the JSON file and map it to the User class
        User user = objectMapper.readValue(new File("src/main/resources/data.json"), User.class);

        // Assert that the name and email fields are correctly extracted
        assertEquals("Ayush Nagar", user.getName(), "Name should be Ayush");
        assertEquals("ayushnagar633@gmail.com", user.getEmail(), "Email should be ayushnaghar633@gmail.com");
    }
}
