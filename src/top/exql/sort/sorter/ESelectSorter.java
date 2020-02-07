package top.exql.sort.sorter;

/**
 * @BelongsProject: awesome-sort
 * @Author: exqlnet
 * @CreateTime: 2020-02-06 20:10
 * @Description: 选择排序
 *
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 */

public class ESelectSorter implements ESorter {

    @Override
    public int[] sort(int[] nums) {
        int tmp;
        int a, b;
        int[] newNums = new int[nums.length];
        System.arraycopy(nums, 0, newNums, 0, nums.length);
        for (a = 0; a < newNums.length; a ++) {
            for (b = a; b < newNums.length; b++) {

                if (newNums[b] < newNums[a]) {
                    tmp = newNums[b];
                    newNums[b] = newNums[a];
                    newNums[a] = tmp;
                }
            }
        }
        return newNums;
    }
}
