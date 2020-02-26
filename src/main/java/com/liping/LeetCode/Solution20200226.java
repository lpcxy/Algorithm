package com.liping.LeetCode;

public class Solution20200226 {
    /**
     * 面试题14- I. 剪绳子
     * https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
     * */
    public int cuttingRope(int n) {
        if(n == 2) return 1;
        int max = 0;
        for(int m = 2; m < n; m++) {
            int left = n % m;
            int s = (int)Math.pow((int)n / m, m - left) * (int)Math.pow((int)n / m + 1, left);
            if(s > max) max = s;
        }
        return max;
    }
}
