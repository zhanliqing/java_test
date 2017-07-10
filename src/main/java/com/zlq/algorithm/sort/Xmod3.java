package com.zlq.algorithm.sort;

/**
 * Created by liqing.zhan on 2017/5/2.
 */
public class Xmod3 {
    public static void main(String[] args) {

        String x = "101010101000010110110001101010001100101010101011010010101101100101";
        int m = mod(x);
        System.out.println(m);
    }

    private static int mod(String x) {
        int len = x.length();

        int mod = 0;

        int s = 1;

        for (int i = len - 1; i >= 0; i--) {
            if (x.charAt(i) == '1') {
                mod += s;
                if (mod >= 3) {
                    mod -= 3;
                }
            }
            s += 1;

            if (s == 3) {
                s = 1;
            }
        }

        return mod;
    }
}
