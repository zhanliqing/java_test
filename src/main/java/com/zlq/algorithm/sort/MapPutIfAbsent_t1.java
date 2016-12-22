package com.zlq.algorithm.sort;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * Created by liqing.zhan on 2016/11/28.
 */
public class MapPutIfAbsent_t1 {
    public static void main(String[] args) throws InterruptedException {
        Map<String, String> map = new HashMap<>();

        Map<String, String> map1 = new ConcurrentHashMap<>();


        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                String value = map.putIfAbsent("" + i, "" + i);
                if (value == null) {
                    map1.put(String.valueOf(i), String.valueOf(i));
                } else {
                    map1.put(String.valueOf(i), value);
                }
            }
            System.out.println(Thread.currentThread().getName() + "  done ");
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                String value = map.putIfAbsent("" + i, "" + i + 1);
                if (value == null) {
                    map1.put(String.valueOf(i), String.valueOf(i + 1));
                } else {
                    map1.put(String.valueOf(i), value);
                }
            }
            System.out.println(Thread.currentThread().getName() + "  done ");
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                String value = map.putIfAbsent("" + i, "" + i + 2);
                if (value == null) {
                    map1.put(String.valueOf(i), String.valueOf(i + 2));
                } else {
                    map1.put(String.valueOf(i), value);
                }
            }
            System.out.println(Thread.currentThread().getName() + "  done ");
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                String value = map.putIfAbsent("" + i, "" + i + 3);
                if (value == null) {
                    map1.put(String.valueOf(i), String.valueOf(i + 3));
                } else {
                    map1.put(String.valueOf(i), value);
                }
            }
            System.out.println(Thread.currentThread().getName() + "  done ");
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                String value = map.putIfAbsent("" + i, "" + i + 4);
                if (value == null) {
                    map1.put(String.valueOf(i), String.valueOf(i + 4));
                } else {
                    map1.put(String.valueOf(i), value);
                }
            }
            System.out.println(Thread.currentThread().getName() + "  done ");
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                String value = map.putIfAbsent("" + i, "" + i + 5);
                if (value == null) {
                    map1.put(String.valueOf(i), String.valueOf(i + 5));
                } else {
                    map1.put(String.valueOf(i), value);
                }
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                String value = map.putIfAbsent("" + i, "" + i + 6);
                if (value == null) {
                    map1.put(String.valueOf(i), String.valueOf(i + 6));
                } else {
                    map1.put(String.valueOf(i), value);
                }
            }
            System.out.println(Thread.currentThread().getName() + "  done ");
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                String value = map.putIfAbsent("" + i, "" + i + 7);
                if (value == null) {
                    map1.put(String.valueOf(i), String.valueOf(i + 7));
                } else {
                    map1.put(String.valueOf(i), value);
                }
            }
            System.out.println(Thread.currentThread().getName() + "  done ");
        }).start();


        TimeUnit.SECONDS.sleep(10);

        for (int i = 0; i < 10000; i++) {
            if (!map.get(String.valueOf(i)).equals(map1.get(String.valueOf(i)))) {
                System.out.println(i + " map " + map.get(String.valueOf(i) + " map1 " + map1.get(String.valueOf(i))));
            }
        }

    }
}
