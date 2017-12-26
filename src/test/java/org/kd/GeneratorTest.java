package org.kd;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import org.kd.math2.Numbers;

public final class GeneratorTest {

    @Test
    public void testGenerateIdCreatesUniqueIds() {
        int idsAmount = Numbers.roundToInt(3 * Math.pow(10, 4));
        List<String> ids = new ArrayList<>(idsAmount);
        for (int i = 0; i < idsAmount; i++) {
            String id = Generator.generateId();
            Assert.assertEquals(-1, ids.indexOf(id));
            ids.add(id);
        }
    }
}
