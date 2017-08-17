package com.zlq.algorithm.sort;

/**
 * 最长回文的长度
 * <p>
 * Created by zhanliqing on 2017/8/7.
 */
public class HuiwenLength {
    public static void main(String[] args) {
        String s = "abcdcba";
        System.out.println(length(s));
    }

    public static int length(String s) {
        int n = s.length() - 1;
        boolean isHuiWen[][] = new boolean[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            isHuiWen[i][i] = true;

        }

        int skip = 0;
        while (skip++ <= n) {
            for (int i = 0; i <= n - 1; i++) {
                if (skip == 1) {
                    if (s.charAt(i) == s.charAt(i + skip)) {
                        isHuiWen[i][i + skip] = true;
                    } else {
                        isHuiWen[i][i + skip] = false;
                    }
                } else if (i + skip <= n) {
                    if (isHuiWen[i + 1][i + skip - 1] && (s.charAt(i) == s.charAt(i + skip))) {
                        isHuiWen[i][i + skip] = true;
                    } else {
                        isHuiWen[i][i + skip] = false;
                    }
                } else continue;
            }
        }


        for (int i = 0; i <= n; i++) {
            for (int r = 0; r < i; r++) {
                System.out.print(String.format("%7s", ""));
            }
            for (int j = i; j <= n; j++) {
                System.out.print(String.format("%7s", String.valueOf(isHuiWen[i][j])));
            }

            System.out.println();
        }

        return 0;
    }
}
