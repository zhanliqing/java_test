package com.zlq.base;

import java.util.Random;

/**
 * Created by liqing.zhan on 2016/8/6.
 */
public class Random_t {
	public static void main(String args[]) {
		int n = 2 * (Integer.MAX_VALUE / 3);
		int count = 0;
		for (int i = 0; i < 100000; i++) {
			if (random(n) < n / 2)
				count++;
		}

		System.out.println(count);
	}

	static int random(int n) {
		Random random = new Random();
		int t = random.nextInt();
		while (t < 0) {
			t = random.nextInt();
		}
		return t % n;
	}

}
