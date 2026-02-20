package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    @Test
    void testEquality_SameValue() {
        // given
        Feet feet1 = new Feet(1.0);
        Feet feet2 = new Feet(1.0);

        // when
        boolean result = feet1.equals(feet2);

        // then
        assertTrue(result, "Expected 1.0 ft to be equal to 1.0 ft");
    }

    @Test
    void testEquality_DifferentValue() {
        // given
        Feet feet1 = new Feet(1.0);
        Feet feet2 = new Feet(2.0);

        // when
        boolean result = feet1.equals(feet2);

        // then
        assertFalse(result, "Expected 1.0 ft to not be equal to 2.0 ft");
    }

    @Test
    void testEquality_NullComparison() {
        // given
        Feet feet1 = new Feet(1.0);

        // when
        boolean result = feet1.equals(null);

        // then
        assertFalse(result, "Expected comparison with null to return false");
    }

    @Test
    void testEquality_SameReference() {
        // given
        Feet feet1 = new Feet(1.0);

        // when
        boolean result = feet1.equals(feet1);

        // then
        assertTrue(result, "Expected object to be equal to itself");
    }

    @Test
    void testEquality_DifferentType() {
        // given
        Feet feet1 = new Feet(1.0);

        // when
        boolean result = feet1.equals("1.0");

        // then
        assertFalse(result, "Expected comparison with different type to return false");
    }
}