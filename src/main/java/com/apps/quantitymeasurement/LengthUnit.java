package com.apps.quantitymeasurement;

public enum LengthUnit {

    FEET(1.0),
    INCHES(1.0 / 12.0),
    YARDS(3.0),
    CENTIMETERS(1.0 / 30.48);

    private final double conversionFactorToBase; // to FEET

    LengthUnit(double conversionFactorToBase) 
    {
        this.conversionFactorToBase = conversionFactorToBase;
    }

    
    public double getConversionFactor() 
    {
        return conversionFactorToBase;
    }

     double convertToBaseUnit(double value)
    {
        validate(value);
        return value * conversionFactorToBase;
    }

    public double convertFromBaseUnit(double baseValue) 
    {
        validate(baseValue);
        return baseValue / conversionFactorToBase;
    }

    private void validate(double value) {
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Value must be finite");
        }
    }
}