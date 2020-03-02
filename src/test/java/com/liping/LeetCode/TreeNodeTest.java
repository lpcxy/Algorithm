package com.liping.LeetCode;

import com.liping.Util.TreeNode;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class TreeNodeTest {

    @Test
    public void testBuild() {
        TreeNode node = TreeNode.build(new int[]{1,2,3});
        System.out.println(node);
    }

    @Test
    public void testPreScan() {
        TreeNode node = TreeNode.build(new int[]{1,2,3});
        assertThat(TreeNode.preScan(node)).isEqualTo("213");
    }

    @Test
    public void testInScan() {
        TreeNode node = TreeNode.build(new int[]{1,2,3});
        assertThat(TreeNode.inScan(node)).isEqualTo("123");
    }

    @Test
    public void testAfterScan() {
        TreeNode node = TreeNode.build(new int[]{1,2,3});
        assertThat(TreeNode.afterScan(node)).isEqualTo("231");
    }
}