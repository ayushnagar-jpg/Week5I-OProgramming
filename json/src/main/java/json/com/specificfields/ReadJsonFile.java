package json.com.specificfields;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class ReadJsonFile {
    public static void main(String[] args) {
        try {
            // Use ClassLoader to read from resources folder
            InputStream inputStream = ReadJsonFile.class.getClassLoader().getResourceAsStream("data.json");

            if (inputStream == null) {
                System.out.println("File not found in resources folder");
                return;
            }

            // Create ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // Read JSON from InputStream and map it to the User class
            User user = objectMapper.readValue(inputStream, User.class);

            // Extract specific fields (name and email)
            System.out.println("Name: " + user.getName());
            System.out.println("Email: " + user.getEmail());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
