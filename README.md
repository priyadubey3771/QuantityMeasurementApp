## UC2: Feet and Inches Measurement Equality
### About :
This use case extends UC1 by adding equality comparison for measurements expressed in inches along with feet.

Both units are handled separately and compared within their own type.

### Objective
To verify equality of measurements in:

- feet
- inches
### How It Works
1. Two values in feet are compared using the Feet class.
2. Two values in inches are compared using the Inches class.
3. Each class overrides the equals() method.
4. The result is returned as true or false.
### Example
Input: 1.0 ft and 1.0 ft
1.0 inch and 1.0 inch

Output: Equal (true)
Equal (true)

### Implementation Highlights
- Separate Feet and Inches classes.
- Each class stores value as private final double.
- Overrides equals() for value-based comparison.
- Uses Double.compare() for accurate floating-point comparison.
- Includes null and type safety checks.
- Equality checks are handled through helper methods.
### Sample Test Cases
- Same feet values → equal
- Different feet values → not equal
- Same inches values → equal
- Different inches values → not equal
- Comparison with null → false
- Same reference → true
### Concepts Learned
- Object equality
- Floating-point comparison
- Encapsulation & immutability
- Null & type safety
- Code reuse through helper methods# QuantityMeasurementApp
