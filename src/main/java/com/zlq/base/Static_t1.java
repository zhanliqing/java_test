package com.zlq.base;

/**
 * Created by liqing.zhan on 2016/8/12.
 */
public class Static_t1 {
	public static Instance INSTANCE = null;
	public static int age = 0;

	static {
		System.out.println("static");
		age = 100;
	}

	public Static_t1() {
		System.out.println("consutrctor");
	}
	public static Instance getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new Instance(new Static_t1());
		}
		return INSTANCE;
	}

	public static void main(String args[]) {
		System.out.println(getInstance().getInstance().age);
	}

}
class Instance {
	private Static_t1 static_t;
	public Instance(Static_t1 static_t) {
		this.static_t = static_t;
		System.out.println("Instance---" + static_t.age);
	}

	public Static_t1 getInstance() {
		return static_t;
	}
}