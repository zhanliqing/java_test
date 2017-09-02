package com.zlq.leetcode.BitManipulation;

/**
 * Created by liqing.zhan on 2017/8/22.
 */
public class Find_the_Difference_389_easy {
    public static void main(String[] args) {
        String s = "abcd";
        String t = "abcde";
        System.out.println(Solution.findTheDifference1(s, t));
    }

    static class Solution {

        public static char findTheDifference1(String s, String t) {
            int a = 0;
            for (int i = 0; i < s.length(); i++) {
                a ^= (int) s.charAt(i);
            }
            for (int j = 0; j < t.length(); j++) {
                a ^= (int) t.charAt(j);
            }
            return (char) a;
        }

        /**
         * fuck
         *
         * @param s
         * @param t
         * @return
         */
        public static char findTheDifference(String s, String t) {
            int len = Math.min(s.length(), t.length());
            for (int i = 0; i < len; i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    if (len == s.length()) {
                        return t.charAt(i);
                    } else {
                        return s.charAt(i);
                    }
                }
            }
            if (len == t.length()) {
                return s.charAt(s.length() - 1);
            } else {
                return t.charAt(t.length() - 1);
            }
        }
    }
}
