package org.kd.model;

import java.util.ArrayList;
import java.util.List;

public class Party {
    private String name;
    private List<Fund> availableFunds;

    public Party() {
        this.availableFunds = new ArrayList<>();
    }

    public Party(String name, List<Fund> availableFunds) {
        this.name = name;
        this.availableFunds = availableFunds;
    }

    public void addAvailableFund(Fund newFund) {
        this.availableFunds.add(newFund);
    }

    public double computeAvailableUnits() {
        double allUnits = 0;
        for (Fund fund : this.availableFunds) {
            allUnits += fund.getUnits();
        }
        return allUnits;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Fund> getAvailableFunds() {
        return availableFunds;
    }

    public void setAvailableFunds(List<Fund> availableFunds) {
        this.availableFunds = availableFunds;
    }

    @Override
    public String toString() {
        StringBuilder funds = new StringBuilder();
        availableFunds.forEach((Fund f) -> {
            funds.append(f.toString());
            funds.append(", ");
        });
        return "Party{" +
                "name='" + name + '\'' +
                ", availableFunds=" + funds.toString()
                + '}';
    }
}
