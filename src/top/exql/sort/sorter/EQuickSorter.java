package top.exql.sort.sorter;

import java.util.Random;

/**
 * @BelongsProject: awesome-sort
 * @Author: exqlnet
 * @CreateTime: 2020-02-06 20:10
 * @Description: 快速排序 递归法
 */
public class EQuickSorter implements ESorter{

    @Override
    public int[] sort(int[] nums) {
        int tmp;
        int a, b;
        int[] newNums = new int[nums.length];
        System.arraycopy(nums, 0, newNums, 0, nums.length);

        quickSort(newNums, 0, newNums.length - 1);
        return newNums;
    }

    private void quickSort(int[] nums, int start, int end) {
        int length = end - start + 1;

        if (length == 1 || length == 0) {
            return;
        }
        int randPosition;
        int i, j;
        randPosition = (int) (start + Math.random()*(end - start));
        swap(nums, start, randPosition);

        for (i = start,j = end; i < j; j--) {
            if (nums[j] < nums[start]) {
                for(;j > i; i++) {
                    if (nums[i] > nums[start]) {
                        swap(nums, j, i);
                        break;
                    }
                }
            }
        }

        swap(nums, start, i);
        quickSort(nums, start, i - 1);
        quickSort(nums, i + 1, end);
    }

    private void swap(int[] nums, int a, int b) {
        int tmp;
        tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
