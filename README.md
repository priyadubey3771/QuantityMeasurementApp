## UC13: Centralized Arithmetic Logic (DRY Principle)
### About :
This use case improves the internal design of arithmetic operations by removing duplicate code and centralizing shared logic.

Operations like add, subtract, and divide now use common helper methods, making the system easier to maintain and extend.

- No new features were added.
- Public behavior remains unchanged.
### What Changed
- Added a centralized validation helper.
- Added a core arithmetic helper for calculations.
- Introduced an enum-based operation dispatcher.
- Refactored add, subtract, and divide to use shared logic.
### What Did NOT Change
- No change in public APIs.
- No change in arithmetic results.
- No change to unit enums or interfaces.
- Existing UC12 test cases work without modification.
### Why This Was Needed
Earlier implementations repeated the same logic:

- null checks
- unit compatibility checks
- numeric validation
- base unit conversions
- target unit handling
  
This violated the DRY principle and made the code harder to maintain.

UC13 removes duplication by creating a single source of truth.

### How It Works
#### Centralized Validation
A private helper validates:

- operands are not null
- units are valid and compatible
- numeric values are finite
  
All arithmetic methods use this helper.

#### Core Arithmetic Helper
A private method:

1. Converts values to base units
2. Performs the arithmetic operation
3. Returns the result in base units
   
Public methods convert the result to the requested unit.

#### Enum-Based Operation Dispatcher
An internal enum defines operations:

- ADD
- SUBTRACT
- DIVIDE
  
This avoids if/else chains and makes future operations easy to add.

### Benefits

✔ Eliminates duplicate code

✔ Ensures consistent validation and errors

✔ Improves readability and maintainability

✔ Makes future operations easier to implement

✔ Keeps behavior unchanged

### Improvement Over UC12
UC12 introduced subtraction and division.

UC13 improves the design by centralizing arithmetic logic and enforcing DRY.
