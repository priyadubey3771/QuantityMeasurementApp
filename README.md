## UC4: Extended Unit Support
### About :
This use case extends UC3 by adding Yards and Centimeters as supported length units.

The generic design allows new units to be added easily without modifying the main class logic.

### Objective
To support additional units and enable equality comparison across:

- feet
- inches
- yards
- centimeters
### How It Works
1. New units are added to the LengthUnit enum.
2. Each unit includes a conversion factor to a common base unit.
3. Values are converted before comparison.
4. The equals() method compares the normalized values.
5. The result is returned as true or false.
### Supported Conversions
- 1 yard = 3 feet = 36 inches
- 1 cm = 0.393701 inches
### Example
Input: Quantity(1.0, YARDS) and Quantity(3.0, FEET)

Output: Equal (true)

Input: Quantity(1.0, CENTIMETERS) and Quantity(0.393701, INCHES)

Output: Equal (true)

### Implementation Highlights
- Added YARDS and CENTIMETERS to the enum.
- No changes required in the main class logic.
- Conversion factors are centrally managed.
- Cross-unit comparison works automatically.
- Maintains DRY principle and scalability.
### Sample Test Cases
- 1 yard == 3 feet → equal
- 1 yard == 36 inches → equal
- 1 cm == 0.393701 inch → equal
- 2 yards == 2 yards → equal
- Different values → not equal
- Invalid unit → rejected
### Concepts Learned
- Scalability of generic design
- Enum extensibility
- Unit conversion relationships
- Mathematical accuracy in conversions
- DRY principle validation
- Backward compatibility
### Improvement Over UC3
- Supports additional measurement units
- Demonstrates extensibility of enum-based design
- No code duplication required
- Existing functionality remains unchanged
