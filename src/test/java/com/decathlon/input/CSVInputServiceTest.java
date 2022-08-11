package com.decathlon.input;

import com.decathlon.exceptions.InvalidInputException;
import com.decathlon.model.Athlete;
import com.decathlon.reader.FileReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;

class CSVInputServiceTest {

    public static final String MOCK_PATH_CSV = "mock-path.csv";
    CSVInputService testSubject;
    private FileReader fileReader;


    @BeforeEach
    void setUp() {
        fileReader = mock(FileReader.class);
        testSubject = new CSVInputService(fileReader);
    }

    @Test
    void readInput_emptyLines() {
        when(fileReader.readFile(MOCK_PATH_CSV)).thenReturn(new ArrayList<>());
        List<Athlete> athletes = testSubject.readInput(MOCK_PATH_CSV);
        assertEquals(0, athletes.size());
    }

    @Test
    void readInput_multipleLines() {
        List<String> linesInCSVFile = new ArrayList<>();
        linesInCSVFile.add("John Smith;12.61;5.00;9.22;1.50;60.39;16.43;21.60;2.60;35.81;5:25.72");
        linesInCSVFile.add("Foo Bar;13.43;4.35;8.64;1.50;66.06;19.05;24.89;2.20;33.48;6:51.01");
        when(fileReader.readFile(MOCK_PATH_CSV)).thenReturn(linesInCSVFile);
        List<Athlete> athletes = testSubject.readInput(MOCK_PATH_CSV);
        assertEquals(2, athletes.size());
        assertEquals("John Smith", athletes.get(0).getName());
        assertEquals("Foo Bar", athletes.get(1).getName());
    }

    @Test
    void readInput_singleRecord() {
        List<String> linesInCSVFile = new ArrayList<>();
        linesInCSVFile.add("John Smith;12.61;5.00;9.22;1.50;60.39;16.43;21.60;2.60;35.81;5:25.72");
        when(fileReader.readFile(MOCK_PATH_CSV)).thenReturn(linesInCSVFile);
        List<Athlete> athletes = testSubject.readInput(MOCK_PATH_CSV);
        assertEquals(1, athletes.size());
        Athlete athlete = athletes.get(0);
        assertEquals("John Smith", athlete.getName());
        assertEquals(new BigDecimal("21.60"), athlete.getDiscusThrow());
        assertEquals(new BigDecimal("1.50"), athlete.getHighJump());
        assertEquals(new BigDecimal("35.81"), athlete.getJavelinThrow());
        assertEquals(new BigDecimal("2.60"), athlete.getPoleVault());
        assertEquals(new BigDecimal("60.39"), athlete.getTrack400m());
        assertEquals(new BigDecimal("325.000072"), athlete.getTrack1500m());
        assertEquals(new BigDecimal("16.43"), athlete.getTrack110mHurdles());
        assertEquals(new BigDecimal("12.61"), athlete.getTrack100meters());
        assertEquals(new BigDecimal("9.22"), athlete.getShotPut());
        assertEquals(new BigDecimal("5.00"), athlete.getLongJump());
    }

    @Test
    void timeToSeconds() {
        //5*60 + 25 = 325 + 72 nanoseconds
        assertEquals(new BigDecimal("325.000072"), testSubject.timeToSeconds("5:25.72"));
    }

    @Test
    void mapLineToAthlete_invalidInput() {
        String input = "John Smith;12.61;5.00;9.22;1.50;60.39;16.43;21.60;2.60"; // 8 entries
        assertThrows(InvalidInputException.class, () -> testSubject.mapLineToAthlete(input));
    }

    @Test
    void mapLineToAthlete_validInput() {
        String input = "John Smith;12.61;5.00;9.22;1.50;60.39;16.43;21.60;2.60;35.81;5:25.72";
        Athlete athlete = testSubject.mapLineToAthlete(input);
        assertEquals("John Smith", athlete.getName());
    }
}