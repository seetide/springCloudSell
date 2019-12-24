package com.immoc.order.utils;

import java.util.Random;

/**
 * Created by haitao on 12/23/19
 *
 * @project: order
 */

public class KeyUtil {

    /**
     * Generate unique key
     * format: timeStamp + random number
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(1000000);

        return System.currentTimeMillis() + String.valueOf(number);

    }
}
