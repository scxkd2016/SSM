package com.order.utils;

import java.util.Random;

public class KeyUtil {
    public static synchronized String genKey() {
        Random random = new Random();
        int number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}
