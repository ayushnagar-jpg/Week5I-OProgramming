package json.com.studentobject;
import org.json.JSONArray;
import org.json.JSONObject;

public class StudentJson {
    public static void main(String[] args) {
        // Create a JSON object
        JSONObject student = new JSONObject();
        
        // Add key-value pairs
        student.put("name", "Ayush Nagar");
        student.put("age", 22);
        
        // Create a JSON array for subjects
        JSONArray subjects = new JSONArray();
        subjects.put("Math");
        subjects.put("Computer Science");
        subjects.put("Physics");

        // Add subjects array to student object
        student.put("subjects", subjects);

        // Print JSON object as a string
        System.out.println(student.toString(4)); 
    }
}
