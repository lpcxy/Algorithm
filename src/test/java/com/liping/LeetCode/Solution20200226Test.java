package com.liping.LeetCode;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class Solution20200226Test {
    private Solution20200226 solution = new Solution20200226();

    @Test
    public void testCuttingRope() {
        assertThat(solution.cuttingRope(8)).isEqualTo(18);
        assertThat(solution.cuttingRope(2)).isEqualTo(1);
        assertThat(solution.cuttingRope(10)).isEqualTo(36);
    }

    @Test
    public void testIsSubStructure() {
        assertThat(solution.isSubStructure(TreeNode.build(new int[]{1,2,3}), TreeNode.build(new int[]{3,1}))).isFalse();
        assertThat(solution.isSubStructure(TreeNode.build(new int[]{3,4,5,1,2}), TreeNode.build(new int[]{4,1}))).isTrue();
        assertThat(solution.isSubStructure(TreeNode.build(new int[]{1,2,3,4}), TreeNode.build(new int[]{3}))).isTrue();
        assertThat(solution.isSubStructure(TreeNode.build(new int[]{1,0,1,-4,-3}), TreeNode.build(new int[]{1,-4}))).isFalse();

    }

    @Test
    public void testIsSubStructureHead() {
        assertThat(solution.isSubStructureHead(TreeNode.build(new int[]{1,2,3}), TreeNode.build(new int[]{1,2}))).isTrue();
        assertThat(solution.isSubStructureHead(TreeNode.build(new int[]{1,2,3}), TreeNode.build(new int[]{1,4}))).isFalse();
    }
}