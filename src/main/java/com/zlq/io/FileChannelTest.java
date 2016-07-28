package com.zlq.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by liqing.zhan on 2016/7/22.
 */
public class FileChannelTest {
    public static void main(String args[]) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File("d://abc/step1"));
        FileChannel fileChannel = fileInputStream.getChannel();

        FileOutputStream fileOutputStream = new FileOutputStream(new File("d://abc/b.txt"));
        FileChannel fileChannelOut = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(4096);
        int count = 0;
        fileChannel.lock();
        while ((count = fileChannel.read(byteBuffer)) != -1) {
            byteBuffer.flip();
            fileChannelOut.write(byteBuffer);
            byteBuffer.clear();
        }

        fileChannel.close();
        fileChannelOut.close();
    }
}
