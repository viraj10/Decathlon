package com.decathlon.model;

import java.util.Objects;

public final class AthleteResult {
    private final String athleteName;
    private final String rank;
    private final int score;

    public AthleteResult(String athleteName, int score, String rank) {
        this.athleteName = athleteName;
        this.rank = rank;
        this.score = score;
    }

    public String getRank() {
        return rank;
    }

    public String getAthleteName() {
        return athleteName;
    }

    public int getScore() {
        return score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AthleteResult that = (AthleteResult) o;
        return score == that.score && Objects.equals(athleteName, that.athleteName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(athleteName, score);
    }
}
