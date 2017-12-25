package org.kd.model;

import org.kd.Generator;

public class Trade {

    enum State {NEW, BOOKED, SETTLED
        , RETURN_BOOKED, RETURN_SETTLED
        , CLOSED}

    private String id;
    private Fund fund;
    private Party party;
    private Operation operation;
    private double amount;
    private State state;

    public Trade() {
        init();
    }

    public Trade(Fund fund, Party party, Operation operation, double amount) {
        init();
        this.id = Generator.generateId();
        this.fund = fund;
        this.party = party;
        this.operation = operation;
        this.amount = amount;
    }

    private void init() {
        this.id = Generator.generateId();
        this.state = State.NEW;
    }


    public String getId() {
        return id;
    }

    public Fund getFund() {
        return fund;
    }

    public Party getParty() {
        return party;
    }

    public Operation getOperation() {
        return operation;
    }

    public double getAmount() {
        return amount;
    }

    public State getState() {
        return state;
    }

}
