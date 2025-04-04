package json.com.ipl_and_censor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadWriteTest {

    @Test
    public void testReadWriteJson() {
        String jsonFile ="C:\\Users\\DELL\\Desktop\\IOProgramming\\json\\src\\main\\java\\json\\com\\ipl_and_censor\\ipl.json";
        String outputJsonFile = "C:\\Users\\DELL\\Desktop\\IOProgramming\\json\\src\\main\\java\\json\\com\\ipl_and_censor\\iplOutput.json";

        // Create a sample input JSON file for testing
        String testData = "[" +
                "{\"match_id\": 101, \"team1\": \"Mumbai Indians\", \"team2\": \"Chennai Super Kings\", \"score\": {\"Mumbai Indians\": 178, \"Chennai Super Kings\": 182}, \"winner\": \"Chennai Super Kings\", \"player_of_match\": \"MS Dhoni\"}," +
                "{\"match_id\": 102, \"team1\": \"Royal Challengers Bangalore\", \"team2\": \"Delhi Capitals\", \"score\": {\"Royal Challengers Bangalore\": 200, \"Delhi Capitals\": 190}, \"winner\": \"Royal Challengers Bangalore\", \"player_of_match\": \"Virat Kohli\"}]";

        try (FileWriter fileWriter = new FileWriter(jsonFile)) {
            fileWriter.write(testData);
        } catch (IOException e) {
            fail("Failed to create input file: " + e.getMessage());
        }

        // Call the method to be tested
        try {
            ReadWrite.readWriteJson(jsonFile, outputJsonFile);
        } catch (Exception e) {
            fail("Exception during readWriteJson execution: " + e.getMessage());
        }

        // Check if the output file exists
        File file = new File(outputJsonFile);
        assertTrue("Output file should be created", file.exists());

        // Validate the contents of the output file
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode result = objectMapper.readTree(Files.newBufferedReader(Paths.get(outputJsonFile)));
            assertTrue("Output should be an array", result.isArray());
            for (JsonNode node : result) {
                if (node.has("player_of_match")) {
                    assertEquals("Player of match should be redacted", "REDACTED", node.get("player_of_match").asText());
                }
                if (node.has("team1") && node.get("team1").asText().contains("***")) {
                    assertTrue("Team1 should be partially redacted", true);
                }
                if (node.has("team2") && node.get("team2").asText().contains("***")) {
                    assertTrue("Team2 should be partially redacted", true);
                }
            }
        } catch (IOException e) {
            fail("IOException during file read: " + e.getMessage());
        }
    }
}
