package com.zlq.leetcode;

/**
 * Created by zhanliqing on 2017/8/19.
 */
public class Judge_Route_Circle_657_Easy {
    public static void main(String[] args) {
        String move = "LD";
        System.out.println(Solution.judgeCircle(move));
    }

    static class Solution {
        public static boolean judgeCircle1(String moves) {
            int LR = 0;
            int DU = 0;
            int start = 0;
            while (start < moves.length()) {
                switch (moves.charAt(start++)) {
                    case 'U':
                        DU++;
                        break;
                    case 'D':
                        DU--;
                        break;
                    case 'L':
                        LR++;
                        break;
                    case 'R':
                        LR--;
                        break;
                    default:
                        throw new RuntimeException("error");
                }
            }
            return LR == 0 && DU == 0;
        }

        public static boolean judgeCircle(String moves) {
            int LC = 0;
            int RC = 0;
            int UC = 0;
            int DC = 0;

            for (int i = 0; i < moves.length(); i++) {
                switch (moves.charAt(i)) {
                    case 'L':
                        LC++;
                        break;
                    case 'R':
                        RC++;
                        break;
                    case 'U':
                        RC++;
                        break;
                    case 'D':
                        DC++;
                        break;
                }
            }

            return RC == LC && DC == UC;
        }
    }
}

