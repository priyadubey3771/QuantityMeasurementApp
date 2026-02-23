package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    // ---------- FEET TEST CASES ----------

    @Test
    public void testFeetEquality_SameValue() {
        Feet f1 = new Feet(1.0);
        Feet f2 = new Feet(1.0);
        assertTrue(f1.equals(f2));
    }

    @Test
    public void testFeetEquality_DifferentValue() {
        Feet f1 = new Feet(1.0);
        Feet f2 = new Feet(2.0);
        assertFalse(f1.equals(f2));
    }

    @Test
    public void testFeetEquality_NullComparison() {
        Feet f1 = new Feet(1.0);
        assertFalse(f1.equals(null));
    }

    @Test
    public void testFeetEquality_SameReference() {
        Feet f1 = new Feet(1.0);
        assertTrue(f1.equals(f1));
    }

    @Test
    public void testFeetEquality_NonNumericInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Feet(-1.0);
        });
    }


    // ---------- INCHES TEST CASES ----------

    @Test
    public void testInchesEquality_SameValue() {
        Inches i1 = new Inches(1.0);
        Inches i2 = new Inches(1.0);
        assertTrue(i1.equals(i2));
    }

    @Test
    public void testInchesEquality_DifferentValue() {
        Inches i1 = new Inches(1.0);
        Inches i2 = new Inches(2.0);
        assertFalse(i1.equals(i2));
    }

    @Test
    public void testInchesEquality_NullComparison() {
        Inches i1 = new Inches(1.0);
        assertFalse(i1.equals(null));
    }

    @Test
    public void testInchesEquality_SameReference() {
        Inches i1 = new Inches(1.0);
        assertTrue(i1.equals(i1));
    }

    @Test
    public void testInchesEquality_NonNumericInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Inches(-5.0);
        });
    }
}