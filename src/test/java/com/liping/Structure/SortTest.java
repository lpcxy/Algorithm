package com.liping.Structure;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class SortTest {

    @Test
    public void testSwap() {
        int[] nums = new int[]{1,2,3};
        Sort.INSTANCE.swap(nums, 0, 1);
        assertThat(nums).isEqualTo(new int[]{2,1,3});
    }

    @Test
    public void testInsertSort() {
        assertTestCase(nums -> Sort.INSTANCE.insertSort(nums));
    }

    @Test
    public void testSelectSort() {
        assertTestCase(nums -> Sort.INSTANCE.selectSort(nums));
    }

    private void assertTestCase(SortFunction assertTestCase) {
        Map<Object, Object> map = TestData.INSTANCE.getSortTestData();
        for(Object key : map.keySet()){
            int[] nums = (int[])key;
            assertTestCase.sort(nums);
            assertThat(nums).isEqualTo((int[])map.get(key));
        }
    }

    @Test
    public void testBubbleSort() {
        assertTestCase(nums -> Sort.INSTANCE.bubbleSort(nums));
    }

    @Test
    public void testMergeSort() {
        assertTestCase(nums -> Sort.INSTANCE.mergeSort(nums));
    }

    @Test
    public void testGetIndex() {
        int[] nums = {3, 1, 6, 8,2};
        int result = Sort.INSTANCE.getIndex(nums, 0, nums.length - 1);
        System.out.println(result);
        Arrays.stream(nums).forEach(System.out::println);
    }

    @Test
    public void testQuickSort() {
        assertTestCase(nums -> Sort.INSTANCE.quickSort(nums));
    }

    @Test
    public void testShellSort() {
        assertTestCase(nums -> Sort.INSTANCE.shellSort(nums));
    }

    @Test
    public void testInsertSortEachIdx() {
        int[] nums = {3, 1, 6, 8,2};
        Sort.INSTANCE.insertSortEachIdx(nums, 2);
        Arrays.stream(nums).forEach(System.out::println);
    }

    @Test
    public void testHeapSort() {
        assertTestCase(nums -> Sort.INSTANCE.heapSort(nums));
    }

    @Test
    public void testBuildHeap() {
        int[] nums = {3, 1, 6, 8,2};
        Sort.INSTANCE.buildHeap(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }

    @Test
    public void testDownRefresh() {
        int[] nums = {3, 1, 6, 8,2};
        Sort.INSTANCE.downRefresh(nums, 0, 4);
        Arrays.stream(nums).forEach(System.out::println);
    }

    @Test
    public void testBucketSort() {
        assertTestCase(nums -> Sort.INSTANCE.bucketSort(nums));
    }

    @Test
    public void testCountSort() {
        assertTestCase(nums -> Sort.INSTANCE.countSort(nums));
    }

    @Test
    public void testFindMaxLen() {
        assertThat(Sort.INSTANCE.findMaxLen(new int[]{1,10,100,200})).isEqualTo(3);
        assertThat(Sort.INSTANCE.findMaxLen(new int[]{1,10,100,200,1000})).isEqualTo(4);
    }

    @Test
    public void testRadixSort() {
        assertTestCase(nums -> Sort.INSTANCE.radixSort(nums));
    }
}