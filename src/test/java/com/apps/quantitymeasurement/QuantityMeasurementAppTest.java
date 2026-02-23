package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

	    private static final double EPSILON = 1e-6;

	    @Test
	    void testAddition_ExplicitTargetUnit_Feet() {
	        QuantityLength result = QuantityLength.add(new QuantityLength(1.0, LengthUnit.FEET),new QuantityLength(12.0, LengthUnit.INCHES),LengthUnit.FEET);

	        assertEquals(2.0, result.getValue(), EPSILON);
	        assertEquals(LengthUnit.FEET, result.getUnit());
	    }

	    @Test
	    void testAddition_ExplicitTargetUnit_Inches() {
	        QuantityLength result = QuantityLength.add(new QuantityLength(1.0, LengthUnit.FEET), new QuantityLength(12.0, LengthUnit.INCHES),LengthUnit.INCHES);
	        assertEquals(24.0, result.getValue(), EPSILON);
	    }

	    @Test
	    void testAddition_ExplicitTargetUnit_Yards() {
	        QuantityLength result = QuantityLength.add(new QuantityLength(1.0, LengthUnit.FEET),new QuantityLength(12.0, LengthUnit.INCHES),LengthUnit.YARDS);
	        assertEquals(0.666666, result.getValue(), 1e-3);
	    }

	    @Test
	    void testAddition_Commutativity_WithTarget() {
	        QuantityLength a = new QuantityLength(1.0, LengthUnit.FEET);
	        QuantityLength b = new QuantityLength(12.0, LengthUnit.INCHES);

	        QuantityLength r1 = QuantityLength.add(a, b, LengthUnit.YARDS);
	        QuantityLength r2 = QuantityLength.add(b, a, LengthUnit.YARDS);

	        assertEquals(r1, r2);
	    }

	    @Test
	    void testAddition_NullTargetUnit() {
	        assertThrows(IllegalArgumentException.class, () ->
	                QuantityLength.add(new QuantityLength(1.0, LengthUnit.FEET),new QuantityLength(12.0, LengthUnit.INCHES),null));
	    }

	    @Test
	    void testAddition_NegativeValues() {
	        QuantityLength result = QuantityLength.add(new QuantityLength(5.0, LengthUnit.FEET), new QuantityLength(-2.0, LengthUnit.FEET),
	                LengthUnit.INCHES);

	        assertEquals(36.0, result.getValue(), EPSILON);
	    }
	}