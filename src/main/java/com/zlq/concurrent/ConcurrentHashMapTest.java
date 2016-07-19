package com.zlq.concurrent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * Created by liqing.zhan on 2016/7/13.
 */
public class ConcurrentHashMapTest {
    public static void main(String args[]) throws InterruptedException {
        Map<String, String> count = new ConcurrentHashMap<>();
        int counter = 5;
        while (counter-- > 0) {
            new Thread(() -> {
                int tcount = 10000;
                while (tcount-- > 0) {
                    count.put(Thread.currentThread().getName() + tcount, tcount + "");
                }
            }).start();
        }

        TimeUnit.SECONDS.sleep(5);
        System.out.println(count.size());
    }
}
