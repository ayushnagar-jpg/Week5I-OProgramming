package json.com.carobject.test;
import com.fasterxml.jackson.databind.ObjectMapper;
import json.com.carobject.Car;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

class CarTest {

    @Test
    void testCarToJson() {
        try {
            // Create ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // Create Car object
            Car car = new Car("Tesla", "Model S", 2023);

            // Convert Car object to JSON String
            String jsonString = objectMapper.writeValueAsString(car);

            // Define expected JSON string
            String expectedJson = "{\"brand\":\"Tesla\",\"model\":\"Model S\",\"year\":2023}";

            // Compare the JSON strings ignoring key order
            JSONAssert.assertEquals(expectedJson, jsonString, false);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
