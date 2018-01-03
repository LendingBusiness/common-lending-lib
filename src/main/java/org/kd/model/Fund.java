package org.kd.model;

public class Fund implements LegalEntity{
    private String id;
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

    @Override
    public String getId() {
        return this.id;
    }

    public int getUnits() {
        return units;
    }

    @Override
    public String toString() {
        return "Fund{" + "name='" + name + '\'' + '}';
    }
}
