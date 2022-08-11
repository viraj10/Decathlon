package com.decathlon.input;

import com.decathlon.model.Athlete;

import java.util.List;

public interface InputService {
    List<Athlete> readInput(String path);
}
