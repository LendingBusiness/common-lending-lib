package org.kd;

import org.junit.Test;
import org.kd.model.Fund;
import org.kd.model.Operation;
import org.kd.model.Party;
import org.kd.model.Trade;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

public final class PartyTradeTest {

    @Test
    public void createTradeTest() {
        List<Fund> availableFunds = new ArrayList<>(1);
        Fund f1 = new Fund("Fund1", 100);
        List<Fund> borrowFund = Arrays.asList(new Fund("Fund1", 12));
        availableFunds.add(f1);

        Party p1 = new Party("Party1", availableFunds);
        Party p2 = new Party("Party2", availableFunds);

        Trade trade = new Trade(p1, p2, Operation.BORROW, borrowFund);

        assertNotNull(trade.getId());
        assertNotEquals("", trade.getId());
        assertEquals(12, trade.getFundUnits().get(0).getUnits());
        assertEquals(Trade.State.NEW, trade.getState());
        assertEquals("borrow", trade.getOperation().toString());
        double margin = 0.1d;
        assertEquals(100d, trade.getOriginParty().computeAvailableUnits(), margin);
        trade.getOriginParty().addAvailableFund(f1);
        assertEquals(200d, trade.getOriginParty().computeAvailableUnits(), margin);
        assertEquals(2, trade.getOriginParty().getAvailableFunds().size());
    }
}
