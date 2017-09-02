package com.zlq.leetcode.stack;

/**
 * Created by liqing.zhan on 2017/8/24.
 */
public class Trapping_Rain_Water_42_hard {
    public static void main(String[] args) {
        int t[] = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(Solution.trap(t));
    }

    static class Solution {
        public static int trap(int[] height) {
            int[] t = new int[height.length];
            int top = -1;

            int nmax = -1;

            int value = 0;
            for (int i = 0; i < height.length; i++) {
                if (top == -1) {
                    t[++top] = height[i];
                    nmax = t[top];
                    continue;
                }

                if (height[i] < nmax || nmax == 0) {
                    if (nmax == 0) {
                        nmax = height[i];
                    }
                    t[++top] = height[i];
                } else {
                    //calc
                    while (top >= 0 && t[top] < nmax) {
                        value += (nmax - t[top]);
                        top--;
                    }

                    top = 0;
                    t[top] = height[i];
                    nmax = t[top];
                }

                int tt[] = new int[top + 1];
                i = 0;
                while (top >= 0 && t[top] <= nmax) {
                    tt[top] = t[i];
                    top--;
                }
                value += trap(tt);
            }
            return value;
        }
    }

}
