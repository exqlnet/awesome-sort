package top.exql.sort.sorter;

import java.util.Arrays;

/**
 * @BelongsProject: awesome-sort
 * @Author: exqlnet
 * @CreateTime: 2020-02-07 10:58
 * @Description: 归并排序
 * 整个过程类似于一棵树，每一层的T(n) = n，共log2(n)层
 * 时间复杂度：O(nlog2(n))
 * 空间复杂度：O(n)
 */
public class EMergeSorter implements ESorter{
    @Override
    public int[] sort(int[] nums) {
        int[] tmp = new int[nums.length];
        int[] newNums = new int[nums.length];
        System.arraycopy(nums, 0, newNums, 0, nums.length);

        sort(newNums, 0, newNums.length - 1, tmp);
        return newNums;
    }

    private void sort(int[] nums, int left, int right, int[] tmp) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(nums, left, mid, tmp);
            sort(nums, mid + 1, right, tmp);
            merge(nums, left, mid, right, tmp);
        }
    }

    public void merge(int[] arr, int left, int mid, int right, int[] tmp) {
        // arr1: [left, mid]
        // arr2: [mid+1, right]
        int t = 0; // tmp数组索引
        int i = left; // 左序列索引
        int j = mid + 1; // 右序列索引

        while (i<=mid && j<=right) {
            if (arr[i] < arr[j]) {
                tmp[t++] = arr[i++];
            } else {
                tmp[t++] = arr[j++];
            }
        }

        // 左序列或右序列其中一个被填充完到tmp，把另一序列剩余元素填充到tmp

        while (i <= mid) {
            tmp[t++] = arr[i++];
        }

        while (j <= right) {
            tmp[t++] = arr[j++];
        }

        System.arraycopy(tmp, 0, arr, left, right - left + 1);
    }
}
