package com.zlq.base.string;

/**
 * Created by liqing.zhan on 2017/3/3.
 */
public class InternTest2 {
    public static void main(String[] args) {
        String name = "aaaa";
        System.out.println(name.intern() == name);
        System.out.println(name.intern().equals(name));

        String name1 = new String(name);
        System.out.println(name1 == name);
        System.out.println(name == name1.intern());
        System.out.println(name1 == name1.intern());
        System.out.println(name == p(name1.intern()));
    }


    public static String p(String s) {
        return s;
    }
}
