package com.apps.quantitymeasurement;

//QuantityLength.java
public class QuantityLength {

 private final double value;
 private final LengthUnit unit;
 private static final double TOLERANCE = 0.0001;

 public QuantityLength(double value, LengthUnit unit) {
     if (value < 0) {
         throw new IllegalArgumentException("Invalid length value");
     }
     if (unit == null) {
         throw new IllegalArgumentException("Unit cannot be null");
     }
     this.value = value;
     this.unit = unit;
 }

 public double toFeet() {
     return unit.toFeet(value);
 }

 @Override
 public boolean equals(Object obj) {

     if (this == obj)
         return true;

     if (obj == null || !(obj instanceof QuantityLength))
         return false;

     QuantityLength other = (QuantityLength) obj;

     return Math.abs(this.toFeet() - other.toFeet()) < TOLERANCE;
 }
}