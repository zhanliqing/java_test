package com.zlq.io.serialization;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * Created by liqing.zhan on 2016/8/5.
 */
public class SObj implements Serializable {
	private static final long serialVersionUID = 3369839114983242440L;
	private int a;
	private String b;
	private List<Object> list;
	public SObj() {
		System.out.println("construct");
		a = 10;
		b = "10";
		list = Arrays.asList(1, 2, 3, 4, 5);
	}

	@Override
	public String toString() {
		return "SObj{" + "a=" + a + ", b='" + b + '\'' + ", list=" + list + '}';
	}
}
