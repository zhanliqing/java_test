package com.zlq.base;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by liqing.zhan on 2016/10/12.
 */
public class ProxyTest {
	public static void main(String... args) {
		T1 t = new T1();
		t.p();

		T t1 = (T) Proxy.newProxyInstance(ProxyTest.class.getClassLoader(), new Class[]{T.class}, new TP(t));

		System.out.println(t1.getClass().getSimpleName());

		Method methods[] = t1.getClass().getMethods();
		for (Method method : methods) {
			System.out.println(method.getName());
		}
		t1.p();

		Class interfaces[] = t1.getClass().getInterfaces();
		for (Class c : interfaces) {
			System.out.println("aa" + c.getSimpleName());
		}

		System.out.println("super class " + t1.getClass().getSuperclass().getSimpleName());
	}
}

class TP implements InvocationHandler {
	Object proxyObject;

	public TP(Object proxyObject) {
		this.proxyObject = proxyObject;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("TP Start");
		Object result = method.invoke(proxyObject, args);
		System.out.println("TP end");
		return result;

	}
}

class T1 implements T {

	@Override
	public void p() {
		System.out.println("T1");
	}
}

interface T {
	void p();
}
