package json.com.studentobject.test;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentJsonTest {

    @Test
    void testStudentJsonObject() {
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

        // ✅ Test name and age
        assertEquals("Ayush Nagar", student.getString("name"));
        assertEquals(22, student.getInt("age"));

        // ✅ Test if the subjects array is correctly stored
        JSONArray subjectsArray = student.getJSONArray("subjects");
        assertEquals(3, subjectsArray.length());
        assertEquals("Math", subjectsArray.getString(0));
        assertEquals("Computer Science", subjectsArray.getString(1));
        assertEquals("Physics", subjectsArray.getString(2));

        
      
        
        assertNotNull(student.toString());
    }
}
