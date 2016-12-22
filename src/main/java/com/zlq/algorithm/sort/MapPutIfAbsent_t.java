package com.zlq.algorithm.sort;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by liqing.zhan on 2016/11/25.
 */
public class MapPutIfAbsent_t {
    public static void main(String[] args) {
        Random random = new Random();
        Map<String, String> map = new ConcurrentHashMap<>();
        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                int j = random.nextInt(1000);
                String prev = map.putIfAbsent(j + "", j + " ");
                if (prev == null) {
                    System.out.println(Thread.currentThread().getName() + "   " + j + " put");
                } else {
                    System.out.println(Thread.currentThread().getName() + "   " + j + " exist");
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                int j = random.nextInt(1000);
                String prev = map.putIfAbsent(j + "", j + " ");
                if (prev == null) {
                    System.out.println(Thread.currentThread().getName() + "   " + j + " put");
                } else {
                    System.out.println(Thread.currentThread().getName() + "   " + j + " exist");
                }
            }
        }).start();
    }
}
