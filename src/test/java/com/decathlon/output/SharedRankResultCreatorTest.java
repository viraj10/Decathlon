package com.decathlon.output;

import com.decathlon.model.Athlete;
import com.decathlon.model.AthleteResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SharedRankResultCreatorTest {

    SharedRankResultCreator sharedRankResultCreator;

    @BeforeEach
    void setUp() {
        sharedRankResultCreator = new SharedRankResultCreator();
    }

    @Test
    void createResults_emptyAthletes() {
        assertEquals(0, sharedRankResultCreator.createResults(Collections.emptyList()).size());
    }

    @Test
    void createResults_uniqueRanks() {
        Athlete athlete1 = athlete(1000, "One");
        Athlete athlete2 = athlete(3000, "Two");
        Athlete athlete3 = athlete(2000, "Three");
        Athlete athlete4 = athlete(4000, "Four");
        List<AthleteResult> results = sharedRankResultCreator.createResults(Arrays.asList(athlete1, athlete2, athlete3, athlete4));
        assertEquals(4, results.size());
        assertRanks("Four", results, 0, "1");
        assertRanks("Two", results, 1, "2");
        assertRanks("Three", results, 2, "3");
        assertRanks("One", results, 3, "4");
    }

    @Test
    void createResults_shareRanks() {
        Athlete athlete1 = athlete(1000, "One");
        Athlete athlete2 = athlete(2000, "Two");
        Athlete athlete3 = athlete(2000, "Three");
        Athlete athlete4 = athlete(4000, "Four");
        List<AthleteResult> results = sharedRankResultCreator.createResults(Arrays.asList(athlete1, athlete2, athlete3, athlete4));
        assertEquals(4, results.size());
        assertRanks("Four", results, 0, "1");
        assertRanks("Two", results, 1, "2-3");
        assertRanks("Three", results, 2, "2-3");
        assertRanks("One", results, 3, "4");

    }

    private void assertRanks(String name, List<AthleteResult> results, int index, String rank) {
        assertEquals(name, results.get(index).getAthleteName());
        assertEquals(rank, results.get(index).getRank());
    }

    private Athlete athlete(int athleteScore, String one) {
        return new Athlete(one, new BigDecimal("1"), new BigDecimal("1"), new BigDecimal("1")
                , new BigDecimal("1"), new BigDecimal("1"), new BigDecimal("1"), new BigDecimal("1"), new BigDecimal("1")
                , new BigDecimal("1"), new BigDecimal("1"), athleteScore);
    }
}