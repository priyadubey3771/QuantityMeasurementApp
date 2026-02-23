package com.apps.quantitymeasurement;

//QuantityLengthUC4Test.java

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

	    private static final double EPSILON = 1e-6;

	    @Test
	    void testConversion_FeetToInches() 
	    {
	        assertEquals(12.0,
	                QuantityLength.convert(1.0, LengthUnit.FEET, LengthUnit.INCHES), EPSILON);
	    }

	    @Test
	    void testConversion_InchesToFeet() 
	    {
	        assertEquals(2.0, QuantityLength.convert(24.0, LengthUnit.INCHES, LengthUnit.FEET),EPSILON);
	    }

	    @Test
	    void testConversion_YardsToInches()
	    {
	        assertEquals(36.0,QuantityLength.convert(1.0, LengthUnit.YARDS, LengthUnit.INCHES),EPSILON);
	    }

	    @Test
	    void testConversion_CentimetersToInches() {
	        assertEquals(1.0,QuantityLength.convert(2.54, LengthUnit.CENTIMETERS, LengthUnit.INCHES),1e-4);
	    }

	    @Test
	    void testConversion_RoundTrip_PreservesValue() 
	    {
	        double original = 5.0;
	        double converted = QuantityLength.convert(original,LengthUnit.FEET, LengthUnit.INCHES);
	        double back = QuantityLength.convert(converted,LengthUnit.INCHES, LengthUnit.FEET);
            assertEquals(original, back, EPSILON);
	    }

	    @Test
	    void testConversion_ZeroValue() 
	    {
	        assertEquals(0.0,QuantityLength.convert(0.0, LengthUnit.FEET, LengthUnit.INCHES),EPSILON);
	    }

	    @Test
	    void testConversion_NegativeValue() 
	    {
	        assertEquals(-12.0,QuantityLength.convert(-1.0, LengthUnit.FEET, LengthUnit.INCHES),EPSILON);
	    }

	    @Test
	    void testConversion_InvalidUnit_Throws() {
	        assertThrows(IllegalArgumentException.class,() -> QuantityLength.convert(1.0, null, LengthUnit.FEET));
	    }

	    @Test
	    void testConversion_NaNOrInfinite_Throws() 
	    {
	        assertThrows(IllegalArgumentException.class,() -> QuantityLength.convert(Double.NaN, LengthUnit.FEET, LengthUnit.INCHES));

	        assertThrows(IllegalArgumentException.class,() -> QuantityLength.convert(Double.POSITIVE_INFINITY,LengthUnit.FEET, LengthUnit.INCHES));
	    }
	}