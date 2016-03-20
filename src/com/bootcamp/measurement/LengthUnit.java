package com.bootcamp.measurement;


public enum LengthUnit implements Unit {
    FEET(12),
    INCH(1),
    CM(0.4),
    MM(0.04);

    private double conversionFactorForInch;



    LengthUnit(double conversionFactorForInch) {
        this.conversionFactorForInch = conversionFactorForInch;
    }

    public double getConversionFactorForInch() {
        return conversionFactorForInch;
    }

    @Override
    public Unit standardUnit() {
        return LengthUnit.INCH;
    }

}
