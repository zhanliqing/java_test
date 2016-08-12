package com.zlq.base;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liqing.zhan on 2016/8/9.
 */
public class ClassCast_t {
	@Test
	public void objectToClass() {
		List<Class> list = new ArrayList<>();
		list.add(String.class);

		Class c[] = new Class[list.size()];
		list.toArray(c);
		System.out.println(c.length);
	}
}
