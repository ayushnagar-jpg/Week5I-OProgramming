package json.com.jsontoxml;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JsonToXmlConverterTest {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final XmlMapper xmlMapper = new XmlMapper();

    @Test
    public void testJsonToXmlConversion() throws Exception {
        // Mock JSON data
        String json = "{ \"name\": \"Alice\", \"email\": \"alice@example.com\", \"age\": 25, \"city\": \"New York\" }";

        // Convert JSON to JsonNode
        JsonNode jsonNode = objectMapper.readTree(json);

        // Convert JsonNode to XML
        String xml = xmlMapper.writeValueAsString(jsonNode);

        // Expected XML format
        @SuppressWarnings("unused")
		String expectedXml =
                "<ObjectNode>" +
                "<name>Alice</name>" +
                "<email>alice@example.com</email>" +
                "<age>25</age>" +
                "<city>New York</city>" +
                "</ObjectNode>";

        // Assert that the converted XML matches expected output
        assertTrue(xml.contains("<name>Alice</name>"));
        assertTrue(xml.contains("<email>alice@example.com</email>"));
        assertTrue(xml.contains("<age>25</age>"));
        assertTrue(xml.contains("<city>New York</city>"));

        System.out.println("Test Passed: JSON successfully converted to XML!");
    }
}
