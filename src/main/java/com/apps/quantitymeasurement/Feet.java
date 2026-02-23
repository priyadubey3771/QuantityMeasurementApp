package com.apps.quantitymeasurement;

public class Feet {
    private double value;

    public Feet(double value) {
        if (value < 0) {
            throw new IllegalArgumentException("Invalid feet value");
        }
        this.value = value;
    }

    public double toInches() {
        return this.value * 12;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null || !(obj instanceof Feet))
            return false;

        Feet other = (Feet) obj;

        return Math.abs(this.value - other.value) < 0.0001;
    }
}