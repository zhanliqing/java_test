package com.zlq.leetcode.stack;

/**
 * Created by liqing.zhan on 2017/8/24.
 */
public class Valid_Parentheses_20_easy {
    public static void main(String[] args) {
        String p = "()()(){([])}";
        System.out.println(Solution.isValid(p));
    }

    static class Solution {
        public static boolean isValid(String s) {

            char[] c = new char[s.length()];
            int top = -1;
            for (int i = 0; i < s.length(); i++) {
                if (top < 0) {
                    c[++top] = s.charAt(i);
                } else {
                    if ((c[top] == '(' && s.charAt(i) == ')') ||
                            (c[top] == '[' && s.charAt(i) == ']') ||
                            (c[top] == '{' && s.charAt(i) == '}')) {
                        top--;
                    } else {
                        c[++top] = s.charAt(i);
                    }

                }

            }
            return top == -1;
        }
    }
}
