package com.zlq.base.classbase;

/**
 * Created by liqing.zhan on 2016/9/26.
 */
public class A extends B implements C {
	public static void main(String... args) {
		C c = new A();
		c.p();
	}
}
