package com.apps.quantitymeasurement;

public enum VolumeUnit implements IMeasurable {

    LITRE(1.0),
    MILLILITRE(0.001);

    private final double toLitreFactor;

    VolumeUnit(double toLitreFactor) {
        this.toLitreFactor = toLitreFactor;
    }

    @Override
    public double convertToBaseUnit(double value) {
        return value * toLitreFactor;
    }

    @Override
    public double convertFromBaseUnit(double baseValue) {
        return baseValue / toLitreFactor;
    }
}