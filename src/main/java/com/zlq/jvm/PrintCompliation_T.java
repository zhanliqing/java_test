package com.zlq.jvm;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

/**
 *
 * -XX:+PrintCompilation  输出即时编译信息
 * -XX:+CITime  JVM关闭时得到各种编译的统计信息
 *
 *
 * Created by liqing.zhan on 2016/9/5.
 */
public class PrintCompliation_T {
	public static void main(String args[]) throws InterruptedException {
		Random random = new Random();
		Map<Integer, Integer> map = new TreeMap<>();
		for (int i = 10; i < 1000000; i++) {
			map.put(random.nextInt(i), random.nextInt(i));
			TimeUnit.MICROSECONDS.sleep(10);
		}

		TimeUnit.SECONDS.sleep(10000);
	}
}
