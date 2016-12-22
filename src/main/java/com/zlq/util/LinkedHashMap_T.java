package com.zlq.util;

import java.util.LinkedHashMap;

/**
 * Created by liqing.zhan on 2016/9/1.
 */
public class LinkedHashMap_T {
	public static void main(String args[]) {
		LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();

		for (int i = 0; i < 50; i++) {
			linkedHashMap.put(i, i);
		}

		linkedHashMap.put(4, 4);

		System.out.println(linkedHashMap.values());
	}

}
