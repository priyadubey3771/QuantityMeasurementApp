package com.apps.quantitymeasurement;

public final class QuantityLength {

    private static final double EPSILON = 1e-6;

    private final double value;
    private final LengthUnit unit;

    public QuantityLength(double value, LengthUnit unit) 
    {
        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");

        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Value must be finite");

        this.value = value;
        this.unit = unit;
    }

    public double getValue() 
    {
        return value;
    }

    public LengthUnit getUnit() 
    {
        return unit;
    }

    /* ================= Conversion ================= */

    public QuantityLength convertTo(LengthUnit targetUnit) {
        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        double baseValue = unit.convertToBaseUnit(value);
        double convertedValue = targetUnit.convertFromBaseUnit(baseValue);

        return new QuantityLength(convertedValue, targetUnit);
    }

    /* ================= Addition ================= */

    // UC6 - implicit target (first operand unit)
    public QuantityLength add(QuantityLength other) {
        return add(other, this.unit);
    }

    // UC7 - explicit target unit
    public QuantityLength add(QuantityLength other, LengthUnit targetUnit) {
        if (other == null)
            throw new IllegalArgumentException("Second operand cannot be null");

        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        double sumBase =
                this.unit.convertToBaseUnit(this.value) +
                other.unit.convertToBaseUnit(other.value);

        double resultValue = targetUnit.convertFromBaseUnit(sumBase);

        return new QuantityLength(resultValue, targetUnit);
    }

    /* ================= Equality ================= */

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof QuantityLength)) return false;

        QuantityLength other = (QuantityLength) obj;

        double thisBase = unit.convertToBaseUnit(value);
        double otherBase = other.unit.convertToBaseUnit(other.value);

        return Math.abs(thisBase - otherBase) < EPSILON;
    }

    @Override
    public int hashCode() {
        long rounded = Math.round(unit.convertToBaseUnit(value) / EPSILON);
        return Long.hashCode(rounded);
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit + ")";
    }
}