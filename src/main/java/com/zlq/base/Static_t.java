package com.zlq.base;

/**
 * Created by liqing.zhan on 2016/8/12.
 */
public class Static_t {
	// public static final Static_t instance = new Static_t();
	public static int age = 0;
	public static Static_t instance = null;

	static {
		System.out.println("static");
		age = 100;
	}

	public static Static_t getInstance() {
		if (instance == null) {
			instance = new Static_t();
		}
		return instance;
	}

	public Static_t() {
		System.out.println("consutrctor");
	}
	public static void main(String args[]) {
		System.out.println(getInstance().age);
	}
}
