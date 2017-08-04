package com.zlq.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by liqing.zhan on 2016/12/29.
 */
public class NioServer {
	public static void main(String[] args) throws IOException {
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		serverSocketChannel.configureBlocking(false);
		ServerSocket serverSocket = serverSocketChannel.socket();
		serverSocket.setReuseAddress(true);
		serverSocket.bind(new InetSocketAddress(8989));

		Selector selector = Selector.open();
		SelectionKey selectionKey = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

		while (true) {
			selector.select();
			Set<SelectionKey> selectionKeys = selector.selectedKeys();
			Iterator<SelectionKey> iterator = selectionKeys.iterator();
			while (iterator.hasNext()) {
				SelectionKey key = iterator.next();
				if (key.isAcceptable()) {
					System.out.println("accept");
					ServerSocketChannel channel = (ServerSocketChannel) key.channel();
					SocketChannel socketChannel = channel.accept();
					socketChannel.configureBlocking(false);
					socketChannel.register(selector, SelectionKey.OP_READ);
					System.out.println("Got connection from " + channel);
				} else if (key.isReadable()) {
					SocketChannel socketChannel = (SocketChannel) key.channel();
					ByteBuffer buffer = ByteBuffer.allocate(1024);
					int c = socketChannel.read(buffer);
					buffer.flip();
					while (c > 0) {
						byte b[] = new byte[buffer.remaining()];
						buffer.get(b);
						System.out.println(new String(b));
						c = socketChannel.read(buffer);
					}
					buffer.flip();
					socketChannel.write(buffer);
				} else if (key.isWritable()) {

				} else {
				}
				iterator.remove();
			}
		}
	}
}
