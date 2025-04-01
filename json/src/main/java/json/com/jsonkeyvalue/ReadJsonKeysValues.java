package json.com.jsonkeyvalue;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class ReadJsonKeysValues {
    public static void main(String[] args) {
        try {
            // Create ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();
            
            // Read JSON file into JsonNode
            JsonNode jsonNode = objectMapper.readTree(new File("src/main/resources/keyvalue.json"));

            // Recursively print keys and values
            printJson(jsonNode, "");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printJson(JsonNode node, String prefix) {
        if (node.isObject()) {
            Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> entry = fields.next();
                printJson(entry.getValue(), prefix + entry.getKey() + ".");
            }
        } else if (node.isArray()) {
            for (int i = 0; i < node.size(); i++) {
                printJson(node.get(i), prefix + "[" + i + "] ");
            }
        } else {
            System.out.println(prefix.substring(0, prefix.length() - 1) + " = " + node.asText());
        }
    }
}
