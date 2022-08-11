package com.decathlon.score.calculator;

import com.decathlon.score.CalculationParameters;

import java.math.BigDecimal;

public class TrackEventCalculator implements EventCalculator {

    @Override
    public int calculate(BigDecimal measurement, CalculationParameters parameters) {
        double subtract = parameters.getTwo().subtract(measurement).doubleValue();
        double thirdParam = parameters.getThree().doubleValue();
        Double result = parameters.getOne().doubleValue() * Math.pow(subtract, thirdParam);
        return result.intValue();
    }

}
