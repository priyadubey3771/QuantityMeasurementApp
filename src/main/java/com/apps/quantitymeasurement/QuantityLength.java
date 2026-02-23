package com.apps.quantitymeasurement;

public final class QuantityLength {

    private static final double EPSILON = 1e-6;

    private final double value;
    private final LengthUnit unit;

    public QuantityLength(double value, LengthUnit unit) {
        validate(value, unit);
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
    }

    /* ================= Conversion ================= */

    public static double convert(double value, LengthUnit source, LengthUnit target) {
        validate(value, source);

        if (target == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        if (source == target)
            return value;

        double valueInFeet = value * source.getConversionFactor();
        return valueInFeet / target.getConversionFactor();
    }

    public QuantityLength convertTo(LengthUnit targetUnit) {
        double convertedValue = convert(this.value, this.unit, targetUnit);
        return new QuantityLength(convertedValue, targetUnit);
    }

    /* ================= UC6 Addition (implicit target = first unit) ================= */

    public QuantityLength add(QuantityLength other) {
        return add(this, other, this.unit);
    }

    /* ================= UC7 Addition (explicit target unit) ================= */

    public static QuantityLength add(QuantityLength first,QuantityLength second,LengthUnit targetUnit) {

        if (first == null || second == null)
            throw new IllegalArgumentException("Operands cannot be null");

        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        double sumInFeet = sumInBaseUnit(first, second);

        double resultValue = sumInFeet / targetUnit.getConversionFactor();

        return new QuantityLength(resultValue, targetUnit);
    }

    /* ================= Private Utility ================= */

    private static double sumInBaseUnit(QuantityLength a, QuantityLength b) {
        return a.toBaseUnit() + b.toBaseUnit();
    }

    private double toBaseUnit() {
        return this.value * this.unit.getConversionFactor();
    }

    private static void validate(double value, LengthUnit unit) {
        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");

        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Value must be finite");
    }

    /* ================= Object Overrides ================= */

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof QuantityLength)) return false;

        QuantityLength other = (QuantityLength) obj;

        return Math.abs(this.toBaseUnit() - other.toBaseUnit()) < EPSILON;
    }

    @Override
    public int hashCode() {
        long rounded = Math.round(this.toBaseUnit() / EPSILON);
        return Long.hashCode(rounded);
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit + ")";
    }
}