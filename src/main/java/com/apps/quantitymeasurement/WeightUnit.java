package com.apps.quantitymeasurement;

public enum WeightUnit implements IMeasurable {

    KILOGRAM(1.0),
    GRAM(0.001),
    POUND(0.453592);

    private final double toKgFactor;

    WeightUnit(double toKgFactor) {
        this.toKgFactor = toKgFactor;
    }

    @Override
    public double convertToBaseUnit(double value) {
        return value * toKgFactor;
    }

    @Override
    public double convertFromBaseUnit(double baseValue) {
        return baseValue / toKgFactor;
    }
}