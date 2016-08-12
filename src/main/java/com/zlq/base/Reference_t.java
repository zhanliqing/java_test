package com.zlq.base;

import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

/**
 * Created by liqing.zhan on 2016/8/8.
 */

public class Reference_t {
	public static void main(String args[]) throws InterruptedException {
		Object obj = new Object();

		Reference<Object> weakReference = new WeakReference<>(obj);
		Reference<Object> softReference = new SoftReference<>(obj);

		System.out.println(weakReference.get() == null);
		System.out.println(softReference.get() == null);

		obj = null;
		System.gc();
		TimeUnit.SECONDS.sleep(3);
		System.out.println(weakReference.get() == null);
		System.out.println(softReference.get() == null);
	}

}
