package json.com.jsonarray;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;

public class CarListToJson {
    public static void main(String[] args) {
        try {
            // Create a list of Car objects
            List<Car> cars = Arrays.asList(
                new Car("Tesla", "Model S", 2023),
                new Car("Ford", "Mustang", 2022),
                new Car("BMW", "X5", 2021)
            );

            // Convert list to JSON array
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonArray = objectMapper.writeValueAsString(cars);

            // Print the JSON output
            System.out.println(jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
