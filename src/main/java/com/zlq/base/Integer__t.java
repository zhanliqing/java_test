package com.zlq.base;

import org.junit.Test;

/**
 * Created by liqing.zhan on 2016/8/6.
 */
public class Integer__t {
    @Test
    public void isEquals() {
        Integer integer = new Integer(10);
        Integer integer1 = new Integer(10);
        Integer integer2 = new Integer(10);
        System.out.println(integer == integer1);
        System.out.println(integer1 == integer2);
    }

    @Test
    public void isEquals1() {
        Integer i1 = 10;
        Integer i2 = 10;
        System.out.println(i1 == i2);
    }

    @Test
    public void doubleTOint() {
        int a = 5;
        double b = 0.4;

        System.out.println(b+a);
        int c = (int) (b + a);
        System.out.println(Math.ceil(a+b));
    }
}
