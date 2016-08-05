package com.zlq.String;

import org.junit.Test;

/**
 * Created by liqing.zhan on 2016/8/1.
 */
public class String_t1 {
	@Test
	public void t1() {
		String a = "中华人民共和国";
		System.out.println(a.substring(0, a.length() - 3));
		String b = "chinese";
		System.out.println(b.substring(0, b.length() - 3));
	}
}
