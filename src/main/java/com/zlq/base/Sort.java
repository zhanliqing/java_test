package com.zlq.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by liqing.zhan on 2016/10/9.
 */
public class Sort {
	public static void main(String args[]) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		Collections.shuffle(list);
		System.out.println(list);
		/*Collections.sort(list);
		System.out.println(list);

		Collections.shuffle(list);
		System.out.println(list);*/
		Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (o1 == 0 && o2 > 0) {
					return 1;
				}
				if (o1 > 0 && o2 == 0) {
					return -1;
				}

				return o1 - o2;
			}
		});
		System.out.println(list);
	}
}
