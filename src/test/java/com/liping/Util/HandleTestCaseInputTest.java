package com.liping.Util;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class HandleTestCaseInputTest {

    @Test
    public void testGetList(){
        assertThat(HandleTestCaseInput.INSTANCE.getList("[1,2,3]")).isEqualTo(new int[]{1,2,3});
        assertThat(HandleTestCaseInput.INSTANCE.getList("[1,2]")).isEqualTo(new int[]{1,2});
    }

    @Test
    public void testGetMatrix() {
        assertThat(HandleTestCaseInput.INSTANCE.getMatrix("[[1,2,3],[4,5,6]]")).isEqualTo(new int[][]{{1,2,3},{4,5,6}});
        assertThat(HandleTestCaseInput.INSTANCE.getMatrix("[[1,2,3]]")).isEqualTo(new int[][]{{1,2,3}});
        assertThat(HandleTestCaseInput.INSTANCE.getMatrix("[[1, 2, 3]]")).isEqualTo(new int[][]{{1,2,3}});
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testGetMatrixException(){
        assertThat(HandleTestCaseInput.INSTANCE.getMatrix("[abc]")).isEqualTo(new int[][]{{1,2,3}});
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testGetMatrixException2(){
        assertThat(HandleTestCaseInput.INSTANCE.getMatrix("[1,2,3]")).isEqualTo(new int[][]{{1,2,3}});
    }

    @Test
    public void testCheckMatrixInput() {
        assertThat(HandleTestCaseInput.INSTANCE.checkMatrixInput("[[")).isFalse();
        assertThat(HandleTestCaseInput.INSTANCE.checkMatrixInput("[[]]")).isFalse();
        assertThat(HandleTestCaseInput.INSTANCE.checkMatrixInput("[[1,2,3]]")).isTrue();
        assertThat(HandleTestCaseInput.INSTANCE.checkMatrixInput("[[1,2,3],[4,5,5]]")).isTrue();
        assertThat(HandleTestCaseInput.INSTANCE.checkMatrixInput("[[1,2,3],[4,5,5],[7,8,9]]")).isTrue();
    }

    @Test
    public void testParseFormat() {
        assertThat(HandleTestCaseInput.INSTANCE.parseFormat(3, "1,2,3")).isEqualTo(new int[]{1,2,3});
    }

    @Test
    public void testGetPatternMatcherList() {
        assertThat(HandleTestCaseInput.INSTANCE.getPatternMatcherList("[[1,2,3],[4,5,6]]","\\d[,\\d]*"))
                .contains("1,2,3").contains("4,5,6");
    }
}