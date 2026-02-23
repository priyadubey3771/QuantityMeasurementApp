package com.apps.quantitymeasurement;

public class Inches {
    private double value;

    public Inches(double value) {
        if (value < 0) {
            throw new IllegalArgumentException("Invalid inches value");
        }
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null || !(obj instanceof Inches))
            return false;

        Inches other = (Inches) obj;

        return Math.abs(this.value - other.value) < 0.0001;
    }
}