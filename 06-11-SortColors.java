class Solution {
    public void sortColors(int[] nums) {
        int len = nums.length;
        int i = 0, j = len - 1, k = 0;
        while (k <= j) {
            if (nums[k] == 0) swap(nums, i++, k);
            if (nums[k] == 2) swap(nums, j--, k);
            else k++;
        }

    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}