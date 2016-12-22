package com.zlq.base;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liqing.zhan on 2016/8/30.
 */
public class MapNullKey {
	public static void main(String args[]) {
		Map<String, String> map = new HashMap<>();
		map.put(null, "aaa");
		System.out.println(map.get(null));
	}
}
