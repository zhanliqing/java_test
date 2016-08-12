package com.zlq.String;

import org.junit.Test;

/**
 * Created by liqing.zhan on 2016/8/11.
 */
public class StringIntern_t {
	@Test
	public void jdk16Intern() {
		String a = "aaaaa";
		String b = "aaaaa";
		System.out.println(a == b);

		String c = new String("aaaaa");
		System.out.println(c.intern() == a);
	}
}
