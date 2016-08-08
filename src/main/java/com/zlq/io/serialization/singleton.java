package com.zlq.io.serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by liqing.zhan on 2016/8/5.
 */
public class Singleton implements Serializable {
	public static final Singleton s = new Singleton();
	private Singleton() {
	}
	public static Singleton getSingleton() {
		return s;
	}

	public static void main(String args[]) throws IOException, ClassNotFoundException {
		Singleton singleton = Singleton.getSingleton();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(1024);

		ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

		objectOutputStream.writeObject(singleton);
		System.out.println(outputStream.toByteArray().length);
		ByteArrayInputStream in = new ByteArrayInputStream(outputStream.toByteArray());

		ObjectInputStream objectInputStream = new ObjectInputStream(in);
		Singleton singleton1 = (Singleton) objectInputStream.readObject();
		System.out.println(singleton == singleton1);
	}

	private Object readResolve() {
		return s;
	}
}
