package json.com.jsonstructure;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    @JsonProperty(required = true) // This makes it mandatory
    private String name;
    
    @JsonProperty(required = true)
    private int age;

    @JsonProperty(required = true)
    private String email; // Now mandatory

    // Getters and setters
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getEmail() { return email; }
}

