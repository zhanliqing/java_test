package com.zlq.mapdb;

import org.mapdb.DB;
import org.mapdb.DBMaker;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by liqing.zhan on 2016/8/31.
 */
public class T1 {
	public static void main(String args[]) {
		t1();
	}

	public static void t1() {
		Map m = new TreeMap();
		for (long counter = 0;; counter++) {
			m.put(counter, "");
			if (counter % 1000000 == 0)
				System.out.println("" + counter);
		}
	}

	public static void t2() {
		DB db = DBMaker.memoryDirectDB().make();
		ConcurrentMap map = db.hashMap("map").make();
		for (long counter = 0;; counter++) {
			map.put(counter, "");
			if (counter % 1000000 == 0)
				System.out.println("" + counter);
		}
	}
}
