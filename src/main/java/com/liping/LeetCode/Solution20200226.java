package com.liping.LeetCode;

import com.liping.Util.TreeNode;

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

    /**
     * 面试题26. 树的子结构
     * https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
     * */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null || B == null) return false;
        boolean leftOrRight = isSubStructure(A.left, B) || isSubStructure(A.right, B);
        if(A.val != B.val) return leftOrRight;
        else{
            boolean result = isSubStructureHead(A.left, B.left) && isSubStructureHead(A.right, B.right);
            return result || leftOrRight;
        }
    }

    public boolean isSubStructureHead(TreeNode A, TreeNode B){
        if(B == null) return true;
        if(A == null) return false;
        return A.val == B.val && isSubStructureHead(A.left, B.left) && isSubStructureHead(A.right, B.right);
    }
}
