package org.kd;

import org.junit.Test;
import org.kd.model.Fund;
import org.kd.model.Operation;
import org.kd.model.Party;
import org.kd.model.Trade;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class TradeTest {

    @Test
    public void createTradeTest() {
        List<Fund> availableFunds = new ArrayList<>(1);
        availableFunds.add(new Fund("Fund1", 100));
        Trade trade = new Trade(availableFunds.get(0)
                , new Party("Party1", availableFunds)
                , Operation.BORROW, 80);

        assertNotNull(trade.getId());
        assertNotEquals("", trade.getId());
        assertEquals(100, trade.getFund().getUnits());
        assertEquals(Trade.State.NEW, trade.getState());
        assertEquals("borrow", trade.getOperation().toString());
    }
}
