package com.apps.quantitymeasurement;

public enum WeightUnit implements IMeasurable {

    KILOGRAM(1.0),
    GRAM(0.001),
    TONNE(1000.0);

    private final double toBaseFactor;

    WeightUnit(double toBaseFactor) {
        this.toBaseFactor = toBaseFactor;
    }

    @Override
    public double convertToBaseUnit(double value) {
        return value * toBaseFactor;
    }

    @Override
    public double convertFromBaseUnit(double baseValue) {
        return baseValue / toBaseFactor;
    }
}