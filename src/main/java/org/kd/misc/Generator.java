package org.kd.misc;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import org.kd.math2.Numbers;

public final class Generator {

    private static short prefix = 0;
    private static final Logger logger = Logger.getLogger(Generator.class.getName());

    private Generator(){
    }

    public static String generateId() {
        Date now = new Date();
        try {
            String date = new SimpleDateFormat("ssSSS").format(now);
            prefix++;
            return date.concat(Integer.toString(prefix + 128));
        } catch (Exception e) {
            logger.warning(e.getMessage());
            return null;
        }
    }

    public static String generateExternalId(String id) {
        List<String> prefixes = Arrays.asList(new String[]
                {"US22", "EUR502", "CN151"});

        int index = Numbers.roundToInt(Math.random() * 2);
        return prefixes.get(index).concat(id).concat("3");
    }
}
