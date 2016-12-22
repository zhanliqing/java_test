package com.zlq.base;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * Created by liqing.zhan on 2016/8/30.
 */
public class MapIterator {
	public static void main(String args[]) throws InterruptedException {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < 10000000; i++) {
			map.put(i, i);
		}

		ConcurrentHashMap<Integer,Integer> map1 = new ConcurrentHashMap<>();
		for (int i = 0; i < 10000000; i++) {
			map1.put(i, i);
		}

		TimeUnit.MINUTES.sleep(100);
		System.out.println("start");
		long id = 0L;
		long start = System.currentTimeMillis();
		for (Integer i : map.keySet()) {
			id += map.get(i);
		}
		long end = System.currentTimeMillis();

		System.out.println(end - start);
		System.out.println(id);

		start = System.currentTimeMillis();
		id = 0L;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			id += entry.getValue();
		}
		end = System.currentTimeMillis();
		System.out.println(end - start);
		System.out.println(id);

		Set<Map.Entry<Integer, Integer>> set = map.entrySet();
		start = System.currentTimeMillis();
		id = 0L;
		for (Map.Entry<Integer, Integer> entry : set) {
			id += entry.getValue();
		}
		end = System.currentTimeMillis();
		System.out.println(end - start);
		System.out.println(id);
	}
}
