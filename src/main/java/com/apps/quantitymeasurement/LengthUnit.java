package com.apps.quantitymeasurement;

public enum LengthUnit {

    FEET(1.0),
    INCHES(1.0 / 12.0),
    YARDS(3.0),
    CENTIMETERS(0.0328084); // 1 cm = 0.0328084 feet

    private final double conversionFactorToFeet;

    LengthUnit(double conversionFactorToFeet) 
    {
        this.conversionFactorToFeet = conversionFactorToFeet;
    }

    public double getConversionFactor() 
    {
        return conversionFactorToFeet;
    }
}