package com.zlq.String;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by liqing.zhan on 2017/8/10.
 */
public class Regex1 {
    public static void main(String[] args) {
        String regex = "([0-9]+):\\[f([0-9]+)<([0-9\\-\\+\\.e]+)\\]\\syes=([0-9]+),no=([0-9]+),missing=([0-9]+)";

        String s1 = "451:[f1988<5.6912e+06] yes=853,no=854,missing=854";
        Pattern pt = Pattern.compile(regex);
        Matcher mt = pt.matcher(s1);
        while (mt.find()) {
            int i = mt.groupCount();
            for (int j = 1; j <= i; j++) {
                System.out.println(mt.group(j));
            }
        }
    }
}
