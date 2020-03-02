package com.liping.LeetCode;

import com.liping.Util.HandleTestCaseInput;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class Solution20200302Test {
    private Solution20200302 solution = new Solution20200302();

    @Test
    public void testSpiralOrder() {
        assertThat(solution.spiralOrder(HandleTestCaseInput.INSTANCE.getMatrix("[[1,2,3],[4,5,6],[7,8,9]]"))).
                isEqualTo(HandleTestCaseInput.INSTANCE.getList("[1,2,3,6,9,8,7,4,5]"));
        assertThat(solution.spiralOrder(HandleTestCaseInput.INSTANCE.getMatrix("[[1,2,3,4],[5,6,7,8],[9,10,11,12]]"))).
                isEqualTo(HandleTestCaseInput.INSTANCE.getList("[1,2,3,4,8,12,11,10,9,5,6,7]"));
        assertThat(solution.spiralOrder(HandleTestCaseInput.INSTANCE.getMatrix("[[3],[2]]"))).
                isEqualTo(HandleTestCaseInput.INSTANCE.getList("[3,2]"));
        assertThat(solution.spiralOrder(HandleTestCaseInput.INSTANCE.getMatrix("[[1]]"))).
                isEqualTo(HandleTestCaseInput.INSTANCE.getList("[1]"));
    }

    @Test
    public void testValidateStackSequences() {
        assertThat(solution.validateStackSequences(HandleTestCaseInput.INSTANCE.getList("[1,2,3,4,5]"),
                HandleTestCaseInput.INSTANCE.getList("[4,5,3,2,1]"))).isTrue();
        assertThat(solution.validateStackSequences(HandleTestCaseInput.INSTANCE.getList("[1,2,3,4,5]"),
                HandleTestCaseInput.INSTANCE.getList("[4,3,5,1,2]"))).isFalse();
    }
}