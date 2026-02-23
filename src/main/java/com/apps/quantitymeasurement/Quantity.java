package com.apps.quantitymeasurement;

import java.util.Objects;

public class Quantity<U extends IMeasurable> {

    private final double value;
    private final U unit;
    private static final double EPSILON = 0.0001;

    public Quantity(double value, U unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
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
        return value * unit.getConversionFactor();
    }

    public Quantity<U> convertTo(U targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        double baseValue = toBaseUnit();
        double convertedValue = baseValue / targetUnit.getConversionFactor();
        return new Quantity<>(convertedValue, targetUnit);
    }

    public Quantity<U> add(Quantity<U> other) {
        double sumBase = this.toBaseUnit() + other.toBaseUnit();
        double resultValue = sumBase / this.unit.getConversionFactor();
        return new Quantity<>(resultValue, this.unit);
    }

    public Quantity<U> add(Quantity<U> other, U targetUnit) {
        double sumBase = this.toBaseUnit() + other.toBaseUnit();
        double resultValue = sumBase / targetUnit.getConversionFactor();
        return new Quantity<>(resultValue, targetUnit);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (!(obj instanceof Quantity<?> other))
            return false;

        // 🔴 IMPORTANT: Prevent cross-category comparison
        if (!this.unit.getClass().equals(other.unit.getClass()))
            return false;

        double thisBase = this.value * this.unit.getConversionFactor();
        double otherBase = other.value * other.unit.getConversionFactor();

        return Math.abs(thisBase - otherBase) < EPSILON;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(toBaseUnit());
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }
}