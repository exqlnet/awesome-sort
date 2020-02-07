package top.exql.sort.sorter;

import java.util.Arrays;

/**
 * @BelongsProject: awesome-sort
 * @Author: exqlnet
 * @CreateTime: 2020-02-07 18:39
 * @Description: 基数排序
 */
public class EBaseSorter implements ESorter {

    @Override
    public int[] sort(int[] arr) {
        int[] nums = new int[arr.length];
        System.arraycopy(arr, 0, nums, 0, nums.length);

        int[][] hashArray = new int[10][nums.length];
        int[] hashIndex = new int[10];
        int numsIndex;

        int i;
        boolean out;
        int rank = 0;
        while (true) {
            out = true;
            for (int num : nums) {
                int base = (int) Math.pow(10, rank);
                if (num > base * 10) {
                    out = false;
                }
                i = num / (base) % 10;
                hashArray[i][hashIndex[i]] = num;
                hashIndex[i]++;
            }

            numsIndex = 0;
            for (int j = 0; j < 10; j++) {
                int length = hashIndex[j];
                for (int k = 0; k < length; k++) {
                    nums[numsIndex++] = hashArray[j][k];
                }
                hashIndex[j] = 0;
            }

            System.out.println(Arrays.toString(nums));

            if (out) {
                break;
            }
            rank++;
        }

        return nums;
    }
}
