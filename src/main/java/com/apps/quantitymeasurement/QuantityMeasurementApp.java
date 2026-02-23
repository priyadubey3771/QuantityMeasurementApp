package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {
 public static void main(String[] args) {

	        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
	        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCH);

	        System.out.println("Quantity(1.0, FEET) and Quantity(12.0, INCH): " + q1.equals(q2));

	        QuantityLength q3 = new QuantityLength(1.0, LengthUnit.INCH);
	        QuantityLength q4 = new QuantityLength(1.0, LengthUnit.INCH);

	        System.out.println("Quantity(1.0, INCH) and Quantity(1.0, INCH): "+ q3.equals(q4));
	    }
	}