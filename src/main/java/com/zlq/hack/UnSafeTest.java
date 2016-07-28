package com.zlq.hack;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Created by liqing.zhan on 2016/7/27.
 * http://blog.csdn.net/fenglibing/article/details/17138079
 */
public class UnSafeTest {
	public static void main(String args[]) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
		Unsafe unsafe = getUnSafe();
		objectMemoryInfo(unsafe);
	}

	public static void objectMemoryInfo(Unsafe unsafe) {
		Player player = new Player();
		Player player1 = new Player();
		System.out.println(unsafe.getInt(player, 8L));
		System.out.println(unsafe.getInt(player1, 8L));
		System.out.println(unsafe.getLong(Player.class, 160L));
	}

	public static void createInstance(Unsafe unsafe) throws InstantiationException {
		Player player = (Player) unsafe.allocateInstance(Player.class);
		System.out.println(player.getAge());
	}
	public static void printClassInfo(Unsafe unsafe) throws NoSuchFieldException {
		System.out.println("age offset : " + unsafe.objectFieldOffset(Player.class.getDeclaredField("age")));
		System.out.println("a1 offset : " + unsafe.objectFieldOffset(Player.class.getDeclaredField("a1")));
		System.out.println("c1 offset : " + unsafe.objectFieldOffset(Player.class.getDeclaredField("c1")));
		// System.out.println("i1 offset : " +
		// unsafe.objectFieldOffset(Player.class.getDeclaredField("i1")));
		System.out.println("c1 offset : " + unsafe.objectFieldOffset(Player.class.getDeclaredField("c2")));
	}

	public static void printSystemInfo(Unsafe unsafe) {
		System.out.println(unsafe.addressSize());
		System.out.println(unsafe.pageSize());
	}

	public static Unsafe getUnSafe() throws NoSuchFieldException, IllegalAccessException {
		Field f = Unsafe.class.getDeclaredField("theUnsafe");
		f.setAccessible(true);
		Unsafe unsafe = (Unsafe) f.get(null);
		return unsafe;
	}

	static class Player {
		private int age = 12;
		private long a1 = 0L;
		private char c1 = 'a';
		// private int i1 = 2;
		private char c2 = 'b';

		private Player() {
			this.age = 50;
		}

		public int getAge() {
			return this.age;
		}

		public void setAge(int age) {
			this.age = age;
		}
	}
}
