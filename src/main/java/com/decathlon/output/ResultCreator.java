package com.decathlon.output;

import com.decathlon.model.Athlete;
import com.decathlon.model.AthleteResult;

import java.util.List;

public interface ResultCreator {
    List<AthleteResult> createResults(List<Athlete> athletes);
}
