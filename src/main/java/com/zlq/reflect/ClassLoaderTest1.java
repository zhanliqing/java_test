package com.zlq.reflect;

/**
 * Created by liqing.zhan on 2016/12/22.
 */
public class ClassLoaderTest1 {
    public static void main(String[] args) {
        Integer integer = new Integer(10);
        System.out.println(ClassLoaderTest1.class.getClassLoader().getClass().getName());
        //System.out.println(integer.getClass().getClassLoader().getClass().getName());

        System.out.println(integer.getClass().getClassLoader());
    }
}
