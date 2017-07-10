package com.zlq.algorithm.sort;

import java.util.Random;

/**
 * 最长公共子序列
 * Created by liqing.zhan on 2017/5/4.
 */
public class LCS {
    public static void main(String[] args) {
        String s1 = genString(5);
        String s2 = genString(10);

        System.out.println(s1);
        System.out.println(s2);
        int[][] m = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i < s1.length(); i++) {
            m[i][s2.length()] = 0;
        }

        for (int i = 0; i < s2.length(); i++) {
            m[s1.length()][i] = 0;
        }

        for (int i = s1.length() - 1; i >= 0; i--) {
            for (int j = s2.length() - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    m[i][j] = 1 + m[i + 1][j + 1];
                } else {
                    m[i][j] = Math.max(m[i + 1][j], m[i][j + 1]);
                }
            }
        }

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                System.out.print(m[i][j] + "   ");
            }
            System.out.println();
        }
        System.out.println(m[0][0]);

        int i = 0, j = 0;

        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                System.out.print(s1.charAt(i));
                i++;
                j++;
            } else {
                if (m[i + 1][j] >= m[i][j + 1]) {
                    i++;
                } else {
                    j++;
                }
            }
        }
    }

    public static String genString(int n) {
        Random random = new Random();
        char[] c = new char[n];

        for (int i = 0; i < n; i++) {
            int next = random.nextInt(26) + 97;
            c[i] = (char) next;
        }

        return String.valueOf(c);
    }
}
