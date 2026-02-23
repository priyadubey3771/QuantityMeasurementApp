package com.apps.quantitymeasurement;

import java.util.Objects;

public final class Quantity<U extends IMeasurable> {

    private static final double EPSILON = 1e-6;

    private final double value;
    private final U unit;

    public Quantity(double value, U unit) {

        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");

        if (Double.isNaN(value) || Double.isInfinite(value))
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

    private double toBaseUnit() {
        return unit.convertToBaseUnit(value);
    }

    public Quantity<U> convertTo(U targetUnit) {

        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        double baseValue = toBaseUnit();
        double converted = targetUnit.convertFromBaseUnit(baseValue);

        return new Quantity<>(roundToTwoDecimals(converted), targetUnit);
    }

    public Quantity<U> add(Quantity<U> other) {
        return add(other, this.unit);
    }

    public Quantity<U> add(Quantity<U> other, U targetUnit) {

        if (other == null)
            throw new IllegalArgumentException("Other quantity cannot be null");

        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        if (this.unit.getClass() != other.unit.getClass())
            throw new IllegalArgumentException("Cannot add different measurement categories");

        double sumBase = this.toBaseUnit() + other.toBaseUnit();
        double result = targetUnit.convertFromBaseUnit(sumBase);

        return new Quantity<>(roundToTwoDecimals(result), targetUnit);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Quantity<?> other = (Quantity<?>) obj;

        if (this.unit.getClass() != other.unit.getClass())
            return false;

        return Math.abs(this.toBaseUnit() - other.toBaseUnit()) < EPSILON;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Math.round(toBaseUnit() / EPSILON));
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit.getUnitName() + ")";
    }

    private double roundToTwoDecimals(double val) {
        return Math.round(val * 100.0) / 100.0;
    }
}