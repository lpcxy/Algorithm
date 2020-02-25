package com.liping.Structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Sort {
    INSTANCE;

    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    /**
     * 插入排序
     * */
    public void insertSort(int[] nums){
        if(nums == null) return;
        int nLen = nums.length;
        for(int i = 1; i < nLen; i++){
            int j = i, base = nums[i];
            while(j > 0 && nums[j - 1] > base){
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = base;
        }
    }

    /**
     * 选择排序
     * */
    public void selectSort(int[] nums){
        if(nums == null) return;
        int nLen = nums.length;
        for(int i = 0; i < nLen; i++){
            int minPos = i;
            for(int j = i + 1; j < nLen; j++){
                if(nums[j] < nums[minPos]){
                    minPos = j;
                }
            }
            swap(nums, i, minPos);
        }
    }

    /**
     * 冒泡排序
     * */
    public void bubbleSort(int[] nums){
        if(nums == null) return;
        int nLen = nums.length;
        for(int i = nLen - 1; i >= 0; i--){
            for(int j = 0; j < i; j++){
                if(nums[j] > nums[j + 1]){
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    /**
     * 归并排序
     * */
    public void mergeSort(int[] nums){
        if(nums == null) return;
        mergeSort(nums, 0, nums.length);
    }

    public void mergeSort(int[] nums, int begin, int end){
        int[] tmp = new int[nums.length];
        if(begin >= end || begin + 1 == end) return;
        int middle = (begin + end) / 2;
        mergeSort(nums, begin, middle);
        mergeSort(nums, middle, end);
        merge(nums, begin, middle, end, tmp);
    }

    public void merge(int[] nums, int begin, int middle, int end, int[] tmp){
        int start1 = begin, start2 = middle, start3 = begin;
        while(start1 < middle && start2 < end){
            if(nums[start1] < nums[start2]){
                tmp[start3 ++] = nums[start1++];
            }else{
                tmp[start3 ++] = nums[start2++];
            }
        }
        while(start1 < middle) tmp[start3 ++] = nums[start1++];
        while(start2 < end) tmp[start3 ++] = nums[start2++];
        for(int k = begin; k < end; k++){
            nums[k] = tmp[k];
        }
    }

    /**
     * 快速排序
     * */
    public void quickSort(int[] nums){
        if(nums == null) return;
        quickSort(nums, 0, nums.length - 1);
    }

    public void quickSort(int[] nums, int begin, int end){
        if(begin >= end) return;
        int index = getIndex(nums, begin, end);
        quickSort(nums, begin, index - 1);
        quickSort(nums, index + 1, end);
    }

    public int getIndex(int[] nums, int left, int right){
        int base = nums[left];
        while(left < right){
            while(left < right && nums[right] >= base) right--;
            if(left < right) {
                nums[left] = nums[right];
            }
            while(left < right && nums[left] <= base) left++;
            if(left < right){
                nums[right] = nums[left];
            }
        }
        nums[left] = base;
        return left;
    }

    /**
     * 希尔排序
     * */
    public void shellSort(int[] nums){
        if(nums == null) return;
        int idx = nums.length / 2;
        while(idx != 0){
            insertSortEachIdx(nums, idx);
            idx /= 2;
        }
    }

    public void insertSortEachIdx(int[] nums, int idx) {
        for(int j = idx; j < nums.length; j ++){
            int k = j, base = nums[j];
            while(k >= idx && nums[k - idx] > base){
                nums[k] = nums[k - idx];
                k = k - idx;
            }
            nums[k] = base;
        }
    }

    /**
     * 堆排序
     * */
    public void heapSort(int[] nums){
        int nLen = nums.length;
        if(nLen <= 1) return;
        buildHeap(nums);
        for(int i = nLen - 1; i > 0; i--){
            swap(nums, 0, i);
            downRefresh(nums, 0, i - 1);
        }
    }

    public void buildHeap(int[] nums){
        for(int k = nums.length - 1; k > 0; k--){
            int pos = k, parent = (pos - 1) / 2;
            while(pos != 0 && nums[parent] < nums[pos]){
                swap(nums, parent, pos);
                pos = parent;
                parent = (pos - 1) / 2;
            }
        }
    }

    public void downRefresh(int[] nums, int root, int leaf){
        int left = 2 * root + 1;
        int right = 2 * root + 2;
        while(left <= leaf){
            int nextRoot = left;
            if(right <= leaf && nums[right] > nums[left]){
                nextRoot = right;
            }
            if(nums[root] < nums[nextRoot]){
                swap(nums, root, nextRoot);
                root = nextRoot;
                left = 2 * root + 1;
                right = 2 * root + 2;
            }else{
                break;
            }
        }
    }

    /**
     * 桶排序
     * */
    public void bucketSort(int[] nums){
        int nLen = nums.length;
        if(nLen <= 1) return;
        int max = Arrays.stream(nums).reduce((x, y) -> Math.max(x, y)).getAsInt();
        int min = Arrays.stream(nums).reduce((x, y) -> Math.min(x, y)).getAsInt();
        int bucketSize = (max - min) / nLen + 1;
        List<List<Integer>> buckets = new ArrayList<>();
        for(int i = 0; i < bucketSize; i++){
            buckets.add(new ArrayList<>());
        }
        for(int i = 0; i < nLen; i++){
            buckets.get((nums[i] - min) / nLen).add(nums[i]);
        }
        for(int i = 0; i < bucketSize; i++){
            Collections.sort(buckets.get(i));
        }
        for(int i = 0, k = 0; i < bucketSize; i++){
            for(int j = 0; j < buckets.get(i).size(); j++) {
                nums[k++] = buckets.get(i).get(j);
            }
        }
    }

    /**
     * 计数排序
     * */
    public void countSort(int[] nums){
        int nLen = nums.length;
        if(nLen <= 1) return;
        int max = Arrays.stream(nums).reduce((x, y) -> Math.max(x, y)).getAsInt();
        int min = Arrays.stream(nums).reduce((x, y) -> Math.min(x, y)).getAsInt();
        int size = max - min + 1;
        int[] count = new int[size];
        for(int i = 0 ; i < nLen; i++){
            count[nums[i] - min] += 1;
        }
        for(int i = 0, k = 0; i < size; i++){
            for(int j = 0; j < count[i]; j++){
                nums[k ++ ] = min + i;
            }
        }
    }

    /**
     * 基数排序
     * */
    public void radixSort(int[] nums){
        int nLen = nums.length;
        if(nLen <= 1) return;
        int maxLen = findMaxLen(nums);
        int[][] tmp = new int[10][nLen];
        int[] tmpCount = new int[10];
        int m = 0, path =10;
        while(m < maxLen){
            for(int i = 0; i < nLen; i++){
                int key = nums[i] % path;
                tmp[key][tmpCount[key]++] = nums[i];
            }
            for(int i = 0, k = 0; i < 10; i++){
                for(int j = 0; j < tmpCount[i]; j++){
                    nums[k++] = tmp[i][j];
                }
            }
            m++;
            path *= 10;
        }
    }

    public int findMaxLen(int[] nums){
        int max = Arrays.stream(nums).reduce((x, y) -> Math.max(x, y)).getAsInt();
        int count = 0;
        while(max != 0){
            count ++;
            max /= 10;
        }
        return count;
    }
}
