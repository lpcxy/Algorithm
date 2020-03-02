package com.liping.LeetCode;

import java.util.Stack;

public class Solution20200302 {
    /**
     *面试题31. 栈的压入、弹出序列
     *https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/
     * */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int popPos = 0, pushPos = 0;
        while(pushPos < pushed.length || !stack.isEmpty()){
            if(pushPos < pushed.length) {
                stack.push(pushed[pushPos++]);
            }
            if(stack.peek() == popped[popPos]){
                stack.pop();
                popPos ++;
            }
        }
        return stack.isEmpty();
    }

    /**
     * 面试题29. 顺时针打印矩阵
     * https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
     * */
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return new int[]{};
        }
        int M = matrix.length, N = matrix[0].length, pos = 0, step = Math.min(M, N) / 2, resultLen = M * N;
        int[] result = new int[resultLen];
        for(int m = 0; m <= step; m++){
            for(int n = m; n <= N - m - 1 && pos < resultLen; n++){
                result[pos++] = matrix[m][n];
            }
            for(int n = m + 1; n < M - m - 1 && pos < resultLen; n++){
                result[pos++] = matrix[n][N - m - 1];
            }
            for(int n = N - m - 1; n > m && pos < resultLen; n--){
                result[pos++] = matrix[M - m - 1][n];
            }
            for(int n = M - m - 1; n > m && pos < resultLen; n--){
                result[pos++] = matrix[n][m];
            }
        }
        return result;
    }
}