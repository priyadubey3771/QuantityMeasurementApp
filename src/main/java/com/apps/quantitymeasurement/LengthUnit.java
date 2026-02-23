package com.apps.quantitymeasurement;

public enum LengthUnit implements IMeasurable {

    FEET(1.0),
    INCHES(1.0 / 12.0),
    YARD(3.0);

    private final double toFeetFactor;

    LengthUnit(double toFeetFactor) {
        this.toFeetFactor = toFeetFactor;
    }

    @Override
    public double convertToBaseUnit(double value) {
        return value * toFeetFactor;
    }

    @Override
    public double convertFromBaseUnit(double baseValue) {
        return baseValue / toFeetFactor;
    }
}