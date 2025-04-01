package json.com.jsonarrayTest;
import com.fasterxml.jackson.databind.ObjectMapper;

import json.com.jsonarray.Car;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class CarListToJsonTest {
    
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void testCarListToJson() throws Exception {
        List<Car> cars = Arrays.asList(
            new Car("Tesla", "Model S", 2023),
            new Car("Ford", "Mustang", 2022)
        );

        // Convert list to JSON
        String jsonArray = objectMapper.writeValueAsString(cars);

        // Expected JSON string
        String expectedJson = "[{\"brand\":\"Tesla\",\"model\":\"Model S\",\"year\":2023}," +
                              "{\"brand\":\"Ford\",\"model\":\"Mustang\",\"year\":2022}]";

        assertEquals(expectedJson, jsonArray);
    }
}
