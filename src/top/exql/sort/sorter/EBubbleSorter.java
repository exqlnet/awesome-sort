package top.exql.sort.sorter;


public class EBubbleSorter implements ESorter {

    @Override
    public int[] sort(int[] nums) {
        int i, j;
        int[] newNums = new int[nums.length];
        System.arraycopy(nums, 0, newNums, 0, nums.length);

        i = 0;
        while (i < newNums.length) {
            j = newNums.length - 1;
            while (j > i) {
                if (newNums[j] < newNums[j-1]) {
                    swap(newNums, j, j-1);
                }
                j--;
            }
            i++;
        }


        return newNums;
    }

    private void swap(int[] nums, int a, int b) {
        int tmp;
        tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
