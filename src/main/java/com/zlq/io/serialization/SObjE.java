package com.zlq.io.serialization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Arrays;
import java.util.List;

/**
 * Created by liqing.zhan on 2016/8/5.
 */
public class SObjE implements Externalizable {
	private static final long serialVersionUID = 3369839114983242440L;
	private int a;
	private String b;
	private List<Object> list;
	public SObjE() {
		System.out.println("construct");
		a = 10;
		b = "10";
		list = Arrays.asList(1, 2, 3, 4, 5);
	}

	@Override
	public String toString() {
		return "SObj{" + "a=" + a + ", b='" + b + '\'' + ", list=" + list + '}';
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeInt(a);
		out.writeChars(b);
		out.writeObject(list);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		this.a = in.readInt();
		this.b = in.readLine();
		this.list = (List<Object>) in.readObject();
	}
}
