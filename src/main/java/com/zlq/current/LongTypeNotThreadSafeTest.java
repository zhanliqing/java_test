package com.zlq.current;

import java.util.concurrent.TimeUnit;

/**
 * Created by liqing.zhan on 2016/7/12.
 */
public class LongTypeNotThreadSafeTest {
    static long value = 0;

    public static void add() {
        value++;
    }

    public static void main(String args[]) throws InterruptedException {
        int count = 5;
        while (count-- > 0) {
            new Thread(() -> {
                int c = 10000;
                while (c-- > 0) {
                    LongTypeNotThreadSafeTest.add();
                }

            }).start();
        }

        TimeUnit.SECONDS.sleep(5);
        System.out.println(value);
    }
}
