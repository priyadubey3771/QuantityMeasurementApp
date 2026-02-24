## UC14: Temperature Measurement Support
### About :
This use case adds temperature measurement to the application.

Temperature supports comparison and conversion, but arithmetic operations are not allowed because they are physically meaningless.

### Supported Units
- Celsius (base unit)
- Fahrenheit
- Kelvin
### Supported Features
#### Equality Comparison
Temperature values can be compared across units.

Examples:

0°C = 32°F

100°C = 212°F

0°C = 273.15K

-40°C = -40°F

#### Unit Conversion

Temperature values can be converted between units.

Examples:

100°C → 212°F

32°F → 0°C

0°C → 273.15K

-40°C → -40°F

### Rules
- Temperature values can only be compared with temperature values.
- Conversion uses formula-based calculations.
- Arithmetic operations throw an exception.
- Cross-category comparisons are not allowed.
### Concepts Used
- Non-linear unit conversion formulas
- Category-specific operation restrictions
- Exception handling for unsupported operations
- Generic architecture extension
- Backward compatibility
  
### Improvement Over UC13
UC13 improved arithmetic design.

UC14 adds a new measurement category (Temperature) with selective operation support.
