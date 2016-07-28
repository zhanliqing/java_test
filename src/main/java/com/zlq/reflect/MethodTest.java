package com.zlq.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by liqing.zhan on 2016/7/27.
 */
public class MethodTest {

    public static void main(String args[])
            throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        fieldGet();
    }

    public static void fieldGet()
            throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Method field = MethodTest.class.getDeclaredMethod("getT");
        System.out.println(field.invoke(MethodTest.class, null));
    }

    public static String getT() {
        return "aa";
    }
}
