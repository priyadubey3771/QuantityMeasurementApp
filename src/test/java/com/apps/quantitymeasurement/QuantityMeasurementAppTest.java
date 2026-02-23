package com.apps.quantitymeasurement;

//QuantityLengthUC4Test.java

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

 @Test
 public void testEquality_YardToYard_SameValue() {
     assertTrue(new QuantityLength(1.0, LengthUnit.YARDS)
             .equals(new QuantityLength(1.0, LengthUnit.YARDS)));
 }

 @Test
 public void testEquality_YardToFeet_EquivalentValue() {
     assertTrue(new QuantityLength(1.0, LengthUnit.YARDS)
             .equals(new QuantityLength(3.0, LengthUnit.FEET)));
 }

 @Test
 public void testEquality_YardToInches_EquivalentValue() {
     assertTrue(new QuantityLength(1.0, LengthUnit.YARDS)
             .equals(new QuantityLength(36.0, LengthUnit.INCH)));
 }

 @Test
 public void testEquality_CentimeterToInch_EquivalentValue() {
     assertTrue(new QuantityLength(1.0, LengthUnit.CENTIMETERS)
             .equals(new QuantityLength(0.393701, LengthUnit.INCH)));
 }

 @Test
 public void testEquality_MultiUnit_TransitiveProperty() {

     QuantityLength yard = new QuantityLength(1.0, LengthUnit.YARDS);
     QuantityLength feet = new QuantityLength(3.0, LengthUnit.FEET);
     QuantityLength inch = new QuantityLength(36.0, LengthUnit.INCH);

     assertTrue(yard.equals(feet));
     assertTrue(feet.equals(inch));
     assertTrue(yard.equals(inch));
 }

 @Test
 public void testEquality_YardDifferentValue() {
     assertFalse(new QuantityLength(1.0, LengthUnit.YARDS)
             .equals(new QuantityLength(2.0, LengthUnit.YARDS)));
 }

 @Test
 public void testEquality_CentimeterDifferentValue() {
     assertFalse(new QuantityLength(1.0, LengthUnit.CENTIMETERS)
             .equals(new QuantityLength(1.0, LengthUnit.FEET)));
 }

 @Test
 public void testEquality_SameReference() {
     QuantityLength q = new QuantityLength(2.0, LengthUnit.YARDS);
     assertTrue(q.equals(q));
 }

 @Test
 public void testEquality_NullComparison() {
     QuantityLength q = new QuantityLength(2.0, LengthUnit.YARDS);
     assertFalse(q.equals(null));
 }

 @Test
 public void testConstructor_NullUnit() {
     assertThrows(IllegalArgumentException.class, () -> {
         new QuantityLength(1.0, null);
     });
 }
}