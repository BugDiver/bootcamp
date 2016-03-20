package com.bootcamp.measurement;

public enum VolumeUnit implements Unit {
    LITRE (1),
    GALLON(3.78);

    private double conversionFactorForLitre;

    VolumeUnit(double conversionFactorForLitre) {
        this.conversionFactorForLitre = conversionFactorForLitre;
    }

    public double getConversionFactorForInch() {
        return this.conversionFactorForLitre;
    }

    @Override
    public Unit standardUnit() {
        return VolumeUnit.LITRE;
    }
}
