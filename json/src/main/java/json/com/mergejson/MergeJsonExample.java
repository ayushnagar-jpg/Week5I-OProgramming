package json.com.mergejson;
import org.json.JSONObject;

public class MergeJsonExample {

    // Method to merge two JSON objects
    public static JSONObject mergeJsonObjects(JSONObject jsonObject1, JSONObject jsonObject2) {
        for (String key : jsonObject2.keySet()) {
            jsonObject1.put(key, jsonObject2.get(key));
        }
        return jsonObject1;
    }

    public static void main(String[] args) {
        // Create first JSON object
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("name", "Alice");
        jsonObject1.put("age", 25);

        // Create second JSON object
        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("email", "alice@example.com");
        jsonObject2.put("city", "New York");

        // Merging jsonObject2 into jsonObject1
        JSONObject mergedJson = mergeJsonObjects(jsonObject1, jsonObject2);

        // Print the merged JSON object
        System.out.println(mergedJson.toString(4)); // Indented with 4 spaces
    }
}
