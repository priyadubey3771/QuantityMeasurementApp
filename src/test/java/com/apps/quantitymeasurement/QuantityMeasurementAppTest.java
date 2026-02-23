package com.apps.quantitymeasurement;

//QuantityLengthTest.java

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

 // Same Unit – Same Value

 @Test
 public void testEquality_FeetToFeet_SameValue() {
     QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
     QuantityLength q2 = new QuantityLength(1.0, LengthUnit.FEET);
     assertTrue(q1.equals(q2));
 }

 @Test
 public void testEquality_InchToInch_SameValue() {
     QuantityLength q1 = new QuantityLength(1.0, LengthUnit.INCH);
     QuantityLength q2 = new QuantityLength(1.0, LengthUnit.INCH);
     assertTrue(q1.equals(q2));
 }

 // Cross Unit – Equivalent Value

 @Test
 public void testEquality_FeetToInch_EquivalentValue() {
     QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
     QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCH);
     assertTrue(q1.equals(q2));
 }

 @Test
 public void testEquality_InchToFeet_EquivalentValue() {
     QuantityLength q1 = new QuantityLength(12.0, LengthUnit.INCH);
     QuantityLength q2 = new QuantityLength(1.0, LengthUnit.FEET);
     assertTrue(q1.equals(q2));
 }

 // Same Unit – Different Value

 @Test
 public void testEquality_FeetToFeet_DifferentValue() {
     QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
     QuantityLength q2 = new QuantityLength(2.0, LengthUnit.FEET);
     assertFalse(q1.equals(q2));
 }

 @Test
 public void testEquality_InchToInch_DifferentValue() {
     QuantityLength q1 = new QuantityLength(1.0, LengthUnit.INCH);
     QuantityLength q2 = new QuantityLength(2.0, LengthUnit.INCH);
     assertFalse(q1.equals(q2));
 }

 // Equality Contract Tests

 @Test
 public void testEquality_SameReference() {
     QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
     assertTrue(q1.equals(q1));  // Reflexive
 }

 @Test
 public void testEquality_SymmetricProperty() {
     QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
     QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCH);

     assertTrue(q1.equals(q2));
     assertTrue(q2.equals(q1));  // Symmetric
 }

 @Test
 public void testEquality_NullComparison() {
     QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
     assertFalse(q1.equals(null));
 }

 // Validation Tests

 @Test
 public void testConstructor_InvalidUnit() {
     assertThrows(IllegalArgumentException.class, () -> {
         new QuantityLength(1.0, null);
     });
 }

 @Test
 public void testConstructor_InvalidValue() {
     assertThrows(IllegalArgumentException.class, () -> {
         new QuantityLength(-1.0, LengthUnit.FEET);
     });
 }
}