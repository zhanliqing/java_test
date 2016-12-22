package com.zlq.io.AIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.util.Date;

/**
 * Created by liqing.zhan on 2016/9/9.
 */
public class Server {
    public static void main(String args[]) throws IOException {
        AsynchronousServerSocketChannel serverSocket = AsynchronousServerSocketChannel.open();
        serverSocket.bind(new InetSocketAddress("127.0.0.1", 8080));
        serverSocket.setOption(StandardSocketOptions.SO_REUSEADDR, true);
        serverSocket.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {
            @Override
            public void completed(AsynchronousSocketChannel result, Object attachment) {
                System.out.println(Thread.currentThread().getName() + ": run in accept completed method");
                serverSocket.accept(null, this);
                handler(result);
            }

            @Override
            public void failed(Throwable exc, Object attachment) {

            }
        });
    }

    private static void handler(AsynchronousSocketChannel channel) {
        System.out.println(Thread.currentThread().getName() + ": run in handle method");
        final ByteBuffer readBuffer = ByteBuffer.allocateDirect(1024);
        readBuffer.clear();
        channel.read(readBuffer, null, new CompletionHandler<Integer, Object>() {
            @Override
            public void completed(Integer count, Object attachment) {
                System.out.println(Thread.currentThread().getName() + ": run in read completed method");
                if (count > 0) {
                    readBuffer.flip();
                    try {
                        CharBuffer charBuffer = Charset.forName("UTF-8").newDecoder().decode(readBuffer);
                        System.out.println(charBuffer.toString());
                        channel.write(Charset.forName("UTF-8").newEncoder().encode(CharBuffer.wrap(new Date().toString())));
                    } catch (CharacterCodingException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void failed(Throwable exc, Object attachment) {

            }
        });
    }
}
