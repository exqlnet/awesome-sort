package top.exql.sort.sorter;

import java.util.Arrays;

/**
 * @BelongsProject: awesome-sort
 * @Author: exqlnet
 * @CreateTime: 2020-02-06 19:18
 * @Description: 插入排序
 * * 时间复杂度：O(n^2)
 * * 最优情况（逆序数为0）：n
 * * 最差情况（逆序数为n）：n(n-1)/2 = 1 + 2 + 3 + 4 + ... + n - 1
 */
public class EInsertSorter implements ESorter{

    @Override
    public int[] sort(int[] nums) {
        int tmp;
        int a, b;
        int[] newNums = new int[nums.length];
        System.arraycopy(nums, 0, newNums, 0, nums.length);

        for (a = 1; a < newNums.length; a++) {
            tmp = newNums[a];
            for (b = a; b > 0 && tmp < newNums[b-1]; b--) {
                newNums[b] = newNums[b-1];
            }
            newNums[b] = tmp;
        }

        return newNums;
    }
}
