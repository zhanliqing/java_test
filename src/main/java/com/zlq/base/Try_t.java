package com.zlq.base;

/**
 * Created by liqing.zhan on 2016/8/20.
 */
public class Try_t {
	public static void main(String args[]) {
		System.out.println(print());
		System.out.println(print1());
	}

	public static String print1() {
		String r = null;
		try {
			r = "1";
			return r;
		} finally {
			r = "0";
		}
	}

	public static String print() {
		try {
			return "1";
		} finally {
			System.out.println("finallly");
			return "0";
		}
	}
}
