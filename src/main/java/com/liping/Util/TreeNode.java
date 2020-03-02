package com.liping.Util;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode(int x) { val = x; }

    public static TreeNode build(int[] nums){
        return buildPos(nums, 0, nums.length);
    }

    private static TreeNode buildPos(int[] nums, int pos, int nLen){
        if(pos > nLen) return null;
        TreeNode node = new TreeNode(nums[pos]);
        int left = 2 * pos + 1, right = 2 * pos + 2;
        if(left < nLen) node.left = buildPos(nums, left, nLen);
        if(right < nLen) node.right = buildPos(nums, right, nLen);
        return node;
    }

    public static String preScan(TreeNode tree){
        if(tree == null) return "";
        return preScan(tree.left) + tree.val + preScan(tree.right);
    }

    public static String inScan(TreeNode tree){
        if(tree == null) return "";
        return tree.val + inScan(tree.left) + inScan(tree.right);
    }

    public static String afterScan(TreeNode  tree){
        if(tree == null) return "";
        return afterScan(tree.left) + afterScan(tree.right) + tree.val;
    }
}
