## UC1: Feet Measurement Equality
### About :
This use case compares two measurements expressed in feet and checks whether they are equal.


### Objective
To determine if two numeric values in feet represent the same measurement.


### How It Works
1. Two values in feet are provided.
2. A Feet object is created for each value.
3. The overridden equals() method compares the values.
4. The result is returned as true or false.

### Example
Input: 1.0 ft and 1.0 ft

Output: Equal (true)

### Implementation Highlights
- Uses a Feet class to represent measurement.
- Stores value as private final double (immutable).
- Overrides equals() for value-based comparison.
- Uses Double.compare() for accurate floating-point comparison.
- Includes null and type safety checks.

### Sample Test Cases
- Same values → equal
- Different values → not equal
- Comparison with null → false
- Same reference → true

### Concepts Learned
- Object equality
- Floating-point comparison
- Encapsulation & immutability
- Null & type safety# QuantityMeasurementApp
