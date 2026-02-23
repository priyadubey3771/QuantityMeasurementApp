package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    private static final double EPSILON = 1e-6;

    @Test
    void testAddition_SameUnit_FeetPlusFeet() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(2.0, LengthUnit.FEET);

        assertEquals(new QuantityLength(3.0, LengthUnit.FEET), q1.add(q2));
    }

    @Test
    void testAddition_CrossUnit_FeetPlusInches() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);

        QuantityLength result = q1.add(q2);
        assertEquals(2.0, result.getValue(), EPSILON);
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    @Test
    void testAddition_Commutativity() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);

        QuantityLength r1 = QuantityLength.add(q1, q2, LengthUnit.FEET);
        QuantityLength r2 = QuantityLength.add(q2, q1, LengthUnit.FEET);

        assertEquals(r1, r2);
    }

    @Test
    void testAddition_WithZero() {
        QuantityLength q1 = new QuantityLength(5.0, LengthUnit.FEET);
        QuantityLength zero = new QuantityLength(0.0, LengthUnit.INCHES);

        assertEquals(q1, q1.add(zero));
    }

    @Test
    void testAddition_NullSecondOperand() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);

        assertThrows(IllegalArgumentException.class, () -> q1.add(null));
    }

    @Test
    void testAddition_LargeValues() {
        QuantityLength q1 = new QuantityLength(1e6, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(1e6, LengthUnit.FEET);

        QuantityLength result = q1.add(q2);
        assertEquals(2e6, result.getValue(), EPSILON);
    }
}