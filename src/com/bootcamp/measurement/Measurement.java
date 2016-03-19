package com.bootcamp.measurement;

public class Measurement {
    private  double value;
    private  Unit unit;

    public Measurement(double value , Unit unit) {

        this.value = value;
        this.unit = unit;
    }

    private Measurement convertToDefault() {
        double value = this.value  * unit.getMultiplier();
        Unit unit = this.unit.standardOutput();
        return new Measurement(value ,unit);
    }

    public Measurement convert(Unit unit) {
        Measurement self = convertToDefault();
        double newValue = self.value / unit.getMultiplier();
        return  new Measurement(newValue,unit);
    }

    public  Measurement add (Measurement measurement){
        Measurement measurementToAdd = measurement.convert(unit);
        double sum = value + measurementToAdd.value;
        return new Measurement(sum ,unit.standardOutput());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Measurement that = (Measurement) o;
        Measurement measurementForCompare = that.convert(unit);
        return Double.compare(value, measurementForCompare.value) == 0 && unit == measurementForCompare.unit;
    }

    @Override
    public String toString() {
        return String.format("%s %s" ,value,unit);
    }


}
