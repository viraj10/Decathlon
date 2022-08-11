package com.decathlon.score.calculator;

import com.decathlon.score.CalculationParameters;

import java.math.BigDecimal;

public class JumpEventCalculator extends FieldEventCalculator {

    BigDecimal centiMeterToMeter = new BigDecimal(100);

    @Override
    public int calculate(BigDecimal measurement, CalculationParameters calculationParameters) {
        return super.calculate(measurement.multiply(centiMeterToMeter), calculationParameters);
    }
}
