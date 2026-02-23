## UC6: Addition of Two Length Units
### About :
This use case allows addition of two length measurements.

The two values can be in different units, but they must belong to the same category (length).

The result is returned in the unit of the first operand.

### Supported Units
- FEET
- INCHES
- YARDS
- CENTIMETERS
### How It Works
1. Accept two length values with units.
2. Convert both values to a common base unit.
3. Add the values.
4. Convert the result back to the unit of the first value.
5. Return the result.
### Examples
Input: 1 ft + 2 ft
Output: 3 ft

Input: 1 ft + 12 in
Output: 2 ft

Input: 12 in + 1 ft
Output: 24 in

Input: 1 yd + 3 ft
Output: 2 yd

Input: 2.54 cm + 1 in
Output: ~5.08 cm

### Concepts Used
- Unit conversion
- Arithmetic operations
- Base unit normalization
- Floating point precision
### Improvement Over UC5
- UC5 supported unit conversion.
- UC6 adds the ability to add two measurements.
