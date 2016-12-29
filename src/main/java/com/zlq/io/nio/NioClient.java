package com.zlq.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by liqing.zhan on 2016/12/29.
 */
public class NioClient {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        Socket socket = socketChannel.socket();
        socket.setReuseAddress(true);
        socket.setReceiveBufferSize(1024);
        socket.setSendBufferSize(1024);
        boolean isconn = socketChannel.connect(new InetSocketAddress("localhost", 8989));
        Selector selector = Selector.open();

        if (isconn) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            String message = "hello";
            buffer.put(message.getBytes());
            socketChannel.write(buffer);
            socketChannel.register(selector, SelectionKey.OP_READ);
            System.out.println("connect ");
        } else {
            socketChannel.register(selector, SelectionKey.OP_CONNECT);
        }

        while (true) {
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                SocketChannel channel = (SocketChannel) selectionKey.channel();

                if (selectionKey.isConnectable()) {
                    if (channel.finishConnect()) {
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        String message = "hello";
                        buffer.put(message.getBytes());
                        socketChannel.write(buffer);
                        System.out.println("conn");
                    }

                } else if (selectionKey.isReadable()) {
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    channel.read(buffer);
                    System.out.println(new String(buffer.array()));
                }
                iterator.remove();
            }
        }
    }
}
