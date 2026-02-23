package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    // IMeasurable Interface Tests

    @Test
    void testIMeasurable_LengthUnitImplementation() 
    {
        assertEquals(12.0, LengthUnit.FEET.getConversionFactor());
        assertEquals(1.0, LengthUnit.INCHES.getConversionFactor());
        assertEquals("FEET", LengthUnit.FEET.getUnitName());
    }

    @Test
    void testIMeasurable_WeightUnitImplementation() 
    {
        assertEquals(1000.0, WeightUnit.KILOGRAM.getConversionFactor());
        assertEquals(1.0, WeightUnit.GRAM.getConversionFactor());
        assertEquals("GRAM", WeightUnit.GRAM.getUnitName());
    }

    // Equality Tests

    @Test
    void testGenericQuantity_LengthEquality() 
    {
        Quantity<LengthUnit> q1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(12.0, LengthUnit.INCHES);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testGenericQuantity_WeightEquality() 
    {
        Quantity<WeightUnit> q1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> q2 = new Quantity<>(1000.0, WeightUnit.GRAM);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testCrossCategoryPrevention() 
    {
        Quantity<LengthUnit> length = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<WeightUnit> weight = new Quantity<>(1.0, WeightUnit.KILOGRAM);

        assertFalse(length.equals(weight));
    }

    // Conversion Tests

    @Test
    void testLengthConversion() 
    {
        Quantity<LengthUnit> q = new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> converted = q.convertTo(LengthUnit.INCHES);

        assertEquals(12.0, converted.getValue());
        assertEquals(LengthUnit.INCHES, converted.getUnit());
    }

    @Test
    void testWeightConversion() 
    {
        Quantity<WeightUnit> q = new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> converted = q.convertTo(WeightUnit.GRAM);

        assertEquals(1000.0, converted.getValue());
        assertEquals(WeightUnit.GRAM, converted.getUnit());
    }

    // Addition Tests

    @Test
    void testLengthAddition() 
    {
        Quantity<LengthUnit> q1 = new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> q2 =  new Quantity<>(12.0, LengthUnit.INCHES);

        Quantity<LengthUnit> result = q1.add(q2, LengthUnit.FEET);

        assertEquals(2.0, result.getValue());
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    @Test
    void testWeightAddition() 
    {
        Quantity<WeightUnit> q1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> q2 = new Quantity<>(1000.0, WeightUnit.GRAM);

        Quantity<WeightUnit> result = q1.add(q2, WeightUnit.KILOGRAM);

        assertEquals(2.0, result.getValue());
        assertEquals(WeightUnit.KILOGRAM, result.getUnit());
    }

    // Constructor Validation Tests

    @Test
    void testConstructor_NullUnit() 
    {
        assertThrows(IllegalArgumentException.class, () -> new Quantity<>(1.0, null));
    }

    @Test
    void testConstructor_InvalidValue() 
    {
        assertThrows(IllegalArgumentException.class, () -> new Quantity<>(Double.NaN, LengthUnit.FEET));
    }

    // HashCode & Equals Contract

    @Test
    void testHashCodeConsistency() {
        Quantity<LengthUnit> q1 = new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> q2 = new Quantity<>(12.0, LengthUnit.INCHES);

        assertEquals(q1, q2);
        assertEquals(q1.hashCode(), q2.hashCode());
    }
}