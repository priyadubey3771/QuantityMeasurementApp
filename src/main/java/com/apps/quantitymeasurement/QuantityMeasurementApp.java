package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {
 public static void main(String[] args) {

        // Length Example
        Quantity<LengthUnit> length1 = new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> length2 = new Quantity<>(12.0, LengthUnit.INCH);

        System.out.println("Length Equal: " + length1.equals(length2));

        // Weight Example
        Quantity<WeightUnit> weight1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> weight2 = new Quantity<>(1000.0, WeightUnit.GRAM);

        System.out.println("Weight Equal: " + weight1.equals(weight2));

        // Volume Example
        Quantity<VolumeUnit> volume1 = new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> volume2 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        System.out.println("Volume Equal: " + volume1.equals(volume2));

        // Addition
        Quantity<VolumeUnit> sum = volume1.add(volume2);

        System.out.println("Sum: " + sum);
    }
}