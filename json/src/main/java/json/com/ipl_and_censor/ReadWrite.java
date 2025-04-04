package json.com.ipl_and_censor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

public class ReadWrite {
	//reading json from file and writing after changes(censor and reductant)
	public static void readWriteJson(String inpJson, String outJson) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode matcher = objectMapper.readTree(new File(inpJson));
            if (matcher.isArray() && matcher.size() > 0) {
                for (JsonNode match : matcher) {
                    if (match.has("team1") && match.has("team2")) {
                        ((ObjectNode) match).put("team1", Censor.censorData(match.get("team1").asText()));
                        ((ObjectNode) match).put("team2", Censor.censorData(match.get("team2").asText()));
                        ((ObjectNode) match).put("player_of_match", "REDACTED");
                    } else {
                        System.out.println("Missing expected fields in JSON object: " + match.toString());
                    }
                }
                objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(outJson), matcher);
                System.out.println("Data successfully written to: " + outJson);
            } else {
                System.out.println("Not a valid array or array is empty");
            }
        } catch (IOException e) {
            System.err.println("Error processing the JSON file: " + e.getMessage());
            e.printStackTrace();
        }
    }
	//read csv from file and writing after changes(censor and reductant)
	public static void readWriteCsv(String inpCsv,String outCsv) throws IOException, CsvException {
		try(CSVReader reader = new CSVReader(new FileReader(inpCsv));
				CSVWriter writer = new CSVWriter(new FileWriter(outCsv))) {
			List<String[]>records = reader.readAll();
			List<String[]>censorData = new ArrayList<>();
			
			for(String[] record : records) {
				if (record.length < 7) {
	                System.err.println("Skipping malformed row: " + Arrays.toString(record));
	                continue;
	            }
				if(!record[0].equals("match_id"))//it is to skip header row;
				{
					record[1]=Censor.censorData(record[1]);
					record[2]=Censor.censorData(record[2]);
					record[6]="REDACTED";
				}
				censorData.add(record);
			}
			writer.writeAll(censorData);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
