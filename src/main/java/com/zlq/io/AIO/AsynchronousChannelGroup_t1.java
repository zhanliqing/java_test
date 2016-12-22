package com.zlq.io.AIO;

import org.junit.Test;

import java.io.IOException;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.Executors;

/**
 * Created by liqing.zhan on 2016/9/10.
 */
public class AsynchronousChannelGroup_t1 {
	@Test
	public void t1() throws IOException {
		AsynchronousChannelGroup group = AsynchronousChannelGroup.withCachedThreadPool(Executors.newCachedThreadPool(),
				30);
		AsynchronousServerSocketChannel serverSocketChannel = AsynchronousServerSocketChannel.open(group);
	}

	@Test
	public void t2() throws IOException {
		AsynchronousChannelGroup group = AsynchronousChannelGroup.withFixedThreadPool(30,
				Executors.defaultThreadFactory());
	}
}
