package org.kd.model;

public enum BusinessOperation {
    BORROW, LEND;

    @Override
    public String toString() {
        return this.equals(BORROW) ? "borrow" : "lend";
    }
}
