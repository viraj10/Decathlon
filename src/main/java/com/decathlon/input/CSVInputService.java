package com.decathlon.input;

import com.decathlon.exceptions.InvalidInputException;
import com.decathlon.model.Athlete;
import com.decathlon.model.AthleteBuilder;
import com.decathlon.reader.FileReader;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

public class CSVInputService implements InputService {

    public static final String DELIMITER = ";";
    public static int NAME_INDEX = 0;
    public static int TRACK_100_M_INDEX = 1;
    public static int TRACK_400_M_INDEX = 5;
    public static int TRACK_110_M_HURDLES_INDEX = 6;
    public static int TRACK_1500_M_INDEX = 10;
    public static int LONG_JUMP_INDEX = 2;
    public static int SHOT_PUT_INDEX = 3;
    public static int HIGH_JUMP_INDEX= 4;
    public static int DISCUS_THROW_INDEX = 7;
    public static int POLE_VAULT_INDEX = 8;
    public static int JAVELIN_THROW_INDEX = 9;

    private final FileReader fileReader;

    public CSVInputService(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    @Override
    public List<Athlete> readInput(String path) {
        List<String> linesInCSVFile = fileReader.readFile(path);
        System.out.println("Number of files read " + linesInCSVFile.size());
        List<Athlete> athletes = linesInCSVFile.stream()
                .map(this::mapLineToAthlete)
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Number of athletes created " + athletes.size());
        return athletes;
    }

    Athlete mapLineToAthlete(String line) {
        String[] valuesForAthletes = line.split(DELIMITER);
        if(valuesForAthletes.length != 11) {
            throw new InvalidInputException("Invalid line " + line);
        }
        return new AthleteBuilder()
                .setName(valuesForAthletes[NAME_INDEX])
                .setTrack100meters(new BigDecimal(valuesForAthletes[TRACK_100_M_INDEX]))
                .setTrack400m(new BigDecimal(valuesForAthletes[TRACK_400_M_INDEX]))
                .setTrack110mHurdles(new BigDecimal(valuesForAthletes[TRACK_110_M_HURDLES_INDEX]))
                .setTrack1500m(timeToSeconds(valuesForAthletes[TRACK_1500_M_INDEX]))
                .setDiscusThrow(new BigDecimal(valuesForAthletes[DISCUS_THROW_INDEX]))
                .setLongJump(new BigDecimal(valuesForAthletes[LONG_JUMP_INDEX]))
                .setShotPut(new BigDecimal(valuesForAthletes[SHOT_PUT_INDEX]))
                .setHighJump(new BigDecimal(valuesForAthletes[HIGH_JUMP_INDEX]))
                .setPoleVault(new BigDecimal(valuesForAthletes[POLE_VAULT_INDEX]))
                .setJavelinThrow(new BigDecimal(valuesForAthletes[JAVELIN_THROW_INDEX]))
                .createAthlete();
    }

    BigDecimal timeToSeconds(String value) {
        String[] split = value.trim().split("\\.");
        String[] minutesAndSeconds = split[0].split(":");
        int minute = Integer.parseInt(minutesAndSeconds[0]);
        int second = Integer.parseInt(minutesAndSeconds[1]);
        BigDecimal nanoSeconds = getNanoSeconds(split);
        BigDecimal time = new BigDecimal(LocalTime.of(0, minute, second).toSecondOfDay());
        return time.add(nanoSeconds);
    }

    private BigDecimal getNanoSeconds(String[] split) {
        return new BigDecimal(Integer.parseInt(split[1])).multiply(new BigDecimal("0.000001"));
    }
}
