package com.decathlon.model;

import com.decathlon.score.ScoreFinder;

import java.math.BigDecimal;
import java.util.Objects;

//optional event possible
public class Athlete {

    private String name;
    private BigDecimal track100meters;
    private BigDecimal longJump;
    private BigDecimal shotPut;
    private BigDecimal highJump;
    private BigDecimal track400m;
    private BigDecimal track110mHurdles;
    private BigDecimal discusThrow;
    private BigDecimal poleVault;
    private BigDecimal javelinThrow;
    private BigDecimal track1500m;
    private Integer athleteScore;

    public Integer getAthleteScore() {
        if (athleteScore == null) {
            athleteScore = calculateAthleteScore();
        }
        return athleteScore;
    }

    public Athlete(String name, BigDecimal track100meters, BigDecimal longJump,
                   BigDecimal shotPut, BigDecimal highJump, BigDecimal track400m,
                   BigDecimal track110mHurdles, BigDecimal discusThrow,
                   BigDecimal poleVault, BigDecimal javelinThrow, BigDecimal track1500m,
                   Integer athleteScore) {
        this.name = name;
        this.track100meters = track100meters;
        this.longJump = longJump;
        this.shotPut = shotPut;
        this.highJump = highJump;
        this.track400m = track400m;
        this.track110mHurdles = track110mHurdles;
        this.discusThrow = discusThrow;
        this.poleVault = poleVault;
        this.javelinThrow = javelinThrow;
        this.track1500m = track1500m;
        this.athleteScore = athleteScore;
    }

    private Integer calculateAthleteScore() {
        ScoreFinder scoreFinder = new ScoreFinder();
        return scoreFinder.calculate(track100meters, Sports.TRACK_100_M) +
                scoreFinder.calculate(longJump, Sports.LONG_JUMP) +
                scoreFinder.calculate(shotPut, Sports.SHOT_PUT) +
                scoreFinder.calculate(highJump, Sports.HIGH_JUMP) +
                scoreFinder.calculate(track400m, Sports.TRACK_400_M) +
                scoreFinder.calculate(track110mHurdles, Sports.TRACK_110_M_HURDLES) +
                scoreFinder.calculate(discusThrow, Sports.DISCUS_THROW) +
                scoreFinder.calculate(poleVault, Sports.POLE_VAULT) +
                scoreFinder.calculate(javelinThrow, Sports.JAVELIN_THROW) +
                scoreFinder.calculate(track1500m, Sports.TRACK_1500_M);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Athlete athlete = (Athlete) o;
        return name.equals(athlete.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getTrack100meters() {
        return track100meters;
    }

    public void setTrack100meters(BigDecimal track100meters) {
        this.track100meters = track100meters;
    }

    public BigDecimal getLongJump() {
        return longJump;
    }

    public void setLongJump(BigDecimal longJump) {
        this.longJump = longJump;
    }

    public BigDecimal getShotPut() {
        return shotPut;
    }

    public void setShotPut(BigDecimal shotPut) {
        this.shotPut = shotPut;
    }

    public BigDecimal getHighJump() {
        return highJump;
    }

    public void setHighJump(BigDecimal highJump) {
        this.highJump = highJump;
    }

    public BigDecimal getTrack400m() {
        return track400m;
    }

    public void setTrack400m(BigDecimal track400m) {
        this.track400m = track400m;
    }

    public BigDecimal getTrack110mHurdles() {
        return track110mHurdles;
    }

    public void setTrack110mHurdles(BigDecimal track110mHurdles) {
        this.track110mHurdles = track110mHurdles;
    }

    public BigDecimal getDiscusThrow() {
        return discusThrow;
    }

    public void setDiscusThrow(BigDecimal discusThrow) {
        this.discusThrow = discusThrow;
    }

    public BigDecimal getPoleVault() {
        return poleVault;
    }

    public void setPoleVault(BigDecimal poleVault) {
        this.poleVault = poleVault;
    }

    public BigDecimal getJavelinThrow() {
        return javelinThrow;
    }

    public void setJavelinThrow(BigDecimal javelinThrow) {
        this.javelinThrow = javelinThrow;
    }

    public BigDecimal getTrack1500m() {
        return track1500m;
    }

    public void setTrack1500m(BigDecimal track1500m) {
        this.track1500m = track1500m;
    }
}
