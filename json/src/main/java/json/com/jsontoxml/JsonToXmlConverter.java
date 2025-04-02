package json.com.jsontoxml;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

public class JsonToXmlConverter {
    public static void main(String[] args) {
        try {
            // Initialize ObjectMapper for JSON
            ObjectMapper objectMapper = new ObjectMapper();

            // Read JSON file
            File jsonFile = new File("src/main/resources/sample.json");
            JsonNode jsonNode = objectMapper.readTree(jsonFile);

            // Initialize XmlMapper for XML conversion
            XmlMapper xmlMapper = new XmlMapper();
            String xml = xmlMapper.writeValueAsString(jsonNode);

            // Print XML output
            System.out.println("Converted XML:\n" + xml);

            // Save XML to file
            File xmlFile = new File("src/main/resources/output.xml");
            xmlMapper.writeValue(xmlFile, jsonNode);
            System.out.println("XML saved to: " + xmlFile.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
