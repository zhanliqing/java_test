package com.zlq.io.AIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by liqing.zhan on 2016/9/10.
 */
public class Client1 {

	public static void main(String[] args) throws Exception {

		new Client1().go();
	}

	private void go() throws IOException, InterruptedException, ExecutionException {

		AsynchronousSocketChannel client = AsynchronousSocketChannel.open();
		InetSocketAddress hostAddress = new InetSocketAddress("127.0.0.1", 8080);
		Future future = client.connect(hostAddress);
		future.get(); // returns null

		System.out.println("Client is started");
		System.out.println("Sending message to server: ");
		byte[] bytes = new String("Bye").getBytes();
		ByteBuffer buffer = ByteBuffer.wrap(bytes);
		Future result = client.write(buffer);

		while (!result.isDone()) {
			System.out.println("... ");
		}

		System.out.println(new String(buffer.array()).trim());
		buffer.clear();
		client.close();
	}
}
