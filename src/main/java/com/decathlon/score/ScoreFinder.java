package com.decathlon.score;

import com.decathlon.exceptions.InvalidSportException;
import com.decathlon.model.Sports;
import com.decathlon.score.calculator.*;

import java.math.BigDecimal;

public class ScoreFinder {

    private final EventCalculator trackEventCalculator;
    private final EventCalculator jumpEventCalculator;
    private final EventCalculator fieldEventCalculator;

    public ScoreFinder(EventCalculator trackEventCalculator, EventCalculator jumpEventCalculator, EventCalculator fieldEventCalculator) {
        this.trackEventCalculator = trackEventCalculator;
        this.jumpEventCalculator = jumpEventCalculator;
        this.fieldEventCalculator = fieldEventCalculator;
    }

    public ScoreFinder() {
        this.trackEventCalculator = new TrackEventCalculator();
        this.jumpEventCalculator = new JumpEventCalculator();
        this.fieldEventCalculator = new FieldEventCalculator();
    }

    public int calculate(BigDecimal measurement, Sports sport) {
        if(measurement == null || sport == null) {
            throw new InvalidSportException("Measurement and Sport cannot be null");
        }

        switch (sport) {
            case TRACK_100_M:
                return trackEventCalculator.calculate(measurement, calculationParameter(25.4347, 18.0, 1.81));
            case LONG_JUMP:
                return jumpEventCalculator.calculate(measurement, calculationParameter(0.14354, 220.0, 1.4));
            case SHOT_PUT:
                return fieldEventCalculator.calculate(measurement, calculationParameter(51.39, 1.5, 1.05));
            case HIGH_JUMP:
                return jumpEventCalculator.calculate(measurement, calculationParameter(0.8465, 75.0, 1.42));
            case TRACK_400_M:
                return trackEventCalculator.calculate(measurement, calculationParameter(1.53775, 18.0, 1.81));
            case TRACK_110_M_HURDLES:
                return trackEventCalculator.calculate(measurement, calculationParameter(5.74352, 28.5, 1.92));
            case DISCUS_THROW:
                return fieldEventCalculator.calculate(measurement, calculationParameter(12.91, 4.0, 1.1));
            case POLE_VAULT:
                return jumpEventCalculator.calculate(measurement, calculationParameter(0.2797, 100.0, 1.35));
            case JAVELIN_THROW:
                return fieldEventCalculator.calculate(measurement, calculationParameter(10.14, 7.0, 1.08));
            case TRACK_1500_M:
                return trackEventCalculator.calculate(measurement, calculationParameter(0.03768, 480.0, 1.85));
        }
        System.out.println("Unidentified sport " + sport);
        throw new InvalidSportException("Unidentified sport " + sport);
    }

    private CalculationParameters calculationParameter(double val, double val1, double val2) {
        return new CalculationParameters(new BigDecimal(val), new BigDecimal(val1), new BigDecimal(val2));
    }
}