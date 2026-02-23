## UC5: Unit-to-Unit Conversion (Same Measurement Type)
### About :
This use case extends UC4 by adding explicit unit conversion functionality.

The application can now convert a measurement from one unit to another instead of only checking equality.

### Objective
To convert length values between supported units:

- feet
- inches
- yards
- centimeters
### How It Works
1. The convert() method accepts:
- numeric value
- source unit
- target unit
2. The value is validated (must be finite and units must be valid).
3. The value is converted to a common base unit.
4. The base value is converted to the target unit.
5. The converted numeric value is returned.
### Supported Units
- Feet
- Inches
- Yards
- Centimeters
### Conversion Formula
result = value × (sourceUnit.factor / targetUnit.factor)

### Examples
1 ft → inches → 12
3 yards → feet → 9
2.54 cm → inches → ~1

### Concepts
- Base unit normalization
- Mathematical conversion logic
- Input validation
- Floating-point accuracy
### Learning Outcomes
- Object-oriented design
- Code refactoring & maintainability
- Unit testing
- DRY principle
- Enum usage
- Mathematical conversion logic
- Scalable system design
