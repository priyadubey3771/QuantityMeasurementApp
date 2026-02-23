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

    /* ===================== UC5 Conversion ===================== */

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

    /* ===================== UC6 Addition ===================== */

    public QuantityLength add(QuantityLength other) {
        if (other == null)
            throw new IllegalArgumentException("Second operand cannot be null");

        double thisInFeet = toBaseUnit();
        double otherInFeet = other.toBaseUnit();

        double sumInFeet = thisInFeet + otherInFeet;

        double resultValue = sumInFeet / this.unit.getConversionFactor();
        return new QuantityLength(resultValue, this.unit);
    }

    // Static overloaded add method.
     
    public static QuantityLength add(QuantityLength first,QuantityLength second, LengthUnit targetUnit) {

        if (first == null || second == null)
            throw new IllegalArgumentException("Operands cannot be null");

        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        double firstInFeet = first.toBaseUnit();
        double secondInFeet = second.toBaseUnit();

        double sumInFeet = firstInFeet + secondInFeet;

        double resultValue = sumInFeet / targetUnit.getConversionFactor();
        return new QuantityLength(resultValue, targetUnit);
    }

    private static void validate(double value, LengthUnit unit) {
        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");

        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Value must be finite");
    }

    private double toBaseUnit() {
        return this.value * this.unit.getConversionFactor();
    }

    /* ===================== Object Overrides ===================== */

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