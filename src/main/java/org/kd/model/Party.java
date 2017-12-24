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
        availableFunds.forEach(f -> {
            funds.append(f.toString() + ", ");
        });
        return "Party{" +
                "name='" + name + '\'' +
                ", availableFunds=" + funds.toString()
                + '}';
    }
}
