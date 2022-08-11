package com.decathlon.reader;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SimpleFileReaderTest {

    SimpleFileReader testSubject;

    @BeforeEach
    void setUp() {
        testSubject = new SimpleFileReader();
    }

    @Test
    void readFile() throws URISyntaxException {
        String filePath = Paths.get(SimpleFileReader.class.getResource("/results.csv").toURI()).toAbsolutePath().toString();
        List<String> fileLines = testSubject.readFile(filePath);
        assertEquals(4, fileLines.size());
    }

    @Test
    void readFile_missing_file() {
        List<String> fileLines = testSubject.readFile("/results_wrongfile.csv");
        assertEquals(0, fileLines.size());
    }
}