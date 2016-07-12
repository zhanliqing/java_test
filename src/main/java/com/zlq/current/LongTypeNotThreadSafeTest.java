package com.zlq.current;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * Created by liqing.zhan on 2016/7/12.
 */
public class LongTypeNotThreadSafeTest {
    static long value = 0;
    static AtomicLong atomicLong = new AtomicLong(0);
    static LongAdder longAdder = new LongAdder();

    public static void addLong() {
        value++;
    }

    public static void addAtomicLong() {
        atomicLong.incrementAndGet();
    }

    public static void addLongAdder() {
        longAdder.add(1);
    }

    @Test
    public void t1() throws InterruptedException {
        int count = 5;
        while (count-- > 0) {
            new Thread(() -> {
                int c = 10000;
                while (c-- > 0) {
                    LongTypeNotThreadSafeTest.addLong();
                }

            }).start();
        }

        TimeUnit.SECONDS.sleep(5);
        System.out.println(value);
    }

    @Test
    public void t2() throws InterruptedException {
        int count = 5;
        while (count-- > 0) {
            new Thread(() -> {
                int c = 10000;
                while (c-- > 0) {
                    LongTypeNotThreadSafeTest.addAtomicLong();
                }

            }).start();
        }

        TimeUnit.SECONDS.sleep(5);
        System.out.println(atomicLong.get());
    }

    @Test
    public void t3() throws InterruptedException {
        int count = 5;
        while (count-- > 0) {
            new Thread(() -> {
                int c = 10000;
                while (c-- > 0) {
                    LongTypeNotThreadSafeTest.addLongAdder();
                }

            }).start();
        }

        TimeUnit.SECONDS.sleep(5);
        System.out.println(longAdder.longValue());
    }
}
