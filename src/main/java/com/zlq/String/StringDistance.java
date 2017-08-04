package com.zlq.String;


import org.apache.commons.lang3.StringUtils;

import java.util.Locale;

/**
 * Created by liqing.zhan on 2017/6/29.
 */
public class StringDistance {
    public static void main(String[] args) {
        String s1 = "北京市海淀区苏州街";
        String s2 = "北京市朝阳区苏州街";

        String s3 = "北京市海朝区苏州街";

        System.out.println(StringUtils.getFuzzyDistance(s1, s2, Locale.CHINA));
        System.out.println(StringUtils.getLevenshteinDistance(s1, s2));

        System.out.println(StringUtils.getJaroWinklerDistance(s1, s2));
        System.out.println(StringUtils.getJaroWinklerDistance(s2, s3));


        String n1 = "MARTHA";
        String n2 = "MARHTA";
        System.out.println(StringUtils.getJaroWinklerDistance(n1, n2));
        System.out.println(StringUtils.getJaroWinklerDistance("战立青", "立青战"));

        System.out.println(StringUtils.getFuzzyDistance("qing", "qing", Locale.ENGLISH));
    }
}
