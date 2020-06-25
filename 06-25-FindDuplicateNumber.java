class Solution {
    public int findDuplicate(int[] nums) {
        for (int i : nums) {
            i = i < 0 ? i * -1 : i;
            if (nums[i] < 0) return i;
            nums[i] *= -1;
        }
        return 0;
    }
}