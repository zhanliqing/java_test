package com.zlq.base.classbase;

/**
 * Created by liqing.zhan on 2016/9/26.
 */
public class InnerClass1 {

	public InnerClass1() {
		System.out.println("InnerClass1");
	}

	public static void main(String args[]) {
		InnerClass1 class1 = new InnerClass1();
		InnerClass1.A a = class1.new A();
	}

	class A {
		A() {
			System.out.println("A");
		}
	}
}
