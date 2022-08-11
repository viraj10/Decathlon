package com.decathlon.model;

import java.math.BigDecimal;

public class AthleteBuilder {
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

    public AthleteBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public AthleteBuilder setTrack100meters(BigDecimal track100meters) {
        this.track100meters = track100meters;
        return this;
    }

    public AthleteBuilder setLongJump(BigDecimal longJump) {
        this.longJump = longJump;
        return this;
    }

    public AthleteBuilder setShotPut(BigDecimal shotPut) {
        this.shotPut = shotPut;
        return this;
    }

    public AthleteBuilder setHighJump(BigDecimal highJump) {
        this.highJump = highJump;
        return this;
    }

    public AthleteBuilder setTrack400m(BigDecimal track400m) {
        this.track400m = track400m;
        return this;
    }

    public AthleteBuilder setTrack110mHurdles(BigDecimal track110mHurdles) {
        this.track110mHurdles = track110mHurdles;
        return this;
    }

    public AthleteBuilder setDiscusThrow(BigDecimal discusThrow) {
        this.discusThrow = discusThrow;
        return this;
    }

    public AthleteBuilder setPoleVault(BigDecimal poleVault) {
        this.poleVault = poleVault;
        return this;
    }

    public AthleteBuilder setJavelinThrow(BigDecimal javelinThrow) {
        this.javelinThrow = javelinThrow;
        return this;
    }

    public AthleteBuilder setTrack1500m(BigDecimal track1500m) {
        this.track1500m = track1500m;
        return this;
    }

    public Athlete createAthlete() {
        return new Athlete(name, track100meters, longJump,
                shotPut, highJump, track400m, track110mHurdles,
                discusThrow, poleVault, javelinThrow, track1500m, null);
    }
}