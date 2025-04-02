package com.advance.csv_to_object;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class TestStudentCSVReader {

    private final String filePath = "C:\\Users\\DELL\\Desktop\\IOProgramming\\data_handling\\src\\main\\java\\com\\advance\\csv_to_object\\students.csv";
    private final StudentCSVReader reader = new StudentCSVReader();

    @Test
    public void testReadStudentsFromCSV_ValidFile() {
        List<Student> students = reader.readStudentsFromCSV(filePath);

        // Check the total number of students
        assertEquals(5, students.size());

        // Check the details of the first student
        Student student1 = students.get(0);
        assertEquals(1, student1.getId());
        assertEquals("John", student1.getName());
        assertEquals(20, student1.getAge());
        assertEquals("A", student1.getGrade());

        // Check the details of the last student
        Student student5 = students.get(4);
        assertEquals(5, student5.getId());
        assertEquals("Bob", student5.getName());
        assertEquals(23, student5.getAge());
        assertEquals("B", student5.getGrade());
    }

    @Test
    public void testReadStudentsFromCSV_EmptyFile() {
        // Test with an empty CSV file
        String emptyFilePath = "C:\\Users\\DELL\\Desktop\\IOProgramming\\data_handling\\src\\main\\java\\com\\advance\\csv_to_object\\empty.csv";
        List<Student> students = reader.readStudentsFromCSV(emptyFilePath);

        // Check that the list is empty
        assertTrue("List should be empty for an empty file", students.isEmpty());
    }

    @Test
    public void testReadStudentsFromCSV_NonexistentFile() {
        // Test with a nonexistent file
        String nonexistentFilePath = "C:\\Users\\DELL\\Desktop\\IOProgramming\\data_handling\\src\\main\\java\\com\\advance\\csv_to_object\\nonexistent.csv";
        List<Student> students = reader.readStudentsFromCSV(nonexistentFilePath);

        // Check that the list is empty (as the file doesn't exist)
        assertTrue(students.isEmpty());
    }
}

