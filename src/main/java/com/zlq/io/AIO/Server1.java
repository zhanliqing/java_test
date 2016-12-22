package com.zlq.io.AIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by liqing.zhan on 2016/9/10.
 */
public class Server1 {
    private Thread currentThread;

    public static void main(String... arg) throws IOException, InterruptedException {
        new Server1().go();

    }

    private void go() throws IOException, InterruptedException {

        AsynchronousChannelGroup group = AsynchronousChannelGroup.withFixedThreadPool(20,
                Executors.defaultThreadFactory());

        final AsynchronousServerSocketChannel serverSocketChannel = AsynchronousServerSocketChannel.open(group)
                .bind(new InetSocketAddress("127.0.0.1", 8080));

        final String att1 = "First connection";
        Thread currentThread = Thread.currentThread();

        serverSocketChannel.accept(att1, new CompletionHandler<AsynchronousSocketChannel, String>() {
            @Override
            public void completed(AsynchronousSocketChannel result, String attachment) {
                System.out.println("Completed: " + attachment);
                String msg = handleConnection(result);
                if (msg.equals("Bye")) {
                    if (!group.isTerminated()) {
                        System.out.println("Terminating the group...");
                        try {
                            group.shutdownNow();
                            group.awaitTermination(10, TimeUnit.SECONDS);
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        currentThread.interrupt();
                    }
                } else {
                    System.out.println(msg);
                }
                attachment = "Next connection";
                System.out.println("Waiting for - " + attachment);
                serverSocketChannel.accept(attachment, this);
            }

            @Override
            public void failed(Throwable exc, String attachment) {
                System.out.println(attachment + " - handler failed");
                exc.printStackTrace();
                currentThread.interrupt();
            }
        });

        currentThread.join();
        System.out.println("Exiting the server");
    }

    private static String handleConnection(AsynchronousSocketChannel ch) {
        ByteBuffer buffer = ByteBuffer.allocate(32);
        Future result = ch.read(buffer);
        while (!result.isDone()) ;
        buffer.flip();
        String msg = new String(buffer.array()).trim();
        System.out.println("Message from client: " + msg);
        buffer.clear();
        return msg;
    }
}
