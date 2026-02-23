package com.apps.quantitymeasurement;

public enum LengthUnit implements IMeasurable {

    FEET(1.0),
    INCH(1.0 / 12.0),
    YARD(3.0),
    CENTIMETER(0.0328084);

    private final double conversionFactor;

    LengthUnit(double factor) {
        this.conversionFactor = factor;
    }

    @Override
    public double getConversionFactor() {
        return conversionFactor;
    }
}