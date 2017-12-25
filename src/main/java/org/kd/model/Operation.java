package org.kd.model;

public enum Operation {
    BORROW, LEND;

    @Override
    public String toString() {
        if (this.equals(BORROW))
            return "borrow";
        else
            return "lend";
    }
}
