package com.zlq.reflect;

/**
 * Created by liqing.zhan on 2016/7/29.
 */
public class GetResourcePathUseClassOrClassLoader {
    public static void main(String args[]) {
        System.out.println(GetResourcePathUseClassOrClassLoader.class.getResource("/db/jdbc.properties"));
        System.out.println(GetResourcePathUseClassOrClassLoader.class.getResource("jdbc.properties"));
        System.out.println(GetResourcePathUseClassOrClassLoader.class.getResource("db/jdbc.properties"));
        System.out
                .println(GetResourcePathUseClassOrClassLoader.class.getClassLoader().getResource("db/jdbc.properties"));
        System.out.println(
                GetResourcePathUseClassOrClassLoader.class.getClassLoader().getResource("/db/jdbc.properties"));

        System.out.println(GetResourcePathUseClassOrClassLoader.class.getResource("/"));
        System.out.println(GetResourcePathUseClassOrClassLoader.class.getResource(""));
        System.out.println(GetResourcePathUseClassOrClassLoader.class.getClassLoader().getResource("com/zlq/reflect/jdbc.properties"));
        System.out.println(GetResourcePathUseClassOrClassLoader.class.getClassLoader().getResource("jdbc.properties"));
    }
}
