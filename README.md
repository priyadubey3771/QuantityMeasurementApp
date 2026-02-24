## UC11: Volume Measurement Support
### About :
This use case adds support for volume measurements to the application.

The system can now compare, convert, and add volume values just like length and weight.

This proves the generic design works when adding a new measurement category.

### Supported Units
- LITRE (base unit)
- MILLILITRE
- GALLON (US)
### Conversion Rules
- 1 litre = 1000 millilitres
- 1 gallon ≈ 3.78541 litres
### How It Works
#### Equality
Volume values are converted to litres before comparison.

Examples: 
1 L equals 1000 mL → true

  1 gal equals 3.78541 L → true

#### Conversion
Volume values can be converted between units.

Examples: 1 L → 1000 mL

1000 mL → 1 L

1 gal → 3.78541 L

1 L → 0.264 gal

#### Addition
Two volume values can be added together.

Default result → unit of first value

Optional → specify target unit

Examples:

1 L + 1000 mL → 2 L

500 mL + 0.5 L → 1000 mL

1 gal + 3.78541 L → ≈ 2 gal

### Important Note
- Volume, length, and weight are separate categories.
- Volume values cannot be compared or added with other categories.
### Concepts Used
- Generic Quantity design
- Base unit normalization
- Cross-unit conversion
- Arithmetic operations
- Type safety and category isolation
### Improvement Over UC10
UC10 introduced a generic architecture.

UC11 proves the architecture scales easily by adding a new category (Volume) without changing existing code.
