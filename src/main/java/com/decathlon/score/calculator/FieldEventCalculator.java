package com.decathlon.score.calculator;

import com.decathlon.score.CalculationParameters;

import java.math.BigDecimal;

public class FieldEventCalculator implements EventCalculator {
    @Override
    public int calculate(BigDecimal measurement, CalculationParameters parameters) {
        double subtract = measurement.subtract(parameters.getTwo()).doubleValue();
        double thirdParam = parameters.getThree().doubleValue();
        Double result = parameters.getOne().doubleValue() * Math.pow(subtract, thirdParam);
        return result.intValue();
    }

}
