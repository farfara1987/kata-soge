package com.bankaccount.kata.domain;

import java.text.DecimalFormat;
import java.util.Objects;

public class Amount {

    private double value;

    private DecimalFormat amountDecimalFormat = new DecimalFormat("#.00");


    public Amount() {
    }

    public Amount(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String toMoneyFormat() {
        return amountDecimalFormat.format(value);
    }

    public Amount addValue(double value) {
        return new Amount(this.value + value);
    }

    public Amount substractValue(double value) {
        return new Amount(this.value - value);
    }

    public double getNegativeValue() {
        return -value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amount amount = (Amount) o;
        return Double.compare(amount.value, value) == 0 &&
                Objects.equals(amountDecimalFormat, amount.amountDecimalFormat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, amountDecimalFormat);
    }
}
