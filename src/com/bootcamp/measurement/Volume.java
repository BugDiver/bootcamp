package com.bootcamp.measurement;

public enum Volume implements Unit {
    LITRE (1),
    GALLON(3.78);

    private double multiplier;

    Volume(double multiplier) {
        this.multiplier = multiplier;
    }

    @Override
    public double getMultiplier() {
        return this.multiplier;
    }

    @Override
    public Unit standardOutput() {
        return Volume.LITRE;
    }
}
