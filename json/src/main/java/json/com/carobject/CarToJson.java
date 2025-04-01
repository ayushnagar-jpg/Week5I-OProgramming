package json.com.carobject;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CarToJson {
    public static void main(String[] args) {
        try {
            // Create ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // Create Car object
            Car car = new Car("Tesla", "Model S", 2023);

            // Convert Car object to JSON String
            String jsonString = objectMapper.writeValueAsString(car);

            // Print JSON output
            System.out.println(jsonString);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
