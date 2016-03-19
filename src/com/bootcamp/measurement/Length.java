package com.bootcamp.measurement;


public enum Length implements Unit {
    FEET(12),
    INCH(1),
    CM(0.4),
    MM(0.04);

    private final double multiple;

    Length(double multiple) {
        this.multiple  = multiple;
    }

    @Override
    public double getMultiplier() {
        return multiple;
    }

    @Override
    public Unit standardOutput() {
        return Length.INCH;
    }

}
