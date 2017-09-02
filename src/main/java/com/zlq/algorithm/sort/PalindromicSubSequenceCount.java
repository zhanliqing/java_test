package com.zlq.algorithm.sort;

/**
 * 最长回文子序列个数 递归
 * <p>
 * * Created by liqing.zhan on 2017/8/28.
 */
public class PalindromicSubSequenceCount {
    public static int count(String s) {
        return count(s, 0, s.length() - 1);
    }

    public static int count(String s, int i, int j) {
        if (j < i) {
            return 0;
        }
        if (i == j) {
            return 1;
        }

        int c;
        if (s.charAt(i) == s.charAt(j)) {
            c = count(s, i + 1, j) + count(s, i, j - 1) + 1;
        } else {
            c = count(s, i + 1, j) + count(s, i, j - 1) - count(s, i + 1, j - 1);
        }
        return c;
    }

    public static void main(String[] args) {
        String s = "aba";
        System.out.println(count(s));
    }
}
