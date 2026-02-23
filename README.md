## UC8: Refactoring LengthUnit to Standalone Enum
### About :
This use case improves the design by moving the LengthUnit enum into a separate standalone class.

The unit is now responsible for handling conversions, while the Quantity class focuses on comparison and arithmetic.

### UC8 improves:

- code structure
- maintainability
- scalability
### What Changed
- LengthUnit is now a separate enum.
- Conversion logic is handled by LengthUnit.
- Length class delegates conversion to the unit.
### How It Works
1. Each unit knows how to convert to the base unit.
2. Each unit knows how to convert from the base unit.
3. Quantity uses these methods for:
- equality
- conversion
- addition
### Examples
Input: 1 ft → inches
Output: 12 inches

Input: 1 ft + 12 in
Output: 2 ft

Input: 36 in equals 1 yd
Output: true

Input: LengthUnit.INCHES.convertToBaseUnit(12)
Output: 1 (foot)

### Concepts Used
- Separation of concerns
- Single Responsibility Principle
- Delegation
- Enum with behavior
- Scable architecture design
### Improvement Over UC7
- UC7 added addition with target unit.
- UC8 improves the internal design to support future measurement types easily.
