package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);

        System.out.println(QuantityLength.add(q1, q2, LengthUnit.FEET));
        System.out.println(QuantityLength.add(q1, q2, LengthUnit.INCHES));
        System.out.println(QuantityLength.add(q1, q2, LengthUnit.YARDS));

        QuantityLength yard = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength feet = new QuantityLength(3.0, LengthUnit.FEET);

        System.out.println(QuantityLength.add(yard, feet, LengthUnit.YARDS));
        System.out.println(QuantityLength.add(new QuantityLength(36.0, LengthUnit.INCHES),
                new QuantityLength(1.0, LengthUnit.YARDS), LengthUnit.FEET));
    }
}