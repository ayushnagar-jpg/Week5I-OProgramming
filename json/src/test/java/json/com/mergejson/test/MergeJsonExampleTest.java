package json.com.mergejson.test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import json.com.mergejson.MergeJsonExample;

import org.json.JSONObject;

class MergeJsonExampleTest {

    @Test
    void testMergeJsonObjects() {
        // Create first JSON object
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("name", "Alice");
        jsonObject1.put("age", 25);

        // Create second JSON object
        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("email", "alice@example.com");
        jsonObject2.put("city", "New York");

        // Merge JSON objects
        JSONObject result = MergeJsonExample.mergeJsonObjects(jsonObject1, jsonObject2);

        // Expected merged JSON object
        JSONObject expected = new JSONObject();
        expected.put("name", "Alice");
        expected.put("age", 25);
        expected.put("email", "alice@example.com");
        expected.put("city", "New York");

        // Assert that the merged JSON matches the expected
        assertEquals(expected.toString(), result.toString());
    }
}
