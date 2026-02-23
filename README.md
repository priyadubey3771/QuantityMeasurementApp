## UC7: Addition with Target Unit Specification
### About :
This use case allows adding two length measurements and returning the result in a specified target unit.

Unlike UC6, the result unit is not limited to the first operand.

### Supported Units
- FEET
- INCHES
- YARDS
- CENTIMETERS
### How It Works
1. Accept two length values with units.
2. Accept a target unit for the result.
3. Convert both values to a common base unit.
4. Add the values.
5. Convert the result to the specified target unit.
6. Return the result.
### Examples
Input: 1 ft + 12 in → target: FEET
Output: 2 ft

Input: 1 ft + 12 in → target: INCHES
Output: 24 in

Input: 1 ft + 12 in → target: YARDS
Output: ~0.667 yd

Input: 1 yd + 3 ft → target: YARDS
Output: 2 yd

Input: 36 in + 1 yd → target: FEET
Output: 6 ft

Input: 2.54 cm + 1 in → target: CENTIMETERS
Output: ~5.08 cm

### Concepts Used
- Unit conversion
- Arithmetic operations
- Target unit conversion
- Base unit normalization
- Floating point precision
### Improvement Over UC6
- UC6 returned the result in the first operand's unit.
- UC7 allows the result to be returned in any specified unit.
