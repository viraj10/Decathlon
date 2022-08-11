package com.decathlon.output;

import com.decathlon.model.AthleteResult;

import java.util.List;

public interface FileWriter {
    boolean writeFile(List<AthleteResult> results, String path);
    boolean writeFile(List<AthleteResult> results);
}
