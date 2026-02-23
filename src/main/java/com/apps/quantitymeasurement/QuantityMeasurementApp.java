package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {
   public static void main(String[] args) {

        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);

        System.out.println(q1.convertTo(LengthUnit.INCHES));
        System.out.println(q1.add(q2, LengthUnit.FEET));
        System.out.println(new QuantityLength(36.0, LengthUnit.INCHES).equals(new QuantityLength(1.0, LengthUnit.YARDS)));

        System.out.println(new QuantityLength(1.0, LengthUnit.YARDS).add(new QuantityLength(3.0, LengthUnit.FEET), LengthUnit.YARDS));

        System.out.println(new QuantityLength(2.54, LengthUnit.CENTIMETERS).convertTo(LengthUnit.INCHES));
    }
}