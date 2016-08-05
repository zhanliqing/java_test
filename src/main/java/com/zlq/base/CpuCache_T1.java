package com.zlq.base;

import org.junit.Test;

/**
 * Created by liqing.zhan on 2016/8/2.
 */
public class CpuCache_T1 {
	/**
	 * CPU访问register通常需要1个CPU周期，而访问内存需要200多个周期
	 *
	 * 缓存是以行为单位来读取更新的，一般一个缓存行的大小是64字节
	 * 可以看到两次访问的时间相差很小，这是因为16*4=64，第一个循环一次读取64子节的数据到缓存行，遍历16次，第二个循环也是一次读取一个缓存行，
	 * 遍历一次 而CPU访问缓存行是很快的，所以两个时间相差不大
	 * 
	 * reference http://coolshell.cn/articles/10249.html
	 */
	@Test
	public void t1() {
		int arr[] = new int[64 * 1024 * 1024];
		long start = System.currentTimeMillis();
		for (int i = 0; i < arr.length; i++)
			arr[i] *= 3;

		System.out.println(System.currentTimeMillis() - start);
		start = System.currentTimeMillis();
		for (int i = 0; i < arr.length; i += 16)
			arr[i] *= 3;
		System.out.println(System.currentTimeMillis() - start);
	}
}
