package com.decathlon.score;

import com.decathlon.exceptions.InvalidSportException;
import com.decathlon.model.Sports;
import com.decathlon.score.calculator.FieldEventCalculator;
import com.decathlon.score.calculator.JumpEventCalculator;
import com.decathlon.score.calculator.TrackEventCalculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static com.decathlon.model.Sports.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class ScoreFinderTest {
    ScoreFinder testSubject;
    private TrackEventCalculator trackEventCalculator;
    private JumpEventCalculator jumpEventCalculator;
    private FieldEventCalculator fieldEventCalculator;

    @BeforeEach
    void setUp() {
        trackEventCalculator = mock(TrackEventCalculator.class);
        jumpEventCalculator = mock(JumpEventCalculator.class);
        fieldEventCalculator = mock(FieldEventCalculator.class);
        testSubject = new ScoreFinder(trackEventCalculator, jumpEventCalculator, fieldEventCalculator);
    }

    @Test
    void calculate_invalidSport() {
        assertThrows(InvalidSportException.class, () -> testSubject.calculate(new BigDecimal("1"), null));
    }

    @Test
    void calculate_invalidMeasurement() {
        assertThrows(InvalidSportException.class, () -> testSubject.calculate(null, TRACK_100_M));
    }

    @Test
    void calculate_100M() {
        testTrackEventCalculation(TRACK_100_M);
        ;
    }

    @Test
    void calculate_jump() {
        testJumpEventCalculation(LONG_JUMP);
        ;
    }

    @Test
    void calculate_shotPut() {
        testFeildEventCalculation(SHOT_PUT);
        ;
    }

    @Test
    void calculate_highJump() {
        testJumpEventCalculation(HIGH_JUMP);
        ;
    }

    @Test
    void calculate_400M() {
        testTrackEventCalculation(TRACK_400_M);
    }

    @Test
    void calculate_110M() {
        testTrackEventCalculation(TRACK_110_M_HURDLES);
    }

    @Test
    void calculate_discussThrow() {
        testFeildEventCalculation(DISCUS_THROW);
        ;
    }

    @Test
    void calculate_poleVault() {
        testJumpEventCalculation(POLE_VAULT);
        ;
    }

    @Test
    void calculate_javelinThrow() {
        testFeildEventCalculation(JAVELIN_THROW);
    }

    @Test
    void calculate_1500M() {
        testTrackEventCalculation(TRACK_1500_M);
    }

    private void testJumpEventCalculation(Sports highJump) {
        BigDecimal measurement = new BigDecimal("12.61");
        int expected = 777;
        when(jumpEventCalculator.calculate(eq(measurement), any(CalculationParameters.class))).thenReturn(expected);
        assertEquals(expected, testSubject.calculate(measurement, highJump));
    }

    private void testFeildEventCalculation(Sports javelinThrow) {
        BigDecimal measurement = new BigDecimal("12.61");
        int expected = 777;
        when(fieldEventCalculator.calculate(eq(measurement), any(CalculationParameters.class))).thenReturn(expected);
        assertEquals(expected, testSubject.calculate(measurement, javelinThrow));
    }

    private void testTrackEventCalculation(Sports track1500M) {
        BigDecimal measurement = new BigDecimal("12.61");
        int expected = 777;
        when(trackEventCalculator.calculate(eq(measurement), any(CalculationParameters.class))).thenReturn(expected);
        assertEquals(expected, testSubject.calculate(measurement, track1500M));
    }

}