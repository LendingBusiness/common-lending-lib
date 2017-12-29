package org.kd.model;

public enum Operation {
    BORROW, LEND;

    @Override
    public String toString() {
        return this.equals(BORROW) ? "borrow" : "lend";
    }
}
