package com.zlq.guava.event;

/**
 * Created by liqing.zhan on 2016/11/2.
 */
public class FieldTest<T> {
    T t;

    public void setT(T t) {
        this.t = t;
    }

    static class Main {
        public static void main(String... args) {
            FieldTest test = new FieldTest();
            test.setT(1);
            System.out.println(test.t.getClass() == Integer.class);
        }
    }
}



