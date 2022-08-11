package com.decathlon.score.calculator;

import com.decathlon.score.CalculationParameters;

import java.math.BigDecimal;

public interface EventCalculator {

    public int calculate(BigDecimal measurement, CalculationParameters calculationParameters);

}
