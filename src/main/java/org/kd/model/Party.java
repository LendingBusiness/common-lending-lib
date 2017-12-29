package org.kd.model;

import org.kd.Generator;

import java.util.ArrayList;
import java.util.List;

public class Party {
    private String name;
    private String id;
    private String externalId;
    private List<Fund> availableFunds;

    public Party() {
        this.availableFunds = new ArrayList<>();
        init();
    }

    public Party(String name, List<Fund> availableFunds) {
        this.name = name;
        this.availableFunds = availableFunds;
        init();
    }

    private void init() {
        this.id = Generator.generateId();
        this.externalId = Generator.generateExternalId(id);
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

    public String getId() {
        return id;
    }

    public String getExternalId() {
        return externalId;
    }
}
