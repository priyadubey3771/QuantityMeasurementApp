## UC10: Generic Quantity Class Using IMeasurable
### About :
UC10 refactors the application design by introducing a single generic class:

Quantity

This replaces separate classes like QuantityLength and QuantityWeight.

The new design removes code duplication and allows the system to support any measurement category using a common interface.

### Key Improvements
- Introduces a generic Quantity class
- Uses a common IMeasurable interface for all unit types
- Removes duplicate QuantityLength and QuantityWeight classes
- Simplifies application structure
- Makes the system scalable for new measurement categories
### How It Works
#### Generic Quantity Class
The Quantity class now works with any unit type that implements IMeasurable.

Examples:

- LengthUnit
- WeightUnit
- (Future) VolumeUnit
- (Future) TemperatureUnit
### IMeasurable Interface
All unit enums implement IMeasurable.

Responsibilities:

- Convert value to base unit
- Convert value from base unit
This allows Quantity to work with any measurement category.

### Supported Features
All functionality from UC1–UC9 continues to work:

✔ Equality comparison
✔ Unit conversion
✔ Addition of quantities
✔ Cross-unit arithmetic
✔ Base unit normalization

### Example Usage
Equality: 1 foot == 12 inches → true

Conversion: 1 yard → 3 feet

Addition: 1 foot + 12 inches = 2 feet

Weight: 1000 grams = 1 kilogram

### Architecture Benefits
#### No Code Duplication
One Quantity class replaces multiple category-specific classes.

#### Scalable Design
New measurement categories can be added without modifying existing code.

#### Single Responsibility Principle
Units handle conversion logic.
Quantity handles comparison and arithmetic.
#### Open–Closed Principle
System is open for extension but closed for modification.

### Rules
- Operations are allowed only within the same measurement category.
- Units must implement IMeasurable.
- Cross-category comparisons are not allowed.
### Concepts Used
- Generics in Java
- Interface-based design
- Code reuse and abstraction
- Open–Closed Principle
- Single Responsibility Principle
### Improvement Over UC9
- UC9 introduced multiple quantity classes for different categories.
- UC10 replaces them with a single generic design, improving scalability and maintainability.
