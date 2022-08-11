package com.decathlon;

import com.decathlon.score.CalculationParameters;

import java.math.BigDecimal;

public class TestUtil {
    public static CalculationParameters calculationParameter(double val, double val1, double val2) {
        return new CalculationParameters(new BigDecimal(val), new BigDecimal(val1), new BigDecimal(val2));
    }
}
