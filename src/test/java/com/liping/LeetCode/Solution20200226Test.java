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
}