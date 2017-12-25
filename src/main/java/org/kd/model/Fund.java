package org.kd.model;

public class Fund {
    private String name;
    private int units;

    public Fund() {
    }

    public Fund(String name, int units) {
        this.name = name;
        this.units = units;
    }

    public String getName() {
        return name;
    }

    public int getUnits() {
        return units;
    }

    @Override
    public String toString() {
        return "Fund{" + "name='" + name + '\'' + '}';
    }
}
