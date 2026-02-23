## UC9: Weight Measurement Support
### Overview
This use case adds support for weight measurements to the application.

The system can now compare, convert, and add weight values just like length measurements.

### Supported Units
- KILOGRAM (base unit)
- GRAM
- POUND
### Conversion Rules
- 1 kilogram = 1000 grams
- 1 pound ≈ 0.453592 kilograms
### Equality
Weight values are converted to kilograms before comparison.

Example: 1 kg equals 1000 g → true

### Conversion
Weight values can be converted between units.

Example: 1 kg → grams = 1000 g
2 lb → kg ≈ 0.91 kg

### Addition
Two weights can be added together.

Default result → unit of first value
Optional → specify target unit

Examples:

1 kg + 1000 g → 2 kg
500 g + 0.5 kg → 1000 g
1 lb + 453.592 g → ≈ 2 lb

### Important Note
- Weight and length are separate categories.
- 1 kg is NOT equal to 1 foot.
### Concepts Used
- Multiple measurement categories
- Base unit conversion
- Enum-based design
- Arithmetic operations
- Type safety
### Improvement Over UC8
- UC8 improved design for length units.
- UC9 proves the design works for new categories like weight.# QuantityMeasurementApp
