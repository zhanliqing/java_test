package com.zlq.io.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by liqing.zhan on 2016/11/8.
 */
public class S1 implements Serializable {
    public int age;

    static class Main {
        public static void main(String[] args) throws IOException, ClassNotFoundException {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("d://abc/tt")));
            S2 s2 = new S2();
            s2.age = 10;
            s2.name = "test";
            objectOutputStream.writeObject(s2);

            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(new File("d://abc/tt")));
            S2 s21 = (S2) inputStream.readObject();
            System.out.println(s21.age);
            System.out.println(s21.name);
        }
    }
}

class S2 extends S1 implements Serializable {
    public String name;
}

