package com.decathlon.output;

import com.decathlon.model.AthleteResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class XmlWriterTest {
    public static final String TEST_FILE_PATH = "/test-results.xml";
    XmlWriter testSubject;
    @BeforeEach
    void setUp() {
        testSubject = new XmlWriter();
    }

    @Test
    void writeFileWithoutPath() {
        List<AthleteResult> athleteResultList = new ArrayList<>();
        athleteResultList.add(new AthleteResult("1", 123, "1"));
        athleteResultList.add(new AthleteResult("1", 110, "2"));
        boolean result = testSubject.writeFile(athleteResultList);
        assertTrue(result);
    }

    @Test
    void writeFileWithPath() throws URISyntaxException {
        List<AthleteResult> athleteResultList = new ArrayList<>();
        athleteResultList.add(new AthleteResult("1", 123, "1"));
        athleteResultList.add(new AthleteResult("1", 110, "2"));
        String filePath = Paths.get(XmlWriterTest.class.getResource(TEST_FILE_PATH).toURI()).toAbsolutePath().toString();
        boolean result = testSubject.writeFile(athleteResultList, filePath);
        assertTrue(result);
        assertTrue(Files.exists(Paths.get(filePath)));
    }
}