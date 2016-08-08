package com.zlq.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * Created by liqing.zhan on 2016/8/6.
 */
public class ThreadLocal_t {
	public static void main(String args[]) {
		ThreadLocal<String> local = new ThreadLocal<>();
		new Thread(() -> {
			local.set("qqq");
			try {
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("1111" + local.get());
		}).start();

		new Thread(() -> {
			System.out.println(local.get());
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			local.set("bbb");
			System.out.println("2222" + local.get());

		}).start();
	}
}
