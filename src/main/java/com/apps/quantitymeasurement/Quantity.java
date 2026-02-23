package com.apps.quantitymeasurement;

public final class Quantity<U extends IMeasurable> {

    private final double value;
    private final U unit;
    private static final double EPSILON = 0.0001;

    public Quantity(double value, U unit) {

        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");

        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Invalid numeric value");

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public U getUnit() {
        return unit;
    }

    private void validateOperand(Quantity<U> other) {

        if (other == null)
            throw new IllegalArgumentException("Quantity cannot be null");

        if (!this.unit.getClass().equals(other.unit.getClass()))
            throw new IllegalArgumentException("Cross-category operation not allowed");

        if (!Double.isFinite(other.value))
            throw new IllegalArgumentException("Invalid numeric value");
    }

    private double toBase() {
        return unit.convertToBaseUnit(value);
    }

    private double round(double val) {
        return Math.round(val * 100.0) / 100.0;
    }

    // ---------------- ADD ----------------
    public Quantity<U> add(Quantity<U> other) {
        validateOperand(other);
        double baseResult = this.toBase() + other.toBase();
        double converted = unit.convertFromBaseUnit(baseResult);
        return new Quantity<>(round(converted), unit);
    }

    // ---------------- SUBTRACT ----------------
    public Quantity<U> subtract(Quantity<U> other) {
        validateOperand(other);
        double baseResult = this.toBase() - other.toBase();
        double converted = unit.convertFromBaseUnit(baseResult);
        return new Quantity<>(round(converted), unit);
    }

    // ---------------- DIVIDE ----------------
    public double divide(Quantity<U> other) {

        validateOperand(other);

        double divisor = other.toBase();

        if (Math.abs(divisor) < EPSILON)
            throw new ArithmeticException("Division by zero");

        return this.toBase() / divisor;
    }

    // ---------------- EQUALITY ----------------
    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (!(obj instanceof Quantity<?> other))
            return false;

        if (!this.unit.getClass().equals(other.unit.getClass()))
            return false;

        double thisBase = this.unit.convertToBaseUnit(this.value);
        double otherBase = other.unit.convertToBaseUnit(other.value);

        return Math.abs(thisBase - otherBase) < EPSILON;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(round(toBase()));
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }
}