package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        Quantity<LengthUnit> q1 =
                new Quantity<>(10.0, LengthUnit.FEET);

        Quantity<LengthUnit> q2 =
                new Quantity<>(6.0, LengthUnit.INCHES);

        System.out.println("Addition: " + q1.add(q2).getValue() + " " + q1.add(q2).getUnit());
        System.out.println("Subtraction: " + q1.subtract(q2).getValue() + " " + q1.subtract(q2).getUnit());
        System.out.println("Division: " + q1.divide(new Quantity<>(2.0, LengthUnit.FEET)));
    }
}