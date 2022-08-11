package com.decathlon.score.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static com.decathlon.TestUtil.calculationParameter;
import static org.junit.jupiter.api.Assertions.*;

class FieldEventCalculatorTest {

    @Test
    void calculate_fieldScore() {
        FieldEventCalculator fieldEventCalculator = new FieldEventCalculator();
        assertEquals(382, fieldEventCalculator.calculate(new BigDecimal("35.81"), calculationParameter(10.14, 7.0, 1.08)));
    }
}