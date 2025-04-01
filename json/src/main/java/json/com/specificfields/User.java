package json.com.specificfields;

public class User {
    public String name;
    public String email;
    public int age;
    public String city;

    // Constructor
    public User() {
       
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    // ToString method for printing (optional)
    @Override
    public String toString() {
        return "User{name='" + name + "', email='" + email + "'}";
    }
}
