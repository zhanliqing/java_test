package com.zlq.algorithm.sort;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by liqing.zhan on 2016/10/24.
 */
public class HashMapTest {
    public static void main(String... args) {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put("i" + i, i + "i");
        }


        System.out.println(map.entrySet());

        final int max = 8;
        map = new LinkedHashMap() {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > max;
            }
        };
        for (int i = 0; i < 10; i++) {
            map.put("i" + i, i + "i");
        }

        System.out.println(map.keySet());

        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }
}
