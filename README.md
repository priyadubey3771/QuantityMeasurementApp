## UC3: Generic Quantity Class (DRY Principle)
### About :
This use case refactors the separate Feet and Inches classes into a single generic Length class.

It removes code duplication and allows comparison between different units by converting them into a common base unit.

### Objective
To compare measurements across different units while following the DRY (Don't Repeat Yourself) principle.

### How It Works
1. A Length object stores a value and its unit.
2. Supported units are defined using a LengthUnit enum.
3. Values are converted to a common base unit (feet).
4. The overridden equals() method compares the converted values.
5. The result is returned as true or false.
### Example
Input: Quantity(1.0, FEET) and Quantity(12.0, INCH)

Output: Equal (true)

### Implementation Highlights
- Single Length class handles all units.
- LengthUnit enum stores conversion factors.
- Converts values to a base unit before comparison.
- Eliminates duplicate code from UC1 and UC2.
- Uses Double.compare() for accurate comparison.
- Includes null and type safety checks.
### Sample Test Cases
- 1 ft == 1 ft → equal
- 1 inch == 1 inch → equal
- 1 ft == 12 inch → equal
- 1 ft != 2 ft → not equal
- Invalid unit → rejected
- Comparison with null → false
### Concepts Learned
- DRY principle (removing duplicate code)
- Enum usage for unit management
- Abstraction and encapsulation
- Cross-unit conversion
- Value-based equality
- Sca lable and maintainable design
### Improvement Over UC1 & UC2
- Removes duplicate Feet & Inches classes
- Supports cross-unit comparison
- Easier to add new units
- Cleaner and more maintainable code
