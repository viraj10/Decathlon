package com.decathlon.output;

import com.decathlon.model.Athlete;
import com.decathlon.model.AthleteResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SharedRankResultCreator implements ResultCreator {

    @Override
    public List<AthleteResult> createResults(List<Athlete> athletes) {
        System.out.println("Creating Results for athletes: " + athletes.size());
        List<AthleteResult> result = new ArrayList<>();
        if(athletes.isEmpty()) {
            return result;
        }
        Collections.sort(athletes,
                (athleteOne, athleteTwo) -> athleteTwo.getAthleteScore() - athleteOne.getAthleteScore());
        int size = athletes.size();
        for (int i = 0; i < size; i++) {
            Athlete athlete = athletes.get(i);
            int previous = i;
            while (i + 1 < size && athletes.get(i + 1).getAthleteScore().equals(athlete.getAthleteScore())) {
                i++;
            }
            result.addAll(athleteResults(previous, i, athletes));
        }
        System.out.println("Created Results for athletes: " + result.size());
        return result;
    }

    private List<AthleteResult> athleteResults(int start, int end, List<Athlete> athletes) {
        List<AthleteResult> result = new ArrayList<>();
        if (start == end) {
            Athlete athlete = athletes.get(start);
            result.add(new AthleteResult(athlete.getName(), athlete.getAthleteScore(), "" + (start + 1)));
        }
        else {
            String sharedRank = (start + 1) + "-" + (end + 1);
            while (start <= end) {
                Athlete athlete = athletes.get(start);
                result.add(new AthleteResult(athlete.getName(), athlete.getAthleteScore(), sharedRank));
                start++;
            }
        }
        return result;
    }

}