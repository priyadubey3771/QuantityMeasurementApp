package com.apps.quantitymeasurement;

public enum LengthUnit {

 FEET(1.0),
 INCH(1.0 / 12.0),          // 1 inch = 1/12 feet
 YARDS(3.0),               // 1 yard = 3 feet
 CENTIMETERS(0.0328084);   // 1 cm = 0.0328084 feet (derived from 0.393701 inches)

 private final double conversionFactorToFeet;

 LengthUnit(double conversionFactorToFeet) {
     this.conversionFactorToFeet = conversionFactorToFeet;
 }

 public double toFeet(double value) {
     return value * conversionFactorToFeet;
 }
}