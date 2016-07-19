package com.zlq.concurrent;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;

/**
 * Created by liqing.zhan on 2016/7/12.
 */
public class LongAdderTest {
    @Test
    public void t1() throws InterruptedException {
        LongAdder longAdder = new LongAdder();
        int count = 5;
        while (count-- > 0) {
            new Thread(() -> {
                int end = 100;
                while (end-- > 0) {
                    longAdder.add(1);
                }
            }).start();
        }

        TimeUnit.SECONDS.sleep(5);
        System.out.println(longAdder.longValue());
    }
}
