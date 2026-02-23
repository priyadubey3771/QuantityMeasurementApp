package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    // ---------------- SUBTRACTION ----------------

    @Test
    void testSubtraction_ImplicitTarget() {

        Quantity<LengthUnit> length1 =
                new Quantity<>(10.0, LengthUnit.FEET);

        Quantity<LengthUnit> length2 =
                new Quantity<>(6.0, LengthUnit.INCHES);

        Quantity<LengthUnit> result = length1.subtract(length2);

        assertEquals(9.5, result.getValue(), 0.01);
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    @Test
    void testSubtraction_ExplicitTarget() {

        Quantity<LengthUnit> length1 =
                new Quantity<>(1.0, LengthUnit.YARD);

        Quantity<LengthUnit> length2 =
                new Quantity<>(6.0, LengthUnit.INCHES);

        Quantity<LengthUnit> result =
                length1.subtract(length2);

        // Correct expected value
        assertEquals(0.83, result.getValue(), 0.01);
        assertEquals(LengthUnit.YARD, result.getUnit());
    }

    @Test
    void testSubtraction_NonCommutative() {

        Quantity<LengthUnit> a =
                new Quantity<>(10.0, LengthUnit.FEET);

        Quantity<LengthUnit> b =
                new Quantity<>(2.0, LengthUnit.FEET);

        assertNotEquals(a.subtract(b), b.subtract(a));
    }

    @Test
    void testSubtraction_CrossCategory() {

        Quantity<LengthUnit> length =
                new Quantity<>(10.0, LengthUnit.FEET);

        Quantity<VolumeUnit> volume =
                new Quantity<>(2.0, VolumeUnit.LITRE);

        assertThrows(IllegalArgumentException.class,
                () -> length.subtract((Quantity) volume));
    }

    // ---------------- DIVISION ----------------

    @Test
    void testDivision_SameUnit() {

        Quantity<LengthUnit> a =
                new Quantity<>(10.0, LengthUnit.FEET);

        Quantity<LengthUnit> b =
                new Quantity<>(2.0, LengthUnit.FEET);

        double result = a.divide(b);

        assertEquals(5.0, result, 0.0001);
    }

    @Test
    void testDivision_DifferentUnits() {

        Quantity<LengthUnit> a =
                new Quantity<>(12.0, LengthUnit.INCHES);

        Quantity<LengthUnit> b =
                new Quantity<>(1.0, LengthUnit.FEET);

        double result = a.divide(b);

        assertEquals(1.0, result, 0.0001);
    }

    @Test
    void testDivision_NonCommutative() {

        Quantity<LengthUnit> a =
                new Quantity<>(10.0, LengthUnit.FEET);

        Quantity<LengthUnit> b =
                new Quantity<>(2.0, LengthUnit.FEET);

        assertNotEquals(a.divide(b), b.divide(a));
    }

    @Test
    void testDivision_ByZero() {

        Quantity<LengthUnit> a =
                new Quantity<>(10.0, LengthUnit.FEET);

        Quantity<LengthUnit> b =
                new Quantity<>(0.0, LengthUnit.FEET);

        assertThrows(ArithmeticException.class,
                () -> a.divide(b));
    }

    @Test
    void testDivision_CrossCategory() {

        Quantity<LengthUnit> length =
                new Quantity<>(10.0, LengthUnit.FEET);

        Quantity<WeightUnit> weight =
                new Quantity<>(2.0, WeightUnit.KILOGRAM);

        assertThrows(IllegalArgumentException.class,
                () -> length.divide((Quantity) weight));
    }

    // ---------------- IMMUTABILITY ----------------

    @Test
    void testImmutability_Subtraction() {

        Quantity<LengthUnit> original =
                new Quantity<>(10.0, LengthUnit.FEET);

        Quantity<LengthUnit> other =
                new Quantity<>(2.0, LengthUnit.FEET);

        Quantity<LengthUnit> result =
                original.subtract(other);

        assertNotSame(original, result);
        assertEquals(10.0, original.getValue(), 0.01);
    }

    // ---------------- ROUNDING ----------------

    @Test
    void testRoundingBehavior() {

        Quantity<LengthUnit> a =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> b =
                new Quantity<>(1.0, LengthUnit.INCHES);

        Quantity<LengthUnit> result = a.subtract(b);

        assertEquals(0.92, result.getValue(), 0.01);
    }
}