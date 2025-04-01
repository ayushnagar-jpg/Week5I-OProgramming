package json.com.carobject;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Car {
    @JsonProperty("brand")  // Custom JSON key name
    private String make;
    private String model;
    private int year;

    // Constructor
    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    // Getters (needed for Jackson)
    public String getMake() { return make; }
    public String getModel() { return model; }
    public int getYear() { return year; }
}
