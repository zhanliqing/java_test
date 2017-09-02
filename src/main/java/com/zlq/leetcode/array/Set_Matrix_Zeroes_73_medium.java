package com.zlq.leetcode.array;


import java.util.Random;

/**
 * 今日头条面试题
 * <p>
 * * 一个二维数组，元素是整数
 * <p>
 * 要求把0所在的行和列都变为0
 * <p>
 * Created by liqing.zhan on 2017/8/28.
 */
public class Set_Matrix_Zeroes_73_medium {
    public static void main(String[] args) {
        int matrix[][] = new int[4][5];
        Solution.init(matrix);
        Solution.print(matrix);
        Solution.setZeroes1(matrix);
        Solution.print(matrix);
    }

    static class Solution {
        /**
         * 根据第一种解法，可以考虑把行列存在矩阵的某一行某一列
         *
         * @param matrix
         */

        public static void setZeroes1(int[][] matrix) {
            boolean row = false; //标示第0行是否有0
            boolean clolum = false; //标示第0列是否有0
            for (int i = 0; i < matrix[0].length; i++) {
                if (matrix[0][i] == 0) {
                    row = true;
                    break;
                }
            }

            for (int j = 0; j < matrix.length; j++) {
                if (matrix[j][0] == 0) {
                    clolum = true;
                    break;
                }
            }

            if (matrix.length > 1 && matrix[0].length > 1) {
                for (int i = 1; i < matrix.length; i++) {
                    for (int j = 1; j < matrix[0].length; j++) {
                        if (matrix[i][j] == 0) {
                            matrix[0][j] = 0;
                            matrix[i][0] = 0;
                        }
                    }
                }
            }

            for (int i = 1; i < matrix.length; i++) {
                if (matrix[i][0] == 0) {
                    for (int r = 0; r < matrix[0].length; r++) {
                        matrix[i][r] = 0;
                    }
                }
            }

            for (int i = 1; i < matrix[0].length; i++) {
                if (matrix[0][i] == 0) {
                    for (int r = 0; r < matrix.length; r++) {
                        matrix[r][i] = 0;
                    }
                }
            }

            if (row) {
                for (int i = 0; i < matrix[0].length; i++) {
                    matrix[0][i] = 0;
                }
            }
            if (clolum) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][0] = 0;
                }
            }
        }


        /**
         * 定义一个行+列长度的数组，标示哪一行那一列有0值，最后扫描一遍设置为0
         *
         * @param matrix
         */
        public static void setZeroes(int[][] matrix) {
            boolean len[] = new boolean[matrix.length + matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] == 0) {
                        len[i] = true;
                        len[j + matrix.length] = true;
                    }
                }
            }

            for (int i = 0; i < len.length; i++) {
                if (len[i] == false) {
                    continue;
                }
                if (i < matrix.length) {
                    for (int j = 0; j < matrix[i].length; j++) {
                        matrix[i][j] = 0;
                    }
                } else {
                    int t = i - matrix.length;
                    for (int r = 0; r < matrix.length; r++) {
                        matrix[r][t] = 0;
                    }
                }
            }
        }

        public static void print(int[][] matrix) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    System.out.print(matrix[i][j] + "\t");
                }
                System.out.println();
            }
        }

        public static void init(int[][] matrix) {
            Random random = new Random();

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = random.nextInt(10000) % 10;
                }
            }
        }


    }
}
