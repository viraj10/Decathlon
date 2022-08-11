package com.decathlon.score.calculator;

import com.decathlon.score.CalculationParameters;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static com.decathlon.TestUtil.calculationParameter;
import static org.junit.jupiter.api.Assertions.*;

class TrackEventCalculatorTest {

    @Test
    void calculate_trackScore() {
        TrackEventCalculator trackEventCalculator = new TrackEventCalculator();
        assertEquals(424, trackEventCalculator.calculate(new BigDecimal("325.000072"), calculationParameter(0.03768, 480.0, 1.85)));
    }
}