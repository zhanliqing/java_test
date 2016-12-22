package com.zlq.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liqing.zhan on 2016/12/8.
 */
public class MapIterTest {
    public static void main(String[] args) {
        Map<String, List<String>> map = new HashMap<>();
        map.put("1", new ArrayList<>());
        map.get("1").add("2");

        map.put("2", new ArrayList<>());

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getValue().size() != 0) {
                map.remove(entry.getKey());
            }
            System.out.println(entry.getKey());
        }

        System.out.println(map.size());
    }
}
