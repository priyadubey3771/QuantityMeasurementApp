package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        QuantityWeight kg = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight gram = new QuantityWeight(1000.0, WeightUnit.GRAM);
        QuantityWeight pound = new QuantityWeight(2.20462, WeightUnit.POUND);

        // Equality
        System.out.println("1 kg equals 1000 g: " + kg.equals(gram));
        System.out.println("1 kg equals 2.20462 lb: " + kg.equals(pound));

        // Conversion
        System.out.println("1 kg to gram: " + kg.convertTo(WeightUnit.GRAM));
        System.out.println("2 lb to kg: " +
                new QuantityWeight(2.0, WeightUnit.POUND).convertTo(WeightUnit.KILOGRAM));

        // Addition (implicit target unit)
        System.out.println("1 kg + 1000 g: " + kg.add(gram));

        // Addition (explicit target unit)
        System.out.println("1 kg + 1000 g in gram: " +
                kg.add(gram, WeightUnit.GRAM));
    }
}