package top.exql.sort.sorter;

/**
 * @BelongsProject: awesome-sort
 * @Author: exqlnet
 * @CreateTime: 2020-02-07 11:52
 * @Description: 计数排序
 *
 * 时间复杂度：O(n) = O(n+n)
 * 空间复杂度：O(最大值)
 */
public class ECountSorter implements ESorter{

    @Override
    public int[] sort(int[] nums) {
        // 找到最大值
        int max = nums[0];
        for (int num: nums) {
            if (num > max) max = num;
        }

        int[] tmp = new int[max+1];

        for (int num: nums) {
            tmp[num] += 1;
        }

        int i = 0;
        int t = 0;
        int n;
        while (t<tmp.length) {
            n = 0;
            while (n<tmp[t]) {
                nums[i++] = t;
                n++;
            }
            t++;
        }
        return nums;
    }
}
