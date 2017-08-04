package com.zlq.base;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

/**
 * Created by liqing.zhan on 2017/1/22.
 */
public class JvisualVMTest {
    public static void main(String[] args) throws InterruptedException, IOException {
        JvisualVMTest test = new JvisualVMTest();
        while (true) {
            test.c();
            TimeUnit.MILLISECONDS.sleep(300);
            System.out.println("dd");
            int d = test.d();
            System.out.println(d);
        }
    }

    public void c() throws InterruptedException, IOException {
        a();
        b();
        e();
        TimeUnit.MILLISECONDS.sleep(100);
    }

    public void a() throws InterruptedException, IOException {
        HttpClient client = HttpClients.createDefault();
        HttpGet get = new HttpGet("http://www.baidu.com");

        HttpResponse response = client.execute(get);
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String s;
        while ((s = reader.readLine()) != null) {
            System.out.println(s);
        }
    }

    public void b() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(200);
    }

    public void e() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(200);
    }

    public int d() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(1000);
        return 1;
    }
}
