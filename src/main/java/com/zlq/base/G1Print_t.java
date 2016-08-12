package com.zlq.base;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by liqing.zhan on 2016/8/8.
 */
public class G1Print_t {
	public static void main(String args[]) {
		List<byte[]> list = new LinkedList<>();

		new Thread(() -> {
			while (true) {
				byte b[] = new byte[1024 * 80];
				list.add(b);
				try {
					TimeUnit.MILLISECONDS.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}).start();

		new Thread(() -> {
			while (true) {
				if (list.size() > 0) {
					list.remove(0);
				}
				try {
					TimeUnit.MILLISECONDS.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}).start();

//		new Thread(() -> {
//			while (true) {
//				System.gc();
//				try {
//					TimeUnit.MILLISECONDS.sleep(1000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//		}).start();

		try {
			TimeUnit.SECONDS.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
