package com.zlq.base.classbase;

/**
 * Created by liqing.zhan on 2016/9/26.
 */
public class Inner1 {

	public static void main(String... args) {
		InnerClass2 class2 = new InnerClass2();

		InnerClass1 class1 = new InnerClass1();
		InnerClass1.A a = class1.new A();
	}
}
