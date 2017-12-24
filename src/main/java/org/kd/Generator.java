package org.kd;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

public class Generator {

    private static short prefix = 0;
    private static final Logger logger = Logger.getLogger(Generator.class.getName());

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
}
