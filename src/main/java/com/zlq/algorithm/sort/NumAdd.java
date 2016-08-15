package com.zlq.algorithm.sort;

/**
 * 计算两个数的加法，不用+,-,*,/
 * Created by liqing.zhan on 2016/8/15.
 */
public class NumAdd {
	public static void main(String args[]) {
		System.out.println(add(42, 231));
		System.out.println(add1(42, 231));
		System.out.println(add2(42, 231));
		System.out.println(add3(42, 231));
	}

	public static int add(int a, int b) {
		return (a ^ b) + ((a & b) << 1);
	}

	public static int add1(int a, int b) {
		int c = a;
		int d = b;
		int e = c;
		while (d != 0) {
			c = c ^ d;
			d = (e & d) << 1;
			e = c;
		}
		return c;
	}

	public static int add2(int a, int b) {
		if (b != 0) {
			return add2(a ^ b, (a & b) << 1);
		}
		return a;
	}

	public static int add3(int a, int b) {
		return a + b;
	}
}
