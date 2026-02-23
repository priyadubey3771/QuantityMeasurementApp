package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        Quantity<LengthUnit> length1 =
                new Quantity<>(10, LengthUnit.FEET);

        Quantity<LengthUnit> length2 =
                new Quantity<>(6, LengthUnit.INCHES);

        System.out.println("Add: " + length1.add(length2));
        System.out.println("Subtract: " + length1.subtract(length2));
        System.out.println("Divide: " +
                length1.divide(new Quantity<>(2, LengthUnit.FEET)));

        Quantity<VolumeUnit> volume1 =
                new Quantity<>(1, VolumeUnit.GALLON);

        Quantity<VolumeUnit> volume2 =
                new Quantity<>(3.78541, VolumeUnit.LITRE);

        System.out.println("Volume Equality: " +
                volume1.equals(volume2));
    }
}