package org.kd.model;

import org.kd.Generator;
import java.util.Date;
import java.util.List;

public class Trade {

    public enum State {
        NEW, BOOKED, SETTLED, RETURN_BOOKED, RETURN_SETTLED, CLOSED
    }

    private String id;
    private Party destParty;
    private Party originParty;
    private Operation operation;
    private List<Fund> fundUnits;
    private State state;
    private Date bookDate;
    private Date settlementDate;
    private Date bookReturnDate;
    private Date returnSettlementDate;

    public Trade() {
        init();
    }

    public Trade(Party originParty, Party destParty, Operation operation, List<Fund> fundUnits) {
        init();
        this.id = Generator.generateId();
        this.originParty = originParty;
        this.destParty = destParty;
        this.operation = operation;
        this.fundUnits = fundUnits;
    }

    private void init() {
        this.id = Generator.generateId();
        this.state = State.NEW;
    }

    public String getId() {
        return id;
    }

    public Party getOriginParty() {
        return originParty;
    }

    public Party getDestParty() {
        return destParty;
    }

    public Operation getOperation() {
        return operation;
    }

    public List<Fund> getFundUnits() {
        return fundUnits;
    }

    public State getState() {
        return state;
    }

    public Date getBookDate() {
        return bookDate;
    }

    public void setBookDate(Date bookDate) {
        this.bookDate = bookDate;
    }

    public Date getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(Date settlementDate) {
        this.settlementDate = settlementDate;
    }

    public Date getBookReturnDate() {
        return bookReturnDate;
    }

    public void setBookReturnDate(Date bookReturnDate) {
        this.bookReturnDate = bookReturnDate;
    }

    public Date getReturnSettlementDate() {
        return returnSettlementDate;
    }

    public void setReturnSettlementDate(Date returnSettlementDate) {
        this.returnSettlementDate = returnSettlementDate;
    }


}
