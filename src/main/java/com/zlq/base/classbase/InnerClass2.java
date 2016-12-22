package com.zlq.base.classbase;

/**
 * Created by liqing.zhan on 2016/9/26.
 */
public class InnerClass2 {
	private String name = "haha";
	public InnerClass2() {
		System.out.println("InnerClass2");
	}

	public static void main(String args[]) {
		InnerClass2 class1 = new InnerClass2();
		InnerClass2.A a = class1.new A();
	}

	private class A {
		A() {
			System.out.println("A");
			System.out.println(name);
		}
	}
}
