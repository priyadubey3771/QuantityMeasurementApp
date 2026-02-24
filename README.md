## UC12: Subtraction and Division Operations
### About :
This use case adds subtraction and division operations to quantity measurements.

The system can now compute differences and ratios between measurements while keeping the generic design intact.

### Supported Categories
- Length
- Weight
- Volume
### How It Works
#### Subtraction
Subtracts one quantity from another within the same category.

✔ Units may differ

✔ Result defaults to the unit of the first value

✔ Target unit can be specified

Examples:

5 ft − 12 in → 4 ft

2 L − 500 mL → 1.5 L

10 kg − 250 g → 9.75 kg

#### Division
Divides one quantity by another to produce a dimensionless ratio.

✔ Units may differ

✔ Both values must belong to the same category

Examples:

10 ft ÷ 5 ft → 2

1000 mL ÷ 1 L → 1

2 kg ÷ 500 g → 4

### Rules
- Both quantities must belong to the same category.
- Different units are automatically converted.
- Division by zero throws an error.
- Original objects remain unchanged.
### Concepts Used
- Generic arithmetic operations
- Base unit normalization
- Unit conversion reuse
- Dimensionless ratios
- Error handling and validation
### Improvement Over UC11
UC11 supported equality, conversion, and addition.

UC12 completes arithmetic support by adding subtraction and division.
