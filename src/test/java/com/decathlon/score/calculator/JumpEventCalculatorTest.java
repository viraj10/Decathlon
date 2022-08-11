package com.decathlon.score.calculator;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static com.decathlon.TestUtil.calculationParameter;
import static org.junit.jupiter.api.Assertions.*;

class JumpEventCalculatorTest {

    @Test
    void calculate_jumpScore() {
        JumpEventCalculator jumpEventCalculator = new JumpEventCalculator();
        assertEquals(17, jumpEventCalculator.calculate(new BigDecimal("1.21"), calculationParameter(0.2797, 100.0, 1.35)));
    }
}