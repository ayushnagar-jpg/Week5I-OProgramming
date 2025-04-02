package json.com.mergetwojson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class MergeJsonFiles {
    public static void main(String[] args) {
        try {
            // Initialize ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();

            // Load JSON files from resources folder
            ClassLoader classLoader = MergeJsonFiles.class.getClassLoader();
            URL file1Url = classLoader.getResource("json1.json");
            URL file2Url = classLoader.getResource("json2.json");

            if (file1Url == null || file2Url == null) {
                System.out.println("One or both JSON files are missing!");
                return;
            }

            // Read JSON files
            JsonNode jsonNode1 = objectMapper.readTree(new File(file1Url.getFile()));
            JsonNode jsonNode2 = objectMapper.readTree(new File(file2Url.getFile()));

            // Merge JSON objects
            ObjectNode mergedJson = objectMapper.createObjectNode();
            mergedJson.setAll((ObjectNode) jsonNode1);
            mergedJson.setAll((ObjectNode) jsonNode2);

            // Print merged JSON
            System.out.println("Merged JSON: " + mergedJson.toPrettyString());

            // Write merged JSON to a new file
            File outputFile = new File("merged.json");
            objectMapper.writeValue(outputFile, mergedJson);
            System.out.println("Merged JSON saved to: " + outputFile.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
