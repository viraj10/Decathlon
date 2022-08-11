package com.decathlon.score;

import java.math.BigDecimal;

public class CalculationParameters {
    private final BigDecimal one;
    private final BigDecimal two;
    private final BigDecimal three;

    public CalculationParameters(BigDecimal one, BigDecimal two, BigDecimal three) {
        this.one = one;
        this.two = two;
        this.three = three;
    }

    public BigDecimal getOne() {
        return one;
    }

    public BigDecimal getTwo() {
        return two;
    }

    public BigDecimal getThree() {
        return three;
    }
}
