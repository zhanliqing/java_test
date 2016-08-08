package com.zlq.io.serialization;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by liqing.zhan on 2016/8/5.
 */
public class Main {
	@Test
	public void javaSW1() throws IOException {
		ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(new File("d://abc/j.bin")));
		SObj s = new SObj();
		outputStream.writeObject(s);
		outputStream.writeObject(s);
		outputStream.close();
	}

	@Test
	public void javaSR1() throws IOException, ClassNotFoundException {
		ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(new File("d://abc/j.bin")));

		SObj s = (SObj) inputStream.readObject();
		System.out.println(s);

		SObj s1 = (SObj) inputStream.readObject();
		System.out.println(s1);
		System.out.println(s1 == s);
		ObjectInputStream inputStream1 = new ObjectInputStream(new FileInputStream(new File("d://abc/j.bin")));
		SObj s2 = (SObj) inputStream1.readObject();
		System.out.println(s1 == s2);
		System.out.println(s2 == s);
	}

	@Test
	public void javaEW1() throws IOException {
		ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(new File("d://abc/j1.bin")));
		SObjE s = new SObjE();
		outputStream.writeObject(s);
		outputStream.writeObject(s);
		outputStream.close();
	}

	@Test
	public void javaER1() throws IOException, ClassNotFoundException {
		ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(new File("d://abc/j1.bin")));
		SObjE s = (SObjE) inputStream.readObject();
		SObjE s1 = (SObjE) inputStream.readObject();
		System.out.println(s);
		System.out.println(s == s1);
	}
}
