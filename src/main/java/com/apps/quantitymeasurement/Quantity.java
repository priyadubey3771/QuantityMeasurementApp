package com.apps.quantitymeasurement;

import java.util.function.DoubleBinaryOperator;

public class Quantity<U extends IMeasurable> {

    private final double value;
    private final U unit;

    public Quantity(double value, U unit) {
        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");
        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Value must be finite");

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public U getUnit() {
        return unit;
    }

    /* ===================== ENUM BASED OPERATION ===================== */

    private enum ArithmeticOperation {

        ADD((a, b) -> a + b),
        SUBTRACT((a, b) -> a - b),
        DIVIDE((a, b) -> {
            if (b == 0)
                throw new ArithmeticException("Division by zero");
            return a / b;
        });

        private final DoubleBinaryOperator operator;

        ArithmeticOperation(DoubleBinaryOperator operator) {
            this.operator = operator;
        }

        public double compute(double a, double b) {
            return operator.applyAsDouble(a, b);
        }
    }

    /* ===================== CENTRAL VALIDATION ===================== */

    private void validateArithmeticOperands(Quantity<U> other, U targetUnit, boolean requireTarget) {

        if (other == null)
            throw new IllegalArgumentException("Other quantity cannot be null");

        if (!unit.getClass().equals(other.unit.getClass()))
            throw new IllegalArgumentException("Cross-category operation not allowed");

        if (!Double.isFinite(other.value))
            throw new IllegalArgumentException("Value must be finite");

        if (requireTarget && targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");
    }

    /* ===================== CORE HELPER ===================== */

    private double performBaseArithmetic(Quantity<U> other,
                                         ArithmeticOperation operation) {

        double baseThis = unit.convertToBaseUnit(value);
        double baseOther = other.unit.convertToBaseUnit(other.value);

        return operation.compute(baseThis, baseOther);
    }

    private double roundToTwoDecimals(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    /* ===================== ADD ===================== */

    public Quantity<U> add(Quantity<U> other) {
        return add(other, this.unit);
    }

    public Quantity<U> add(Quantity<U> other, U targetUnit) {

        validateArithmeticOperands(other, targetUnit, true);

        double baseResult = performBaseArithmetic(other, ArithmeticOperation.ADD);
        double converted = targetUnit.convertFromBaseUnit(baseResult);

        return new Quantity<>(roundToTwoDecimals(converted), targetUnit);
    }

    /* ===================== SUBTRACT ===================== */

    public Quantity<U> subtract(Quantity<U> other) {
        return subtract(other, this.unit);
    }

    public Quantity<U> subtract(Quantity<U> other, U targetUnit) {

        validateArithmeticOperands(other, targetUnit, true);

        double baseResult = performBaseArithmetic(other, ArithmeticOperation.SUBTRACT);
        double converted = targetUnit.convertFromBaseUnit(baseResult);

        return new Quantity<>(roundToTwoDecimals(converted), targetUnit);
    }

    /* ===================== DIVIDE ===================== */

    public double divide(Quantity<U> other) {

        validateArithmeticOperands(other, null, false);

        return performBaseArithmetic(other, ArithmeticOperation.DIVIDE);
    }
}