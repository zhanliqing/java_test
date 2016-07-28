package com.zlq.io;

import org.junit.Test;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.nio.ByteBuffer;

/**
 * Created by liqing.zhan on 2016/7/25.
 * 
 * public static ByteBuffer allocateDirect(int capacity) max 2G
 * 
 * public native long allocateMemory(long var1)
 * 
 */
public class DirectBufferTest {
	@Test
	public void main() throws NoSuchFieldException, IllegalAccessException {
		unsafe_m();
		direct_m();
		unsafe_m();
		direct_m();
	}

	@Test
	public void direct_m() {
		ByteBuffer byteBuffer = ByteBuffer.allocateDirect(16);
		int count = 1000000;
		long start = System.currentTimeMillis();
		while (count-- > 0) {
			byteBuffer.putLong(0, 1L);
			byteBuffer.putFloat(8, 1.0f);
			byteBuffer.getLong(0);
			byteBuffer.getFloat(8);
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		byteBuffer.clear();
	}

	@Test
	public void unsafe_m() throws NoSuchFieldException, IllegalAccessException {
		Unsafe unsafe = getUnsafe();
		long pointer = unsafe.allocateMemory(16);
		int count = 1000000;
		long start = System.currentTimeMillis();
		while (count-- > 0) {
			unsafe.putLong(pointer, 1L);
			unsafe.putFloat(pointer + 8, 1.0f);
			unsafe.getLong(pointer);
			unsafe.getFloat(pointer + 8);
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		unsafe.freeMemory(pointer);
	}

	public static Unsafe getUnsafe() throws NoSuchFieldException, IllegalAccessException {
		Field field = Unsafe.class.getDeclaredField("theUnsafe");
		field.setAccessible(true);
		return (Unsafe) field.get(null);
	}
}
