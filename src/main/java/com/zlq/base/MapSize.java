package com.zlq.base;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by liqing.zhan on 2016/8/31.
 */
public class MapSize {
	public static void main(String args[]) throws InterruptedException {
		ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
		concurrentHashMap.put(null, "aaa");
		System.out.println(concurrentHashMap.get(null));
	}
}
